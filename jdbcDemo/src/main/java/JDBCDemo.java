import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5432/postgres";   //end route is dbname -> use ur dbname
        String username = "enter your username here";   //use your username
        String password = "enter your password here";   //use your password

        try (Connection con = DriverManager.getConnection(url, username, password);
             Statement statement = con.createStatement()) {
            
            System.out.println("Database connected");

            // 5. Write SELECT query
            String sql = "SELECT * FROM users";

            // 6. Execute query
            try (ResultSet rs = statement.executeQuery(sql)) {
                // 7. Read data row by row
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name"); // Use column names correctly
                    String email = rs.getString("email");

                    System.out.println(id + " | " + name + " | " + email);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
