package com.cbit.bankingsystem_proj.dao;

import com.cbit.bankingsystem_proj.model.Account;

public interface IAccountDao {
    public int createAccount(Account a);
    public boolean depositAmount(double amount,int custId);
}
