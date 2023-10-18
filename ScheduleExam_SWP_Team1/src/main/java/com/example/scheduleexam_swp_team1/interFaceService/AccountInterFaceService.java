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
    public int updateAccount(Account account, String Account_ID);
    // ham get roleName
    public Account getRole(String Account_ID);
    public Account CheckExits(String Email);


}
