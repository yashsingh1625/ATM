

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/atmdb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root"; // your MySQL username
    private static final String PASSWORD = "12Qw@90opl"; // your MySQL password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static Account getAccount(String accountNumber) {
        try (Connection conn = getConnection()) {
            String query = "SELECT * FROM accounts WHERE account_number = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String accNum = rs.getString("account_number");
                String pin = rs.getString("pin");
                double balance = rs.getDouble("balance");
                return new Account(accNum, pin, balance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void updateBalance(Account account) {
        try (Connection conn = getConnection()) {
            String query = "UPDATE accounts SET balance = ? WHERE account_number = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, account.getBalance());
            stmt.setString(2, account.getAccountNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
