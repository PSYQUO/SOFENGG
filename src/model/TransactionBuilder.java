package model;

import java.util.List;
import java.util.ArrayList;

import model.Transaction;
import model.LineItem;

public class TransactionBuilder {
    private TransactionInBuilding transaction;

    public TransactionBuilder() {
        transaction = new TransactionInBuilding();
    }

    public void setTransactionID(int transactionID) {
        transaction.setTransactionID(transactionID);
    }

    public void setTransactionDate(LocalDateTime transactionDate) {
        transaction.setTransactionDate(transactionDate);
    }

    public void setCashier(User cashier) {
        transaction.setCashier(cashier);
    }

    public void setMode(TransactionMode mode) {
        transaction.setMode(mode);
    }

    public void setCashReceived(double cashReceived) {
        transaction.setCashReceived(cashReceived);
    }

    public void setChange(double change) {
        transaction.setChange(change);
    }

    public void setTax(double tax) {
        transaction.setTax(tax);
    }

    public void setDiscount(double discount) {
        transaction.setDiscount(discount);
    }

    public void addLineItem(LineItem lineItem) {
        transaction.addLineItem(lineItem);
    }

    public void setLineItems(List<LineItem> lineItems) {
        transaction.setLineItems(lineItems);
    }

    public void setCustNo(int custNo) {
        transaction.setCustNo(custNo);
    }

    public Transaction build() {
        double total = 0;
        for (LineItem li : transaction.getLineItems())
            total += li.getPrice();
        transaction.setTotal(total);

        return transaction;
    }

    private class TransactionInBuilding extends Transaction {
        public TransactionInBuilding() {
            transactionID = -1;
            cashReceived = -1;
            change = -1;
            lineItems = new ArrayList<LineItem>();
            custNo = -1;
        }
    }
}