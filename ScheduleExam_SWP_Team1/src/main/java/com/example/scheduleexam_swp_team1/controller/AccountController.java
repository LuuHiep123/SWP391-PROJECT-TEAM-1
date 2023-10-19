package com.example.scheduleexam_swp_team1.controller;

import com.example.scheduleexam_swp_team1.model.Account;
import com.example.scheduleexam_swp_team1.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/Account")
public class AccountController {
    @Autowired
    private AccountService accountDAO;


    @GetMapping("/list")
    public List<Account> getListAccount() {
        return accountDAO.getAllAccount();
    }

    @GetMapping("/get/{Email}")
    public Account getAccount(@PathVariable String Email) {
        return accountDAO.getAAccount(Email);
    }

    @PatchMapping("/update")
    public String updateAccount(@RequestBody Account account) throws ExceptionInInitializerError {
        return accountDAO.updateAccount(account) + " Update Account Successful";
    }

    @PostMapping("/create")
    public Account createAccount(@RequestBody Account account) {
        if(accountDAO.createAccount(account) == null){
            return null;
        }
        return accountDAO.createAccount(account);
    }

    @DeleteMapping("/delete/{id}")
    public String deleleAccount(@PathVariable String id) {
        return accountDAO.deleteAccount(id) + " Delete Account Successfull";
    }

    @GetMapping("/getRoleName/{id}")
    public String getRoleName(@PathVariable String id) {
        return "" + accountDAO.getRole(id);
    }
}
    