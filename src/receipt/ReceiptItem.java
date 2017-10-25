public class ReceiptItem{
    private String name;
    private int qty;
    private double price;

    public ReceiptItem(String name, int qty, double price){
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
    public String kitchenItem(){
        return String.format("%-15s", "%21s", "Jordan Gana", "420");
    }
    public String customerItem(){
        return String.format("%-15s", "%5s", "%15s", name, qty+"", price+"");
    }

    public static void main(String[] args){
        ReceiptItem r = new ReceiptItem();
        System.out.println(r.kitchenItem());
        System.out.println(r.customerItem());
    }
}