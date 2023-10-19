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

    @PutMapping("/update/{email}")
    public String updateAccount(@RequestBody Account account, @PathVariable String email) {
        if (accountDAO.updateAccount(account, email) == 0) {
            return "Update unsuccessfull!";
        } else {
            return " Update Account Successful";
        }
    }

    @PostMapping("/create")
    public String createAccount(@RequestBody Account account) {
        Account temp = null;
        temp = accountDAO.createAccount(account);
        if (temp == null) {
            return "Email already exists";
        }else{
            return "create Account successful!" + "\n" + "Email: " + temp.getEmail() + "\n" + "Password: " + temp.getPassword();
        }
    }

    @DeleteMapping("/delete/{Email}")
    public String deleleAccount(@PathVariable String Email) {
        int check = accountDAO.deleteAccount(Email);
        if(check == 0){
            return "account does not exist!";
        }else {
            return "Delete" + " " + check + " " + "rows" + " " + "successfull!";
        }
    }

    @GetMapping("/getRoleName/{id}")
    public String getRoleName(@PathVariable String id) {
        return "" + accountDAO.getRole(id);
    }
}
    