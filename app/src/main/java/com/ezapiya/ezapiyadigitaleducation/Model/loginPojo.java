package com.ezapiya.ezapiyadigitaleducation.Model;

public class loginPojo {
    private String loginkey;
    private String code;
    private String message;
    private String userID;
    private String addUser;
    private String blockUser;
    private String removeUser;
    private String userPermission;


    // Getter Methods

    public String getLoginkey() {
        return loginkey;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getUserID() {
        return userID;
    }

    public String getAddUser() {
        return addUser;
    }

    public String getBlockUser() {
        return blockUser;
    }

    public String getRemoveUser() {
        return removeUser;
    }

    public String getUserPermission() {
        return userPermission;
    }

    // Setter Methods

    public void setLoginkey(String loginkey) {
        this.loginkey = loginkey;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public void setAddUser(String addUser) {
        this.addUser = addUser;
    }

    public void setBlockUser(String blockUser) {
        this.blockUser = blockUser;
    }

    public void setRemoveUser(String removeUser) {
        this.removeUser = removeUser;
    }

    public void setUserPermission(String userPermission) {
        this.userPermission = userPermission;
    }
}
