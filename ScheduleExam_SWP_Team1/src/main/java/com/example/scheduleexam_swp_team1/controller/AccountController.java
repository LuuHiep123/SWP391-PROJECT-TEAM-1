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

    @GetMapping("/get/{id}")
    public Account getAccount(@PathVariable String id) {
        return accountDAO.getAAccount(id);
    }

    @PatchMapping("/update/{id}")
    public String updateAccount(@RequestBody Account account, @PathVariable String id) {
        return accountDAO.updateAccount(account, id) + " Update Account Successful";
    }

    @PostMapping("/create")
    public String createAccount(@RequestBody Account account) {
        return accountDAO.createAccount(account) + " Create Account Successful";
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
