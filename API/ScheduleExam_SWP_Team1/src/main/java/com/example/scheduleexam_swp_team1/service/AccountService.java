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
        return jdbcTemplate.query("SELECT * FROM [scheduleExam].[dbo].[account]", new BeanPropertyRowMapper<Account>(Account.class));
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
    public int deleteAccount(String Email) {
        int check = 0;
        try {
            check = jdbcTemplate.update("DELETE FROM [account] WHERE Email = ? ", Email);
        } catch (Exception e) {
            return check;
        }
        return check;
    }

    @Override
    public int updateAccount(Account account, String email) {
        try {
            String sql = "UPDATE Account SET Name = ?, Address = ?,DOB = ?,Gender = ?, Password = ? WHERE Email = ?";

            return jdbcTemplate.update(sql, new Object[]{
                    account.getName(),    // String
                    account.getAddress(), // String
                    account.getDOB(),     // Date or appropriate date type
                    account.getGender(),  // String or appropriate gender type
                    account.getPassword(),    // String// String or appropriate ID type
                    email
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
    public int CheckExits(String Email) {
        int temp = 0;
        try {
            temp = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM [scheduleExam].[dbo].[account] WHERE Email = ?", Integer.class, Email);
        }catch (Exception e){
            e.printStackTrace();
        }
        return temp;
    }

    @Override
    public Account LoginWithAccount(String Email,String Password) {
        try {
            Account account = null;
            account = jdbcTemplate.queryForObject("SELECT Email,Name,Address,DOB,Gender,RoleName,Account_ID FROM [scheduleExam].[dbo].[account] WHERE Email = ? AND Password = ?", new BeanPropertyRowMapper<Account>(Account.class), Email, Password);
                return account;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account LoginGoogle(String Email) {
        try {
            Account account = null;
            account = jdbcTemplate.queryForObject("SELECT Email,Name,Address,DOB,Gender,RoleName,Account_ID FROM [scheduleExam].[dbo].[account] WHERE Email = ?", new BeanPropertyRowMapper<Account>(Account.class), Email);
            return account;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Account createAccount(Account account) {
        try {
            if (CheckExits(account.getEmail()) == 0) {
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
                Random randomnum = new Random();

                // Tạo một số ngẫu nhiên có 5 chữ số
                int min = 10000;
                int max = 99999;
                int randomNumber = random.nextInt(max - min + 1) + min;
                String Role = "Student";
                jdbcTemplate.update("INSERT INTO account (Email, Account_ID, Password, address, dob, gender, name, rolename)\n" +
                                "VALUES (?, ?, ?, ?, ?, ?, ?, ?)",
                        new Object[]{
                                account.getEmail(),
                                randomNumber,
                                Password,
                                account.getAddress(),
                                account.getDOB(),
                                account.getGender(),
                                account.getName(),
                                Role
                        }
                );
                return jdbcTemplate.queryForObject("SELECT Password FROM [scheduleExam].[dbo].[account] WHERE Email = ?", new BeanPropertyRowMapper<Account>(Account.class), account.getEmail());
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }

}
