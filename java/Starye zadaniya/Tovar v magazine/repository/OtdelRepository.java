package test.repository;

import test.DBWorker;
import test.domain.Otdel;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OtdelRepository implements Repository<Otdel>{

    private final DBWorker connector;

    public OtdelRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Otdel find(Long id) throws SQLException {
        String show = "select * from otdels where id ="+ id;
        Statement statement = connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);
        resultSet.next();

        String name = resultSet.getString("name");
        int nch = resultSet.getInt("nch");
        int nmin = resultSet.getInt("nmin");
        int kch = resultSet.getInt("kch");
        int kmin = resultSet.getInt("kmin");

        return new Otdel(id,name,nch,nmin,kch,kmin);
    }

    @Override
    public void save(Otdel obj) throws SQLException {
        String save ="insert into otdels (name, nch, nmin, kch, kmin) values (?,?,?,?,?)";
        PreparedStatement preparedStatement =connector.getConnect().prepareStatement(save);

        preparedStatement.setString(1, obj.getName());
        preparedStatement.setInt(2, obj.getNch());
        preparedStatement.setInt(3, obj.getNmin());
        preparedStatement.setInt(4, obj.getKch());
        preparedStatement.setInt(5, obj.getKmin());

        preparedStatement.execute();

    }

    @Override
    public void delete(Otdel obj) throws SQLException {
        String delete="delete from otdels where id="+obj.getId();
        String update="update from prodavec set id_otdel=0 where id_otdel=" +obj.getId();
        String update2="update from sklad set id_otdel=0 where id_otdel="+obj.getId();

        Statement statement = connector.getConnect().createStatement();
        statement.execute(delete);
        statement.execute(update);
        statement.execute(update2);

    }

    @Override
    public List<Otdel> list() throws SQLException {
        List<Otdel> list= new ArrayList<>();
        String show = "select * from otdels";
        Statement statement = connector.getConnect().createStatement();
        ResultSet resultSet=statement.executeQuery(show);

        while (resultSet.next()){

            Long id = resultSet.getLong("id");
            String name= resultSet.getString("name");
            int nch= resultSet.getInt("nch");
            int nmin = resultSet.getInt("nmin");
            int kch= resultSet.getInt("kch");
            int kmin= resultSet.getInt("kmin");

            list.add(new Otdel(id, name, nch, nmin, kch, kmin));
        }
        return list;
    }

    @Override
    public void update(Otdel obj) throws SQLException {
        String show  = "update otdels set name = ?, nch = ?, nmin = ?, kch = ?," +
                " kmin = ? where id =" + obj.getId();
        PreparedStatement preparedStatement = connector.getConnect().prepareStatement(show);

        preparedStatement.setString(1, obj.getName());
        preparedStatement.setInt(2, obj.getNch());
        preparedStatement.setInt(3, obj.getNmin());
        preparedStatement.setInt(4, obj.getKch());
        preparedStatement.setInt(5, obj.getKmin());

        preparedStatement.execute();

    }

    @Override
    public List<Otdel> getListPoId(Long id) throws SQLException {
        return null;
    }

    @Override
    public List<Otdel> getListNoId() {
        return null;
    }

    @Override
    public List<Otdel> getListPoIdPostav(Long id) {
        return null;
    }
}
