package test.repository;

import test.DBWorker;
import test.domain.Tovar;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TovarRepository implements Repository<Tovar>{

    private final DBWorker connector;

    public TovarRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Tovar find(Long id) throws SQLException {
        String show="select t.*, s.id_postav from tovar_v_otdel t\n" +
                "left join sklad s on t.id_tovar = s.id_tovar\n" +
                "where t.id_tovar ="+id;
        Statement statement =connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        if(resultSet.next()){

        String name = resultSet.getString("name");
        long id_otdel = resultSet.getLong("id_otdel");
        float cena = resultSet.getFloat("cena");
        int kolvo = resultSet.getInt("kolvo");
        long id_postav = resultSet.getLong("id_postav");

            return new Tovar(id,name,cena,kolvo,id_otdel,id_postav);}
        else {
            return null;
        }
    }

    @Override
    public void save(Tovar obj) throws SQLException {
        String save = "insert into tovar_v_otdel (name, id_otdel, cena, kolvo,id_tovar) values (?,?,?,?,?)";
        PreparedStatement preparedStatement =connector.getConnect().prepareStatement(save);

        preparedStatement.setString(1,obj.getNaztov());
        preparedStatement.setLong(2, obj.getId_otdel());
        preparedStatement.setFloat(3,obj.getCena());
        preparedStatement.setInt(4,obj.getKolvo());
        preparedStatement.setLong(5,obj.getId());

        preparedStatement.execute();
    }

    @Override
    public void delete(Tovar obj) throws SQLException {
        String delete ="delete from tovar_v_otdel where id_tovar="+obj.getId();
        Statement statement =connector.getConnect().createStatement();
        statement.execute(delete);
    }

    @Override
    public List<Tovar> list() throws SQLException {
        List<Tovar> list = new ArrayList<>();

        String show ="select t.*, s.id_postav from tovar_v_otdel t\n" +
                "left join sklad s on t.id_tovar = s.id_tovar";
        Statement statement =connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id_tovar");
            String name = resultSet.getString("name");
            float cena = resultSet.getFloat("cena");
            int kolvo = resultSet.getInt("kolvo");
            long id_otdel = resultSet.getLong("id_otdel");
            long id_postav = resultSet.getLong("id_postav");

            list.add(new Tovar(id,name,cena,kolvo,id_otdel,id_postav));
        }

        return list;
    }

    @Override
    public void update(Tovar obj) throws SQLException {
        String update ="update tovar_v_otdel set name=?, id_otdel=?,cena=?,kolvo=? where id_tovar=" +obj.getId();
        PreparedStatement preparedStatement = connector.getConnect().prepareStatement(update);

        preparedStatement.setString(1,obj.getNaztov());
        preparedStatement.setLong(2,obj.getId_otdel());
        preparedStatement.setFloat(3,obj.getCena());
        preparedStatement.setInt(4,obj.getKolvo());

        preparedStatement.execute();
    }

    @Override
    public List<Tovar> getListPoId(Long id) throws SQLException {
        List<Tovar> list =new ArrayList<>();
        String show = "select t.*, s.id_postav from tovar_v_otdel t\n" +
                "left join sklad s on t.id_tovar = s.id_tovar\n" +
                "where t.id_otdel ="+id;
        Statement statement = connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id_tovar = resultSet.getLong("id_tovar");
            String name = resultSet.getString("name");
            float cena = resultSet.getFloat("cena");
            int kolvo = resultSet.getInt("kolvo");
            long id_otdel = resultSet.getLong("id_otdel");
            long id_postav = resultSet.getLong("id_postav");

            list.add(new Tovar(id_tovar,name,cena,kolvo,id_otdel,id_postav));
        }
        return list;
    }

    @Override
    public List<Tovar> getListNoId() {
        return null;
    }

    @Override
    public List<Tovar> getListPoIdPostav(Long id) {
        return null;
    }
}
