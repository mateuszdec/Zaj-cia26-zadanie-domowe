import java.sql.*;

public class TransactionDao {

    public void add(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "INSERT INTO transaction(type, description, amount, date)" +
                    "VALUES (?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas dodania do bazy: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public void modification(Transaction transaction) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "UPDATE transaction SET type = ?, description = ?, amount = ?, date = ? WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, transaction.getType());
            preparedStatement.setString(2, transaction.getDescription());
            preparedStatement.setDouble(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getDate());
            preparedStatement.setLong(5, transaction.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas dodania do bazy: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public void deleteTransaction(long id) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "DELETE FROM transaction WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas dodania do bazy: " + e.getMessage());
        }
        closeConnection(connection);
    }

    public Transaction showRevenue(String type) {
        Connection connection = connect();

        PreparedStatement preparedStatement = null;
        try {
            String sql = "SELECT * FROM transaction WHERE type = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, type);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                long id = resultSet.getLong("id");
                String typeFromDb = resultSet.getString("type");
                String description = resultSet.getString("description");
                Double amount = resultSet.getDouble("amount");
                String date = resultSet.getString("date");

                Transaction transaction = new Transaction(id, typeFromDb, description, amount, date);
                return transaction;
            }
        } catch (SQLException e) {
            System.out.println("Niepowodzenie podczas dodania do bazy: " + e.getMessage());
        }
        closeConnection(connection);
        return null;
    }



    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/home_budget?characterEncoding=utf8&serverTimezone=UTC&useSSL=false";
        try {
            return DriverManager.getConnection(url, "root", "admin");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
