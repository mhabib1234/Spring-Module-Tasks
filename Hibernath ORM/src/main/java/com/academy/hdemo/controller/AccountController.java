package com.academy.hdemo.controller;

import com.academy.hdemo.dto.Account;
import com.academy.hdemo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController()
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accountService;


    //details of employee
    @GetMapping("/detail")
    public Account detail(@RequestParam long accountId) {
        return accountService.findById(accountId);
    }


    //create
    @PostMapping("/new")
    public String newAccount(@RequestBody Account account) {
        accountService.saveAccount(account);
        return("Account Created Successfully!");
    }


    //update
    @PutMapping("/update")
    public String updateAccount(@RequestBody Account account) {
        accountService.update(account);
        return("Account updated Successfully!");
    }


    //delete
    @DeleteMapping("/delete")
   public String delete(@RequestBody Account account) {
       accountService.deleteAccount(account);
        return("Account Deleted Successfully!");
    }

    @DeleteMapping("/deleteByID/{customerId}")
    public String deleteCustomer(@PathVariable Integer customerId) {
        accountService.deleteAccount(detail(customerId));
        return("Account Deleted Successfully!");
    }

    @GetMapping()
    public List allAccount() {
        return accountService.getAllAccounts();
    }



    //transfer
    @PostMapping("/transfer")
    public ResponseEntity<String> transferBalance(@RequestParam("sourceAccountId") long sourceAccountId,
                                                  @RequestParam("destinationAccountId") long destinationAccountId,
                                                  @RequestParam("amount") long amount) {
        try {
            accountService.transferBalance(sourceAccountId, destinationAccountId, amount);
            return ResponseEntity.ok("Balance transfer successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error transferring balance: " + e.getMessage());
        }
    }


    //balance greater than
    @GetMapping("/balanceGreaterThan")
    public List<Account> getAccountsBalanceGreaterThan(@RequestParam("balance") long balance) {
        return accountService.getAccountsBalanceGreaterThan(balance);
    }


}
