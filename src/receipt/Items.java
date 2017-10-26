import java.util.*;

public class Items{
    private double total;
    private double amount;
    private double change;
    private ArrayList<ReceiptItem> items;

    public String customerItems(){
        items = new ArrayList<ReceiptItem>();

        String text = "";
        for (int i = 0; i < items.size(); i++){
            text = text + items.get(i);
        }
        return text;
    }
    public String kitchenItems(){
        items = new ArrayList<ReceiptItem>();

        String text = "";
        for (int i = 0; i < items.size(); i++){
            text = text + items.get(i);
        }
        return text;
    }
    public String paymentInfo(){
        ArrayList<String> lines = new ArrayList<String>();
        lines.add(String.format("%37s\n", "--------"));
        //lines.add(String.format("-15S", "Item Sold 489"));
        lines.add(String.format("%1s\n", " "));
        lines.add(String.format("%-15S%21S\n", "Amount Tendered", amount+""));
        lines.add(String.format("%-15S%21S\n", "Change", change+""));

        String text = "";
        for (int i = 0; i < lines.size(); i++){
            text = text + lines.get(i);
        }
        return text;
    }

    public static void main(String[] args){
        Items i = new Items();
        System.out.println(i.paymentInfo());
    }
}