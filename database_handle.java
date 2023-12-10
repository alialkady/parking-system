import java.sql.*;
import java.time.LocalDateTime;

public class database_handle {
    // JDBC URL, username, and password of SQL Server
    private static final String JDBC_URL = "jdbc:sqlserver://DESKTOP-FCEDQJG:1433;databaseName=parking_system;encrypt=false;trustServerCertificate=true";
    private static final String USER = "alialkady";
    private static final String PASSWORD = "Aa22540444";

    // insert methods
    public static void insertOperatorData(String name,String pass,int shift) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO operator (username, password,shift_time) VALUES (?, ?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,pass);
                preparedStatement.setInt(3,shift);
                preparedStatement.executeUpdate();

                System.out.println("Data inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertCustomerData(int entry_id,int plate_number) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO operator (entry_id, plate_number,transaction_date) VALUES (?, ?,?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1,entry_id);
                preparedStatement.setInt(2,plate_number);
                preparedStatement.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                preparedStatement.executeUpdate();

                System.out.println("Data inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertSpot(int spot, String spot_free) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO operator (spot, spot_free) VALUES (?, ?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1,spot);
                preparedStatement.setString(2,spot_free);
                preparedStatement.executeUpdate();

                System.out.println("Data inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void insertPayment(double shiftPayment) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String insertQuery = "INSERT INTO operator (shifts_payment) VALUES (?)";

            try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
                preparedStatement.setDouble(1,shiftPayment);

                preparedStatement.executeUpdate();

                System.out.println("Data inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//retrieve method
    public static void retrieveData(String table) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String selectQuery = "SELECT * FROM "+table;

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    if(table=="operator"){
                        String username = resultSet.getString("username");
                        String password= resultSet.getString("password");
                        int shift = resultSet.getInt("shift_time");
                        System.out.println("username: "+ username+'\n'+"password: "+password+'\n'+"shift: "+shift);
                    }
                    else if(table=="customers"){
                        int entry_id = resultSet.getInt("entry_id");
                        int plate_number = resultSet.getInt("plate_number");
                        //here's write transaction date but i have problem with the datatype
                        System.out.println("entry id: "+entry_id+'\n'+"plate number: "+plate_number+'\n'); // you have to print also the transaction date
                    }
                    else if(table=="spots"){
                        int spots =resultSet.getInt("spot");
                        String spot_free =resultSet.getString("spot_free");
                        System.out.println("spot number: "+spots+"is "+ spot_free);
                    }
                    else if(table =="payment"){
                        double shift_payment = resultSet.getDouble("shift_payment");
                        System.out.println("shift_payment is "+shift_payment);
                    }


                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void updateData(int id, String newSkills) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String updateQuery = "UPDATE users SET Skills = ? WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, newSkills);
                preparedStatement.setInt(2, id);
                preparedStatement.executeUpdate();

                System.out.println("Data updated successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteData(int id) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            String deleteQuery = "DELETE FROM users WHERE id = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();

                System.out.println("Data deleted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

