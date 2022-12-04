package test.repository;

import test.DBWorker;
import test.domain.Prodavec;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdavecRepository implements  Repository<Prodavec> {
    private final DBWorker connector;

    public ProdavecRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Prodavec find(Long id) throws SQLException {
        String show = "select * from prodavec where id= "+ id;
        Statement statement= connector.getConnect().createStatement();
        ResultSet resultSet= statement.executeQuery(show);
        resultSet.next();

        String name = resultSet.getString("name");
        String pol = resultSet.getString("pol");
        int zp = resultSet.getInt("zp");
        long id_otdel = resultSet.getLong("id_otdel");

        return  new Prodavec(id, name, pol,zp, id_otdel);
    }

    @Override
    public void save(Prodavec obj) throws SQLException {
        String save = "insert into prodavec (name, pol, zp, id_otdel) values (?, ?,?, ?)";
        PreparedStatement preparedStatement = connector.getConnect().prepareStatement(save);

        preparedStatement.setString(1, obj.getName());
        preparedStatement.setString(2, obj.getPol());
        preparedStatement.setInt(3,obj.getZp());
        preparedStatement.setLong(4,obj.getId_otdel());

        preparedStatement.execute();
    }

    @Override
    public void delete(Prodavec obj) throws SQLException {
        String delete =" delete from prodavec where id = "+ obj.getId();
        Statement statement = connector.getConnect().createStatement();
        statement.execute(delete);
    }

    @Override
    public List<Prodavec> list() throws SQLException {
        List<Prodavec> list = new ArrayList<>();
        String show ="select * from prodavec";
        Statement statement = connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String pol = resultSet.getString("pol");
            int zp = resultSet.getInt("zp");
            long id_otdel = resultSet.getLong("id_otdel");

            list.add(new Prodavec(id, name, pol, zp,id_otdel));
        }
        return list;
    }

    @Override
    public void update(Prodavec obj) throws SQLException {
        String show = "update prodavec set name=?, pol=?, zp=?, id_otdel=? where id=" + obj.getId();
        PreparedStatement preparedStatement = connector.getConnect().prepareStatement(show);

        preparedStatement.setString(1, obj.getName());
        preparedStatement.setString(2, obj.getPol());
        preparedStatement.setInt(3,obj.getZp());
        preparedStatement.setLong(4, obj.getId_otdel());

        preparedStatement.execute();
    }

    @Override
    public List<Prodavec> getListPoId(Long id) throws SQLException {
        List<Prodavec> list = new ArrayList<>();
        String show ="select * from prodavec id_otdel where id ="+id;
        Statement statement = connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){
            long id1 = resultSet.getLong("id");
            String name = resultSet.getString("name");
            String pol = resultSet.getString("pol");
            int zp = resultSet.getInt("zp");
            long id_otdel = resultSet.getLong("id_otdel");

            list.add(new Prodavec(id1, name, pol, zp,id_otdel));
        }
        return list;
    }

    @Override
    public List<Prodavec> getListNoId() {
        return null;
    }

    @Override
    public List<Prodavec> getListPoIdPostav(Long id) {
        return null;
    }
}
