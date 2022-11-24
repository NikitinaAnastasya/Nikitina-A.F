package ru.vsuet.sample.repository;

import ru.vsuet.sample.domain.Box;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoxRepository implements Repository<Box> {

    private final Connection connection;


    public BoxRepository(DataBaseConnector connector) {
        this.connection = connector.getConnection();
    }

    @Override
    public Box find(Long id) {
        return null;
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
                long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                Box box = new Box(id, name);
                boxes.add(box);
            }
            return boxes;
        } catch (SQLException e) {
            throw new RuntimeException("Error while method list call: " + e.getMessage());
        }
    }
}
