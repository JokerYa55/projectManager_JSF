/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.project.controllers;

import java.io.Serializable;
import java.util.List;
import org.jboss.logging.Logger;
import ru.project.DAO.UsersDAO;
import ru.project.beans.Users;

/**
 *
 * @author vasiliy.andricov
 */
public class userController implements Serializable {

    /**
     * Creates a new instance of userController
     */
    private final Logger log = Logger.getLogger(getClass().getName());
    private String userName;
    private String password;
    private List<Users> userList;
    private Users newUser = new Users();

    public userController() {
        log.info("userController()");
        refreshUserList();
        log.info("size => " + userList.size());

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Users> getUserList() {
        return userList;
    }

    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }

    public Users getNewUser() {
        return newUser;
    }

    public void setNewUser(Users newUser) {
        this.newUser = newUser;
    }

    public void addUser() {
        log.info("addUser()");
        (new UsersDAO()).addItem(newUser);
        newUser = new Users();
        refreshUserList();
    }

    private void refreshUserList() {
        log.info("refreshUserList()");
        this.userList = (new UsersDAO()).getList("Users.findAll", Users.class);
    }

}
