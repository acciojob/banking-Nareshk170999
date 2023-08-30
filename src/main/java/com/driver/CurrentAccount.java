package com.driver;

public class CurrentAccount extends BankAccount {
     String tradeLicenseId;

    public CurrentAccount(String name,double balance, String tradeLicenseId) throws Exception {

        super(name,balance,5000);
        this.tradeLicenseId = tradeLicenseId;
    }

    public String getTradeLicenseId() {
        return tradeLicenseId;
    }

    public void validateLicenseId() throws Exception {

        char[]arr=tradeLicenseId.toCharArray();
        int[]freq=new int[26];
        if(isValid(arr)) return;
        int n=tradeLicenseId.length();
        int maxm=0, letter=0;
        for(int i=0;i<n;i++){
            int x=arr[i]-'A';
            freq[x]++;
            if(freq[x]>maxm){
                maxm=freq[x];
                letter=x;
            }
        }
        if(maxm>(n+1)/2) throw new Exception("Valid License can not be generated");
        char []res=new char[n];
        int idx=0;
        while(idx<n && freq[letter]-->0){
            res[idx]=(char)(letter+'A');
            idx+=2;
        }
        for(int i=0;i<26;i++){
            while(freq[i]-->0){
                if(idx>=n) idx=1;
                res[idx]=(char)(i+'A');
                idx+=2;
            }

        }
        this.tradeLicenseId=String.copyValueOf(res);
    }
    public boolean isValid(char[] arr){
        int n = arr.length;
        for (int i=1;i<n;i++){
            if(arr[i] == arr[i-1])
                return false;
        }
        return true;
    }
}

