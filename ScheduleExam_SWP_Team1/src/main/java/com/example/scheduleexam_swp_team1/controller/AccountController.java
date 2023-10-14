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


    @GetMapping("/getListAccount")
    public List<Account> getListAccount() {
        return accountDAO.getAllAccount();
    }
    @GetMapping("/getAccount/{Account_ID}")
    public Account getAccount(@PathVariable String Account_ID) {
        return accountDAO.getAAccount(Account_ID);
    }
    @PutMapping("/updateAccount/{Accout_ID}")
    public String updateAccount(@RequestBody Account account, @PathVariable String Accout_ID) {
        return accountDAO.updateAccount(account,Accout_ID)+ " Update Account Successful";
    }
    @PostMapping("/createAccount")
    public String createAccount(@RequestBody Account account) {
        return accountDAO.createAccount(account) + " Create Account Successful";
    }
    @DeleteMapping("/deleteAccount/{Accout_ID}")
    public String deleleAccount(@PathVariable String Account_ID){
        return accountDAO.deleteAccount(Account_ID)+ " Delete Account Successfull";
    }

}
