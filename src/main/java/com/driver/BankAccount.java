package com.driver;

public class BankAccount {
    private String name;
    private double balance;
    private double minBalance;

    public BankAccount(String name,double balance, double minBalance) {
        this.name = name;
        this.minBalance = this.minBalance;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws Exception {
        if (balance - amount < minBalance) {
            throw new Exception("Insufficient Balance");
        }
        balance -= amount;
    }

    public String generateAccountNumber(int digits, int sum) throws Exception {
        if(digits*9<sum) throw new Exception("Account Number can not be generated");
        StringBuilder sb=new StringBuilder();
        while(digits-->0){
            if(sum>=9){
                sb.append(9);
                sum-=9;
            }else{
                sb.append(sum);
                sum=0;
            }
        }
        return sb.toString();
    }
}
