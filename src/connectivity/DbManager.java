package connectivity;

import java.sql.*;

/**
 * The Database Manager is responsible for creating/closing/maintaining
 * connections to the database.
 */
public class DbManager {
    static final String JDBC_EXCEPTION = "JDBC Exception: ";
    static final String SQL_EXCEPTION = "SQL Exception: ";

    private Connection connection;

    /**
     * Open database connection
     */
    public void openConnection() {
        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/Fitshape";
            String user = "postgres", pass = "root";

            connection = DriverManager.getConnection(url, user, pass);
        } catch (ClassNotFoundException e) {
            System.err.println(JDBC_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        } catch (java.sql.SQLException e) {
            System.err.println(SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    /**
     * Close database connection
     */
    public void closeConnection() {
        try {
            connection.close();
        } catch (Exception e) {
            System.err.println(JDBC_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    /**
     * Executes a query without result.
     * @param query, the SQl query
     */
    void executeQuery(String query) {
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);
        } catch (java.sql.SQLException e) {
            System.err.println(SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
    }

    /**
     * Executes a query with result.
     * @param query, the SQL query
     */
    ResultSet doQuery(String query) {
        ResultSet result = null;
        try {
            Statement statement = connection.createStatement();
            result = statement.executeQuery(query);
        } catch (java.sql.SQLException e) {
            System.err.println(SQL_EXCEPTION + e.getMessage());
            e.printStackTrace(System.err);
        }
        return result;
    }
}
