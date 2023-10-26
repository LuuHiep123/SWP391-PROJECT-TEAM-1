package com.example.scheduleexam_swp_team1.controller;

import com.example.scheduleexam_swp_team1.model.Account;
import com.example.scheduleexam_swp_team1.service.AccountService;
import jakarta.servlet.http.HttpSession;
import jakarta.websocket.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/api/Account")
public class AccountController {
    @Autowired
    private AccountService accountDAO;
    @Autowired
    private HttpSession Session;

    @GetMapping("/list")
    public List<Account> getListAccount() {
        return accountDAO.getAllAccount();
    }

    @GetMapping("/get/{Email}")
    public Account getAccount(@PathVariable String Email) {
        return accountDAO.getAAccount(Email);
    }

    @PostMapping("/update")
    public String updateAccount(@RequestBody Account account) {
        if (accountDAO.updateAccount(account, account.getEmail()) == 0) {
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
        } else {
            return temp.getPassword();
        }
    }

    @DeleteMapping("/delete/{Email}")
    public String deleleAccount(@PathVariable String Email) {
        int check = accountDAO.deleteAccount(Email);
        if (check == 0) {
            return "account does not exist!";
        } else {
            return "Delete" + " " + check + " " + "rows" + " " + "successfull!";
        }
    }

    @GetMapping("/getRoleName/{id}")
    public String getRoleName(@PathVariable String id) {
        return "" + accountDAO.getRole(id);
    }

    @PostMapping("/LoginWithAccount")
    public ResponseEntity<?> LoginAccount(@RequestBody Map<String, String> requestBody) {
        String Email = requestBody.get("Email");
        String Password = requestBody.get("Password");
        Account user = accountDAO.LoginWithAccount(Email, Password);
        if (user == null) {
            String Message ="Incorect Email or Password";
            return ResponseEntity.badRequest().body(Message);
        } else {
            return ResponseEntity.ok(user);
        }
    }

    @GetMapping("/LoginGoogle/{Email}")
    public ResponseEntity<?> LoginGoogle(@PathVariable String Email) {
        Account user = accountDAO.LoginGoogle(Email);
        if (user == null) {
            String Message ="Email is not registered";
            return ResponseEntity.badRequest().body(Message);
        } else {
            return ResponseEntity.ok(user);
        }
    }
}
    