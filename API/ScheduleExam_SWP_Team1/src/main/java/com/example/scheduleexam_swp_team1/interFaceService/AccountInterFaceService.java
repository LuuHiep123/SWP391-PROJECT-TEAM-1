package com.example.scheduleexam_swp_team1.interFaceService;

import com.example.scheduleexam_swp_team1.model.Account;

import java.util.List;

public interface AccountInterFaceService {
    // get allAccount
    public List<Account> getAllAccount();
    //get 1 Account
    public Account getAAccount(String Account_ID);
    //create Account
    public Account createAccount(Account account);
    // detete Account
    public int deleteAccount(String Account_ID);
    // updete account
    public int updateAccount(Account account, String email);
    // ham get roleName
    public Account getRole(String Account_ID);
    public int CheckExits(String Email);
    public Account LoginWithAccount(String Email,String Password);
    public Account LoginGoogle(String Email);


}
