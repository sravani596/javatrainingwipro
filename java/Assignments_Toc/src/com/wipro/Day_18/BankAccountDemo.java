package com.wipro.Day_18;
public class BankAccountDemo {

    public static void main(String[] args) {
        // Create a bank account with an initial balance of 1000
        BankAccount account = new BankAccount(1000);

        // Create multiple threads to perform deposits and withdrawals
        Thread depositThread1 = new Thread(new DepositTask(account, 500));
        Thread depositThread2 = new Thread(new DepositTask(account, 300));
        Thread withdrawalThread1 = new Thread(new WithdrawalTask(account, 200));
        Thread withdrawalThread2 = new Thread(new WithdrawalTask(account, 400));

        // Start all threads
        depositThread1.start();
        depositThread2.start();
        withdrawalThread1.start();
        withdrawalThread2.start();
    }

    // BankAccount class with synchronized methods
    static class BankAccount {
        private int balance;

        // Constructor to initialize the balance
        public BankAccount(int balance) {
            this.balance = balance;
        }

        // Synchronized method for depositing money
        public synchronized void deposit(int amount) {
            System.out.println(Thread.currentThread().getName() + " depositing " + amount);
            balance += amount;
            System.out.println("New balance after deposit: " + balance);
        }

        // Synchronized method for withdrawing money
        public synchronized void withdraw(int amount) {
            if (amount <= balance) {
                System.out.println(Thread.currentThread().getName() + " withdrawing " + amount);
                balance -= amount;
                System.out.println("New balance after withdrawal: " + balance);
            } else {
                System.out.println(Thread.currentThread().getName() + " attempted to withdraw " + amount + " but insufficient funds.");
            }
        }
    }

    // Deposit task
    static class DepositTask implements Runnable {
        private BankAccount account;
        private int amount;

        public DepositTask(BankAccount account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            account.deposit(amount);
        }
    }

    // Withdrawal task
    static class WithdrawalTask implements Runnable {
        private BankAccount account;
        private int amount;

        public WithdrawalTask(BankAccount account, int amount) {
            this.account = account;
            this.amount = amount;
        }

        @Override
        public void run() {
            account.withdraw(amount);
        }
    }
}
