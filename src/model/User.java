package model;

public class User {
    public int userId;
    private String userName;
    private String userLoginName;
    private String password;
    private Role role;

    private enum Role {
        OWNER,
        SUPERVISOR,
        CASHIER
    }
}