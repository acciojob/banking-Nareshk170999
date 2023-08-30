package com.driver;

public class SavingsAccount extends BankAccount {
     double rate;
     double maxWithdrawalLimit;

    public SavingsAccount(String name, double balance, double maxWithdrawalLimit) {
        super(name,balance, 0);
        this.rate = rate;
        this.maxWithdrawalLimit = maxWithdrawalLimit;
    }

    public double getRate() {
        return rate;
    }

    public double getMaxWithdrawalLimit() {
        return maxWithdrawalLimit;
    }

    @Override
    public void withdraw(double amount) throws Exception {
        // Implementation for withdrawal and exception handling
        if(amount>maxWithdrawalLimit)throw new Exception("Maximum Withdraw Limit Exceeded");
        if(getBalance()<amount) throw new Exception("Insufficient Balance");

        setBalance(getBalance()-amount);
    }

    public double getSimpleInterest(int years) {
        // Implementation for simple interest calculation
        double interest= (getBalance()*rate*years)/100.0;
//        setBalance(getBalance()+interest);
        return getBalance()+interest;
    }

    public double getCompoundInterest(int times, int years) {
        // Implementation for compound interest calculation
        double finalamount=0.0;// this.getBalance()*((100.0+rate)/100.0)^(times*years);
        finalamount=Math.pow(((100.0+rate/times)/100.0),(times*years)*1.0)*getBalance();
//        setBalance(finalamount);
        return finalamount;
    }
}
