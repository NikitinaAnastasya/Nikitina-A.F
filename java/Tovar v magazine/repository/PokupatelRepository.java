package test.repository;

import test.DBWorker;
import test.domain.Pokupatel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PokupatelRepository implements Repository<Pokupatel>{

    private final DBWorker connector;

    public PokupatelRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Pokupatel find(Long id) throws SQLException {
        String show = "select * from pokupatel where id = " + id;
        Statement statement=connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);
        resultSet.next();

        Long telefon = resultSet.getLong("telefon");
        int skidka = resultSet.getInt("skidka");

        return new Pokupatel(id, telefon, skidka);
    }

    @Override
    public void save(Pokupatel obj) throws SQLException {
        String save = "insert into pokypatel (telefon, skidka) values (?, ?)";

        PreparedStatement preparedStatement= connector.getConnect().prepareStatement(save);

        preparedStatement.setLong(1, obj.getTelefon());
        preparedStatement.setInt(2,obj.getSkidka());

        preparedStatement.execute();

    }

    @Override
    public void delete(Pokupatel obj) throws SQLException {
        String delete = "delete from pokupatel where id= "+ obj.getId();

        Statement statement= connector.getConnect().createStatement();
        statement.execute(delete);

    }

    @Override
    public List<Pokupatel> list() throws SQLException {
        List<Pokupatel> list= new ArrayList<>();

        String show = "select * from pokypatel";
        Statement statement = connector.getConnect().createStatement();
        ResultSet resultSet= statement.executeQuery(show);

        while (resultSet.next()){
            long id = resultSet.getLong("id");
            Long telefon = resultSet.getLong("telefon");
           int skidka = resultSet.getInt("skidka");

           list.add(new Pokupatel(id, telefon, skidka));
        }
        return list;
    }

    @Override
    public void update(Pokupatel obj) throws SQLException {
        String show = "update pokupatel set telefon=?, skidka=? where id ="+ obj.getId();
        PreparedStatement preparedStatement = connector.getConnect().prepareStatement(show);

        preparedStatement.setLong(1, obj.getTelefon());
        preparedStatement.setInt(2, obj.getSkidka());

        preparedStatement.execute();

    }

    @Override
    public List<Pokupatel> getListPoId(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Pokupatel> getListNoId() {
        return null;
    }

    @Override
    public List<Pokupatel> getListPoIdPostav(Long id) {
        return null;
    }
}
