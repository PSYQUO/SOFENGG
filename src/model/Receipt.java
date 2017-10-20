import java.util.*;
public class Receipt{
    public static void main(String[] args){
        ArrayList<String> lines = new ArrayList<String>();
        String sep = "-------------------------------------";

        lines.add(new ReceiptLine("28S", "Tony Joe's Barbeque").getLine1());
        lines.add(new ReceiptLine("35S", "Parkwood 2 Gate, Legaspi Street,").getLine1());
        lines.add(new ReceiptLine("29S", "Maybunga, Pasig City").getLine1());
        lines.add(new ReceiptLine("29S", "Tel No: 0939-527-9331").getLine1());
        lines.add(new ReceiptLine("32S", "VAT REG TIN: 2401-DLSU-MNL").getLine1());
        lines.add(new ReceiptLine("35S", sep).getLine1());

        lines.add(new ReceiptLine("-15s", "5s", "15s", "Item", "Qty", "Price").getLine3());
        lines.add(new ReceiptLine("-15s", "5s", "15s", "----", "---", "-----").getLine3());
        lines.add(new ReceiptLine("-15s", "5s", "15s", "Jordan Gana", "420", "99.99").getLine3());
        lines.add(new ReceiptLine("-15s", "5s", "15s", "Mark Sanchez", "69", "69.69").getLine3());

        lines.add(new ReceiptLine("35S", sep).getLine1());

        lines.add(new ReceiptLine("31S", "Antoine IT Solutions Inc.").getLine1());
        lines.add(new ReceiptLine("32S", "Taft Avenue, Malate, Manila").getLine1());
        lines.add(new ReceiptLine("29S", "Date Issued 12/12/2017").getLine1());

        for (int i=0; i<lines.size(); i++){
            System.out.print(lines.get(i));
        }
    }
}