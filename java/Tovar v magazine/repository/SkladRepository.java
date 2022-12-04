package test.repository;

import test.DBWorker;
import test.domain.Tovar;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SkladRepository implements Repository<Tovar>{

    private final DBWorker connector;

    public SkladRepository() {
        this.connector = new DBWorker();
    }

    @Override
    public Tovar find(Long id) throws SQLException {
        String show="select s.*,t.cena from sklad s\n" +
                "left join tovar_v_otdel t on t.id_tovar=s.id_tovar\n" +
                "where s.id_tovar ="+id;
        Statement statement = connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);
        resultSet.next();

        String name = resultSet.getString("name");
        int kolvo = resultSet.getInt("kolvo");
        float cena = resultSet.getFloat("cena");
        long id_otdel = resultSet.getLong("id_otdel");
        long id_postav = resultSet.getLong("id_postav");

        return new Tovar(id,name,cena,kolvo, id_otdel,id_postav);
    }

    @Override
    public void save(Tovar obj) throws SQLException {
        String save ="insert into sklad (name, kolvo, id_otdel, id_postav) values (?,?,?,?)";
        PreparedStatement preparedStatement = connector.getConnect().prepareStatement(save);

        preparedStatement.setString(1, obj.getNaztov());
        preparedStatement.setInt(2,obj.getKolvo());
        preparedStatement.setLong(3,obj.getId_otdel());
        preparedStatement.setLong(4, obj.getId_postav());

        preparedStatement.execute();
    }

    @Override
    public void delete(Tovar obj) throws SQLException {
        String delete="delete from sklad where  id_tovar="+obj.getId();
        String delete2="delete from tovar_v_otdel where id_tovar="+obj.getId();

        Statement statement =connector.getConnect().createStatement();
        statement.execute(delete);
        statement.execute(delete2);
    }

    @Override
    public List<Tovar> list() throws SQLException {
        List<Tovar> list = new ArrayList<>();
        String show = "select * from sklad";
        Statement statement = connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id = resultSet.getLong("id_tovar");
            String name = resultSet.getString("name");
            int kolvo = resultSet.getInt("kolvo");
            long id_otdel = resultSet.getLong("id_otdel");
            long id_postav = resultSet.getLong("id_postav");

            list.add(new Tovar(id,name,0,kolvo,id_otdel,id_postav) );
        }
        return list;
    }

    @Override
    public void update(Tovar obj) throws SQLException {
        String show = "update sklad set name=?,kolvo=?,id_otdel=?,id_postav=? where id_tovar="+obj.getId();
        PreparedStatement preparedStatement = connector.getConnect().prepareStatement(show);

        preparedStatement.setString(1,obj.getNaztov());
        preparedStatement.setInt(2,obj.getKolvo());
        preparedStatement.setLong(3,obj.getId_otdel());
        preparedStatement.setLong(4,obj.getId_postav());

        preparedStatement.execute();
    }

    @Override
    public List<Tovar> getListPoId(Long id) throws SQLException {
        List<Tovar> list = new ArrayList<>();
        String show = "select s.*,t.cena from sklad s\n" +
                "left join tovar_v_otdel t on t.id_tovar=s.id_tovar\n" +
                "where s.id_otdel =" +id;
        Statement statement = connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while(resultSet.next()){

            long id1 = resultSet.getLong("id_tovar");
            String name = resultSet.getString("name");
            int kolvo = resultSet.getInt("kolvo");
            float cena = resultSet.getFloat("cena");
            long id_otdel = resultSet.getLong("id_otdel");
            long id_postav = resultSet.getLong("id_postav");

            list.add(new Tovar(id1,name,cena, kolvo, id_otdel,id_postav));
        }
        return list;
    }

    public List<Tovar> getListNoId() throws SQLException {
        List<Tovar> list = new ArrayList<>();
        String show="select * from sklad where id_otdel =0";
        Statement statement = connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id_tovar = resultSet.getLong("id_tovar");
            String name = resultSet.getString("name");
            int kolvo = resultSet.getInt("kolvo");
            long id_otdel = resultSet.getLong("id_otdel");
            long id_postav = resultSet.getLong("id_postav");

            list.add(new Tovar(id_tovar,name,0,kolvo,id_otdel,id_postav));
        }
        return list;
    }

    @Override
    public List<Tovar> getListPoIdPostav(Long id) throws SQLException {
        List<Tovar>  list= new ArrayList<>();
        String show = "select p.name as postav, s.*,t.cena from postav p \n" +
                "left join sklad s on s.id_postav = p.id\n" +
                "left join tovar_v_otdel as t on t.id_tovar=s.id_tovar " +
                "where p.id = "+id;
        Statement statement= connector.getConnect().createStatement();
        ResultSet resultSet = statement.executeQuery(show);

        while (resultSet.next()){

            long id1 = resultSet.getLong("id_tovar");
            String name = resultSet.getString("name");
            float cena = resultSet.getFloat("cena");
            int kolvo = resultSet.getInt("kolvo");
            long id_otdel = resultSet.getLong("id_otdel");
            long id_postav = resultSet.getLong("id_postav");

            list.add(new Tovar(id1,name,cena,kolvo,id_otdel,id_postav));
        }

        return list;
    }


}