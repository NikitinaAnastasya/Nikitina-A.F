import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBWorker {
    private final String HOST = "jbc:mysql://127.0.0.1:3306/magaz";
    private final String USER = "root";
    private final String PASS = "root";

    private Connection connect;
    public DBWorker(){
        try{
            connect = DriverManager.getConnection(HOST,USER,PASS);
            if (!connect.isClosed()){
                System.out.println("Присоединение к БД успешно!");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Connection getConnect(){
        return connect;
    }
}
