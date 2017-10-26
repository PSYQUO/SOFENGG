import java.util.*;

public class Items{
    private double total;
    private double amount;
    private double change;
    private List<ReceiptItem> items;

    public String customerItems(){
        return "";
    }
    public String kitchenItems(){
        return "";
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