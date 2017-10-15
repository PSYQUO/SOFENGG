package model;

import java.time.LocalDateTime;
import java.util.List;

public class Transaction {
    public int transactionId;
    private LocalDateTime transactionDate;
    private User cashier;
    private TransactionMode mode;
    private double cashReceived;
    private double change;
    private double tax;
    private double discount;
    private double total;
    private List<LineItem> lineItems;
}