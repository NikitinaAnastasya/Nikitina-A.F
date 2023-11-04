package ru.vsuet.sample.repository;

import ru.vsuet.sample.domain.Box;
import ru.vsuet.sample.domain.Fruit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BoxRepository implements Repository<Box> {

    private final Connection connection;


    public BoxRepository(DataBaseConnector connector) {
        this.connection = connector.getConnection();
    }

    @Override
    public Box find(Long id) {
        String query = "select * from box b " +
                "join fruit f on b.id = f.box_id " +
                "where b.id = ?";
        try (
                PreparedStatement statement = connection.prepareStatement(query)
        ) {
            statement.setLong(1, id);
            ResultSet resultSet = statement.executeQuery();
            Map<Box, List<Fruit>> boxes = new HashMap<>();
            while (resultSet.next()) {
                Box box = boxExtractor.extract(resultSet);
                List<Fruit> fruits = boxes.getOrDefault(box, new ArrayList<>());
                Fruit fruit = fruitExtractor.extract(resultSet);
                fruits.add(fruit);
                boxes.put(box, fruits);
            }
            return boxes.entrySet().stream()
                    .map(e -> {
                        Box key = e.getKey();
                        return new Box(key.getId(), key.getName(), e.getValue());
                    })
                    .collect(Collectors.toList())
                    .get(0);
        } catch (SQLException e) {
            throw new RuntimeException("Error while method find call: " + e.getMessage());
        }
    }

    @Override
    public void save(Box source) {

    }

    @Override
    public void remove(Box target) {

    }

    @Override
    public List<Box> list() {
        String query = "select * from box";
        try (
                PreparedStatement statement = connection.prepareStatement(query);
        ) {
            ResultSet resultSet = statement.executeQuery();
            List<Box> boxes = new ArrayList<>();
            while (resultSet.next()) {
                Box box = boxExtractor.extract(resultSet);
                boxes.add(box);
            }
            return boxes;
        } catch (SQLException e) {
            throw new RuntimeException("Error while method list call: " + e.getMessage());
        }
    }

    private final ResultSetExtractor<Box> boxExtractor = resultSet -> {
        long id = resultSet.getLong("box.id");
        String name = resultSet.getString("box.name");
        return new Box(id, name);
    };

    private final ResultSetExtractor<Fruit> fruitExtractor = resultSet -> {
        long id = resultSet.getLong("fruit.id");
        String name = resultSet.getString("fruit.name");
        return new Fruit(id, name);
    };


}
