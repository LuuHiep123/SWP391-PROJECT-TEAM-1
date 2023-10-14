package com.example.scheduleexam_swp_team1.service;

import com.example.scheduleexam_swp_team1.model.Account;
import com.example.scheduleexam_swp_team1.repository.AccountRepository;
import com.example.scheduleexam_swp_team1.interFaceService.AccountInterFaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "*")
@Service
public class AccountService implements AccountInterFaceService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccount() {
        return jdbcTemplate.query("SELECT * FROM [scheduleExam].[dbo].[account]", new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account getAAccount(String Account_ID) {
        return jdbcTemplate.queryForObject("SELECT * FROM [scheduleExam].[dbo].[account] WHERE account_id = ?", new BeanPropertyRowMapper<Account>(Account.class), Account_ID);
    }

    @Override
    public int deleteAccount(String Account_ID) {
        return jdbcTemplate.update("DELETE FROM [account] WHERE account_id = ? ",Account_ID);
    }

    @Override
    public int updateAccount(Account account, String accountID) {
        String sql = "UPDATE account " +
                "SET name = ?, address = ?, dob = ?, gender = ?, rolename = ?, email = ? " +
                "WHERE account_id = ?";

        return jdbcTemplate.update(sql, new Object[] {
                account.getName(),    // String
                account.getAddress(), // String
                account.getDOB(),     // Date or appropriate date type
                account.isGender(),  // String or appropriate gender type
                account.getRolename(), // String
                account.getEmail(),    // String
                accountID             // String or appropriate ID type
        });
    }


    @Override
    public int createAccount(Account account) {
        return jdbcTemplate.update("INSERT INTO account (account_id, address, dob, gender, img, name, rolename, email)\n" +
                        "VALUES (?, ?, ?, ?, CONVERT(varbinary(max), ?), ?, ?, ?)",
                new Object[]{
                        account.getAccount_ID(),
                        account.getAddress(),
                        account.getDOB(),
                        account.isGender(),
                        account.getIMG().getBytes(), // Assuming getIMG() returns a String
                        account.getName(),
                        account.getRolename(),
                        account.getEmail()
                }
        );
    }

}
