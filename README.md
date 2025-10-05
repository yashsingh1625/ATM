# 🏧 ATM Machine (Java + MySQL)

A simple ATM simulation project built in **Java (Swing GUI)** and connected with a **MySQL database**.  
This project allows users to log in, check balance, deposit, and withdraw money — similar to a real ATM.

---

## 🚀 Features
- 🔐 **User Login** (Account Number + PIN)
- 💰 **Deposit / Withdraw / Check Balance**
- 🗃️ **MySQL Database Integration**
- 🖥️ **Interactive Swing GUI**
- ✅ Secure database operations using PreparedStatements

---

## 🏗️ Project Architecture

+-------------------+ +-----------------+ +-------------------+
| ATMGUI.java | <---> | DBConnection | <---> | MySQL Database |
| (Swing GUI) | | (JDBC CRUD) | | atmdb.accounts |
+-------------------+ +-----------------+ +-------------------+
| |
| User Input (Account/Pin) |
|---------------------------->|
| |
| Fetch Account Data |
|<----------------------------|
| |
| Deposit / Withdraw / Balance|
|---------------------------->|
| |
| Update Account Balance |
|---------------------------->|

yaml
Copy code

### 💡 How it Works:
1. **ATMGUI.java**: User interacts with this GUI. Login, deposit, withdraw, check balance.  
2. **DBConnection.java**: Handles all database operations (get account, update balance) using JDBC.  
3. **MySQL Database (`atmdb`)**: Stores account details (account number, PIN, balance).

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository
```bash
git clone https://github.com/yashsingh1625/ATM.git
cd ATM
2️⃣ Configure MySQL
Create a database named atmdb:

sql
Copy code
CREATE DATABASE atmdb;
USE atmdb;

CREATE TABLE accounts (
  account_number VARCHAR(20) PRIMARY KEY,
  pin VARCHAR(10),
  balance DOUBLE
);
Insert sample data:

sql
Copy code
INSERT INTO accounts VALUES ('12345', '1111', 5000.00);
INSERT INTO accounts VALUES ('67890', '2222', 10000.00);
3️⃣ Update Database Credentials
In the DBConnection.java file:

java
Copy code
private static final String USER = "root";
private static final String PASSWORD = "your_mysql_password";
4️⃣ Run the Application
bash
Copy code
javac ATMGUI.java
java ATMGUI
📸 GUI Preview
(You can later add screenshots of your app here.)

🧑‍💻 Author
Yash Singh
📧 yashashwisinghqwaopl@gmail.com
🌐 GitHub Profile

