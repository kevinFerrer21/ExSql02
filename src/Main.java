import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement;

        try {
            String DB_URL = "jdbc:mysql://localhost:3306/newdb";
            String USER = "developer";
            String PASSWORD = "passwordhere";

            connection = DriverManager.getConnection(DB_URL, USER, PASSWORD);

            statement = connection.createStatement();

            String sql = "CREATE TABLE student(student_id INTEGER AUTO_INCREMENT NOT NULL," +
                    "last_name VARCHAR(30),first_name VARCHAR(30), PRIMARY KEY (student_id))";


            statement.executeUpdate(sql);

            statement.execute("INSERT INTO newdb.student (last_name,first_name) VALUE('mario','rossi')");
            statement.execute("INSERT INTO newdb.student (last_name,first_name) VALUE('gino','paoli')");
            statement.execute("INSERT INTO newdb.student (last_name,first_name) VALUE('giulia','pochetti')");
            statement.execute("INSERT INTO newdb.student (last_name,first_name) VALUE ('giorgia','verdi')");


        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
