package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        Properties props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "123456789");

        try (Connection connection = DriverManager.getConnection(url, props);
             Statement statement = connection.createStatement()) {
            System.out.println("Connection to the database completed");
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM accommodation")) {
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String type = resultSet.getString("type");
                    String bedType = resultSet.getString("bed_type");
                    int maxGuests = resultSet.getInt("max_guests");
                    String description = resultSet.getString("description");

                    System.out.println("ID: " + id + ", Type: " + type + ", Bed Type: " + bedType +
                            ", Max Guests: " + maxGuests + ", Description: " + description);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error executing query: " + e.getMessage());
        }
    }
}