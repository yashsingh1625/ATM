public class Main {
    public static void main(String[] args) {
        // Creating a test account (You can change these values)
        Account account = new Account("12345", "1111", 5000.0);

        // Create ATM object and start ATM process
        ATM atm = new ATM(account);
        atm.start();
    }
}
