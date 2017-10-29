package model;

public class Role{
    private int roleId;
    private String roleName;

    public Role(int roleId, String roleName){
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleID(){
        return roleId;
    }

    public String getRoleName(){
        return roleName;
    }
}