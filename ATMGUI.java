

import javax.swing.*;
import java.awt.*;

public class ATMGUI extends JFrame {
    private JTextField accountField;
    private JPasswordField pinField;
    private JButton loginButton;

    public ATMGUI() {
        setTitle("ATM Machine");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 2, 10, 10));

        add(new JLabel("Account Number:"));
        accountField = new JTextField();
        add(accountField);

        add(new JLabel("PIN:"));
        pinField = new JPasswordField();
        add(pinField);

        loginButton = new JButton("Login");
        add(new JLabel()); // empty cell
        add(loginButton);

        // Login button action
        loginButton.addActionListener(_ -> {
            String accNum = accountField.getText().trim();
            String pin = new String(pinField.getPassword());

            Account account = DBConnection.getAccount(accNum);

            if (account != null && account.validatePin(pin)) {
                JOptionPane.showMessageDialog(this, "✅ Login Successful!");
                openTransactionWindow(account);
            } else {
                JOptionPane.showMessageDialog(this, "❌ Invalid Account or PIN!");
            }
        });
    }

    private void openTransactionWindow(Account account) {
        JFrame frame = new JFrame("ATM - Transactions");
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(5, 2, 10, 10));
        frame.setLocationRelativeTo(null);

        JLabel balanceLabel = new JLabel("Balance: ₹" + account.getBalance());
        JTextField amountField = new JTextField();
        JButton depositButton = new JButton("Deposit");
        JButton withdrawButton = new JButton("Withdraw");
        JButton checkBalanceButton = new JButton("Check Balance");
        JButton logoutButton = new JButton("Logout");

        frame.add(balanceLabel);
        frame.add(new JLabel());
        frame.add(new JLabel("Enter Amount:"));
        frame.add(amountField);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(checkBalanceButton);
        frame.add(logoutButton);

        // Deposit action
        depositButton.addActionListener(_ -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                account.deposit(amt);
                DBConnection.updateBalance(account); // update DB
                balanceLabel.setText("Balance: ₹" + account.getBalance());
                JOptionPane.showMessageDialog(frame, "Deposited ₹" + amt);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Enter a valid amount!");
            }
        });

        // Withdraw action
        withdrawButton.addActionListener(_ -> {
            try {
                double amt = Double.parseDouble(amountField.getText());
                if (account.withdraw(amt)) {
                    DBConnection.updateBalance(account); // update DB
                    balanceLabel.setText("Balance: ₹" + account.getBalance());
                    JOptionPane.showMessageDialog(frame, "Withdrawn ₹" + amt);
                } else {
                    JOptionPane.showMessageDialog(frame, "Insufficient balance!");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame, "Enter a valid amount!");
            }
        });

        // Check balance
        checkBalanceButton.addActionListener(_ ->
                JOptionPane.showMessageDialog(frame, "Your balance: ₹" + account.getBalance())
        );

        // Logout
        logoutButton.addActionListener(_ -> {
            frame.dispose();
            JOptionPane.showMessageDialog(frame, "You have been logged out.");
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ATMGUI().setVisible(true);
    }
}
