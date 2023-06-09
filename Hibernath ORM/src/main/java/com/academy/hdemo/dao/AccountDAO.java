package com.academy.hdemo.dao;

import java.util.List;

import com.academy.hdemo.dto.Account;

public interface AccountDAO {

    void save(Account account);

    Account findByAccountId(long id);

    void delete(Account account);

    void update(Account account);

    void transferBalance(long sourceAccountId, long destinationAccountId, long amount);

    List<Account> accountList();

    List<Account> getAccountsBalanceGreaterThan(long balance);

}
