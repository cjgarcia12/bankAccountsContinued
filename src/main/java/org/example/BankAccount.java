package org.example;

import java.util.Scanner;

public class BankAccount {
    private double balance;
    private String accountHolderName;
    private int accountNumber;

    public BankAccount(double balance, String accountHolderName, int accountNumber) {
        this.balance = balance;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
    }

    public BankAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you an existing customer? (0 to exit)\n1. Yes\n2. No");
        int choice = scanner.nextInt();
        if (choice == 1) {
            System.out.println("Please enter your account number");
            this.accountNumber = scanner.nextInt();
            this.accountHolderName = "John Doe 3";
            this.balance = 1000;
        } else if (choice == 2) {
            System.out.println("Let's make a new account!\nWhat is the name for the account?");
            this.accountHolderName = scanner.next();
            System.out.println("What is the beginning balance for the account?");
            this.balance = scanner.nextDouble();
            this.accountNumber = (int) System.currentTimeMillis();

        } else {
            System.out.println("Goodbye!");
        }

    }

    public void bankTransfer(BankAccount account, double amount) {
        this.balance -= amount;
        account.deposit(amount);

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Your balance is now " + this.balance);
    }

    public void withdrawal(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
            System.out.println("Your balance is now " + this.balance);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    @Override
    public String toString() {
        return "Account Holder: " + this.accountHolderName + ", Balance: " + this.balance;
    }




}