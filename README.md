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

## 🧩 Tech Stack
- **Language:** Java (JDK 17 or above)
- **GUI Framework:** Java Swing
- **Database:** MySQL
- **Tools:** JDBC, Git, GitHub

---

## ⚙️ Setup Instructions

### 1️⃣ Clone the repository
```bash
git clone https://github.com/yashsingh1625/ATM.git
cd ATM

CREATE DATABASE atmdb;
USE atmdb;

CREATE TABLE accounts (
  account_number VARCHAR(20) PRIMARY KEY,
  pin VARCHAR(10),
  balance DOUBLE
);

