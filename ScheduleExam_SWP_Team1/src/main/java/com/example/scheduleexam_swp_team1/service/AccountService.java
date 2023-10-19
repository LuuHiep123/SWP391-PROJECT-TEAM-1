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
import java.util.Random;

@CrossOrigin(origins = "*")
@Service
public class AccountService implements AccountInterFaceService {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAllAccount() {
        return jdbcTemplate.query("SELECT [Email],[Name][Gender],[Address],[RoleName],Name,gender  FROM [scheduleExam].[dbo].[account]", new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account getAAccount(String Email) {
        try {
            return jdbcTemplate.queryForObject("SELECT * FROM [scheduleExam].[dbo].[account] WHERE Email = ?", new BeanPropertyRowMapper<Account>(Account.class), Email);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deleteAccount(String Account_ID) {
        try {
            return jdbcTemplate.update("DELETE FROM [account] WHERE account_id = ? ", Account_ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int updateAccount(Account account) {
        try {
            String sql = "UPDATE Account SET Name = ?, Address = ?,DOB = ?,Gender = ?, Password = ? WHERE Email = ?";

            return jdbcTemplate.update(sql, new Object[]{
                    account.getName(),    // String
                    account.getAddress(), // String
                    account.getDOB(),     // Date or appropriate date type
                    account.isGender(),  // String or appropriate gender type
                    account.getPassword(),    // String// String or appropriate ID type
                    account.getEmail()
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public Account getRole(String Account_ID) {
        try {
            return jdbcTemplate.queryForObject("SELECT rolename FROM account WHERE account_id = ?", new BeanPropertyRowMapper<Account>(Account.class), Account_ID);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account CheckExits(String Email) {
        return jdbcTemplate.queryForObject("SELECT * FROM [scheduleExam].[dbo].[account] WHERE Email = ?", new BeanPropertyRowMapper<Account>(Account.class), Email);
    }


    @Override
    public Account createAccount(Account account) {
        if (CheckExits(account.getEmail()) == null) {
            //Random Password
            int length = 5;
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            Random random = new Random();
            StringBuilder randomString = new StringBuilder();
            for (int i = 0; i < length; i++) {
                int index = random.nextInt(characters.length());
                char randomChar = characters.charAt(index);
                randomString.append(randomChar);
            }
            String Password = String.valueOf(randomString);

            jdbcTemplate.update("INSERT INTO account (Email,Password, address, dob, gender, img, name, rolename, email)\n" +
                            "VALUES (?, ?, ?, ?, CONVERT(varbinary(max), ?), ?, ?, ?)",
                    new Object[]{
                            account.getEmail(),
                            Password,
                            account.getAddress(),
                            account.getDOB(),
                            account.isGender(),
                            account.getIMG().getBytes(), // Assuming getIMG() returns a String
                            account.getName(),
                            account.getRolename(),
                            account.getEmail()
                    }
            );
            return jdbcTemplate.queryForObject("SELECT * FROM [scheduleExam].[dbo].[account] WHERE Email = ?", new BeanPropertyRowMapper<Account>(Account.class), account.getEmail());
        }
        return null;
    }

}
