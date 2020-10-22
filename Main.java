package sample;

import java.sql.*;

public class Main
{
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/worlds?user=user&password=1234&serverTimezone=UTC")) {
            String sql = "SELECT * FROM city";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()){
                int id = result.getInt("id");
                String cityname = result.getString("cityname");
                int quantity = result.getInt("quantity");
                System.out.printf("%d %s %d", id,cityname,quantity);
                System.out.println();
            }
        }
    }
}
