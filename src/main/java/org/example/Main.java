package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<BankAccount> bankAccounts = new ArrayList<>();

    public static void mainMenu(BankAccount account) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello " + account.getAccountHolderName() + "\nWelcome to the Main Menu, what would you " +
                "like to do today?");
        System.out.println("1: To check account balance\n2: To make a withdraw\n3: To make a deposit\n4: " +
                "To make a transfer to another account");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                account.getBalance();
                break;
            case 2:
                System.out.println("How much would you like to withdraw?");
                double amount = scanner.nextDouble();
                account.withdrawal(amount);
                break;
            case 3:
                System.out.println("How much would you like to deposit?");
                amount = scanner.nextDouble();
                account.deposit(amount);
                break;
            case 4:
                System.out.println("Please enter the account number you want to transfer to");
                int accountNumber = scanner.nextInt();
                boolean stop = false;
                int i = 0;
                while (!stop) {
                    if (bankAccounts.get(i).getAccountNumber() == accountNumber){
                        System.out.println("Please enter the amount you would like to transfer");
                        double transferAmount = scanner.nextDouble();
                        account.bankTransfer(bankAccounts.get(i) ,transferAmount);
                        stop = true;
                    } else {
                        System.out.println("FINISH HERE");
                    }

                }
                break;
            case 5:
                break;
        }

    }
    public static void main(String[] args) {
        bankAccounts.add(new BankAccount(100.0, "John Doe", 1));
        bankAccounts.add(new BankAccount(200.0, "Jane Doe", 2));

        mainMenu(bankAccounts.get(0));
    }
}