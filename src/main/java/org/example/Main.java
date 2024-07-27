package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public static void mainMenu(BankAccount account) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello " + account.getAccountHolderName() + "\nWelcome to the Main Menu, what would you " +
                "like to do today?");

        boolean stop = false;

        while (!stop) {
            System.out.println("1: To check account balance\n2: To make a withdraw\n3: To make a deposit\n4: " +
                    "To make a transfer to another account\n0: to exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("account balance: " + account.getBalance());
                    break;
                case 2:
                    System.out.println("How much would you like to withdraw?");
                    double amount = scanner.nextDouble();
                    account.withdrawal(amount);
                    break;
                case 3:
                    System.out.println("How much would you like to deposit?");
                    double amount1 = scanner.nextDouble();
                    account.deposit(amount1);
                    break;
                case 4:
                    System.out.println("Please enter the account number you want to transfer to");
                    int accountNumber = scanner.nextInt();
                    BankAccount transferAccount = null;

                    boolean accountFound = false;
                    for (BankAccount bankAccount : bankAccounts) {
                        if (bankAccount.getAccountNumber() == accountNumber) {
                            transferAccount = bankAccount;
                            accountFound = true;
                            break;
                        }
                    }
                    if (!accountFound) {
                        System.out.println("Account not found");
                    } else {
                        System.out.println("Please enter the amount you want to transfer");
                        double amount2 = scanner.nextDouble();
                        account.bankTransfer(transferAccount, amount2);
                        System.out.println(account);
                        System.out.println(transferAccount);
                    }

                    break;
                case 0:
                    System.out.println("Goodbye!");
                    stop = true;
                    break;
            }

        }



    }
    public static void main(String[] args) {
        bankAccounts.add(new BankAccount(100.0, "John Doe", 1));
        bankAccounts.add(new BankAccount(200.0, "Jane Doe2", 2));

        bankAccounts.add(new BankAccount());
        mainMenu(bankAccounts.get(2));
    }
}