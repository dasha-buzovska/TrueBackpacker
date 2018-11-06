package backpacker;

import java.sql.*;

public class MainClassForSpark {

    private static String URL = "jdbc:mysql://localhost:3306/backpacker";
    private static String username = "root";
    private static String password = "root";
    private static String driver = "com.mysql.jdbc.Driver";

    public static void main(String[] args) throws SQLException {
        insertRecordIntoTable();
        selectRecordFromTable();
    }

    private static void insertRecordIntoTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;

        String insertTableSQL = "INSERT INTO user (id, name, age, country, profession, admin) " +
                "VALUES (?,?,?,?,?,?);";

        try {
            dbConnection = getDBConnection();
            preparedStatement = dbConnection.prepareStatement(insertTableSQL);

            preparedStatement.setInt(1, 3);
            preparedStatement.setString(2, "Ann");
            preparedStatement.setInt(3, 32);
            preparedStatement.setString(4, "US");
            preparedStatement.setString(5, "Model");
            preparedStatement.setBoolean(6, false);

            // execute insert SQL statement
            preparedStatement.executeUpdate();

            System.out.println("Record is inserted into DBUSER table!");

        } catch (SQLException e) {

            System.out.println(e.getMessage());

        } finally {

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (dbConnection != null) {
                dbConnection.close();
            }

        }

    }

    private static void selectRecordFromTable() throws SQLException {

        Connection dbConnection = null;
        PreparedStatement preparedStatement = null;
        Statement st = null;

        try {
            dbConnection = getDBConnection();
            String query = "SELECT * FROM user";
            st = dbConnection.createStatement();

            ResultSet rs = st.executeQuery(query);
            while (rs.next())
            {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String country = rs.getString("country");
                String profession = rs.getString("profession");
                boolean isAdmin = rs.getBoolean("admin");

                System.out.format("%s, %s, %s, %s, %s, %s\n", id, name, age, country, profession, isAdmin);
            }
            st.close();
        } catch (SQLException e) {

            System.out.println(e.getMessage());

        }
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            dbConnection = DriverManager.getConnection(
                    URL, username, password);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    private static java.sql.Timestamp getCurrentTimeStamp() {

        java.util.Date today = new java.util.Date();
        return new java.sql.Timestamp(today.getTime());

    }

}
