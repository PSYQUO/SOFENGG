package model;

public class XRead{
    private User user;
    private double total;

    public XRead(User user, double total){
        this.user = user;
        this.total = total;
    }

    public User getUser(){
        return user;
    }

    public double getTotal(){
        return total;
    }
}