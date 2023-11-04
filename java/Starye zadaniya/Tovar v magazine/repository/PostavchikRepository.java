package test.repository;

import test.DBWorker;
import test.domain.Postavchik;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PostavchikRepository implements Repository<Postavchik>{

    private final DBWorker connector;

    public PostavchikRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Postavchik find(Long id) throws SQLException {
        String show = "select * from postav where id = "+ id;
        Statement statement= connector.getConnect().createStatement();
        ResultSet resultSet= statement.executeQuery(show);
        resultSet.next();

        String name = resultSet.getString("name");
        long telefon = resultSet.getLong("telefon");

        return new Postavchik(id, name, telefon);

    }

    @Override
    public void save(Postavchik obj) throws SQLException {
        String save = "insert into postav( name, telefon) values (?,?)";
        PreparedStatement preparedStatement=connector.getConnect().prepareStatement(save);

        preparedStatement.setString(1, obj.getName());
        preparedStatement.setLong(2,obj.getTelefon());

        preparedStatement.execute();
    }

    @Override
    public void delete(Postavchik obj) throws SQLException {
        String delete = "delete from postav where id= "+ obj.getId();
        String update = "update sklad set id_postav=0 where id_postav ="+obj.getId();

        Statement statement = connector.getConnect().createStatement();
        statement.execute(delete);
        statement.execute(update);

    }

    @Override
    public List<Postavchik> list() throws SQLException {
        List<Postavchik>  list= new ArrayList<>();
        String show = "select * from postav ";
        Statement statement= connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){
            long id = resultSet.getLong("id");
            String name = resultSet.getString("name");
            long telefon = resultSet.getLong("telefon");

            list.add(new Postavchik(id, name, telefon));
        }
        return list;
    }

    @Override
    public void update(Postavchik obj) throws SQLException {
        String show = "update postav set name = ?, telefon=? where id="+obj.getId();
        PreparedStatement preparedStatement= connector.getConnect().prepareStatement(show);

        preparedStatement.setString(1, obj.getName());
        preparedStatement.setLong(2,obj.getTelefon());

        preparedStatement.execute();
    }

    @Override
    public List<Postavchik> getListPoId(Long id) throws SQLException{
        return null;
    }

    @Override
    public List<Postavchik> getListNoId() {
        return null;
    }

    @Override
    public List<Postavchik> getListPoIdPostav(Long id) {
        return null;
    }
}
