package model.transaction;

import model.LineItem;
import model.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Used to streamline the building/construction process of a transaction.
 */
public class TransactionBuilder {
    private TransactionInBuilding transaction;

    public TransactionBuilder() {
        transaction = new TransactionInBuilding();
    }

    public TransactionBuilder(int transactionID) {
        transaction = new TransactionInBuilding(transactionID);
    }

    public TransactionBuilder setDate(LocalDateTime date) {
        transaction.setDate(date);
        return this;
    }

    public TransactionBuilder setCashier(User cashier) {
        transaction.setCashier(cashier);
        return this;
    }

    public TransactionBuilder setMode(String mode) {
        transaction.setMode(mode);
        return this;
    }

    public TransactionBuilder setCashReceived(double cashReceived) {
        transaction.setCashReceived(cashReceived);
        return this;
    }

    public TransactionBuilder setChange(double change) {
        transaction.setChange(change);
        return this;
    }

    public TransactionBuilder setSubTotal(double subTotal) {
        transaction.setSubTotal(subTotal);
        return this;
    }

    public TransactionBuilder setDiscount(double discount) {
        transaction.setDiscount(discount);
        return this;
    }
    
    public TransactionBuilder setTotal(double total) {
        transaction.setTotal(total);
        return this;
    }

    public TransactionBuilder addLineItem(LineItem lineItem) {

        // Check if lineItem is already in the list
        boolean duplicate = false;
        for (LineItem li : transaction.getLineItems()) {
            if (li.getConsumable().getName().equals(lineItem.getConsumable().getName())) {
                li.increaseQuantity(1);
                setTotal(transaction.getTotal() + li.getConsumable().getPrice());
                duplicate = true;
                break;
            }
        }
        if (!duplicate)
            transaction.addLineItem(lineItem);

        return this;
    }

    public TransactionBuilder removeLineItem(LineItem lineItem) {
        transaction.removeLineItem(lineItem);
        return this;
    }

    public TransactionBuilder setLineItems(ArrayList<LineItem> lineItems) {
        transaction.setLineItems(lineItems);
        return this;
    }

    public TransactionBuilder setCustomerNo(int customerNo) {
        transaction.setCustomerNo(customerNo);
        return this;
    }

    public Transaction build() {
        if (transaction.getTotal() == -1) { // Computes the total if total was not modified.
            double total = 0;
            for (LineItem li : transaction.getLineItems())
                total += li.getConsumable().getPrice();
            transaction.setTotal(total);
        }

        return transaction;
    }

    /**
     * A subclass of Transaction that is able to access the mutator methods
     * of a Transaction. A design used to prevent modification of a Transaction.
     */
    private class TransactionInBuilding extends Transaction {
        public TransactionInBuilding() {
            super(-1);
            cashReceived = -1;
            change = -1;
            total = -1;
            lineItems = new ArrayList<LineItem>();
            customerNo = -1;
        }
        
        public TransactionInBuilding(int transactionID) {
            super(transactionID);
            cashReceived = -1;
            change = -1;
            total = -1;
            lineItems = new ArrayList<LineItem>();
            customerNo = -1;
        }
    }
}