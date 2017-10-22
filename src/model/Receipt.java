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

        lines.add(new ReceiptLine("1s", " ").getLine1());
        lines.add(new ReceiptLine("-15s", "Transaction Type: Dine-in").getLine1());
        lines.add(new ReceiptLine("-15s", "Transaction No.: 12345").getLine1());
        lines.add(new ReceiptLine("-15s", "Customer No.: 29").getLine1());
        lines.add(new ReceiptLine("35S", sep).getLine1());

        lines.add(new ReceiptLine("-15s", "5s", "15s", "Item", "Qty", "Price").getLine3());
        lines.add(new ReceiptLine("-15s", "5s", "15s", "----", "---", "-----").getLine3());
        lines.add(new ReceiptLine("-15s", "5s", "15s", "Jordan Gana", "420", "390.11").getLine3());
        lines.add(new ReceiptLine("-15s", "5s", "15s", "Mark Sanchez", "69", "100.00").getLine3());

        lines.add(new ReceiptLine("35S", sep).getLine1());
        lines.add(new ReceiptLine("-15S", "21S", "Vatable", "420.42").getLine2());
        lines.add(new ReceiptLine("-15S", "21S", "Vat 12%", "69.69").getLine2());

        lines.add(new ReceiptLine("37s", "--------").getLine1());
        //lines.add(new ReceiptLine("-15S", "Item Sold 489").getLine1());
        lines.add(new ReceiptLine("-15S", "21S", "Total", "490.11").getLine2());
        lines.add(new ReceiptLine("1s", " ").getLine1());
        lines.add(new ReceiptLine("-15S", "21S", "Amount Tendered", "500").getLine2());
        lines.add(new ReceiptLine("-15S", "21S", "Change", "9.89").getLine2());

        lines.add(new ReceiptLine("35S", sep).getLine1());

        lines.add(new ReceiptLine("31S", "Antoine IT Solutions Inc.").getLine1());
        lines.add(new ReceiptLine("32S", "Taft Avenue, Malate, Manila").getLine1());
        lines.add(new ReceiptLine("31S", "Contact No. 0977-627-4709").getLine1());
        lines.add(new ReceiptLine("1s", " ").getLine1());

        lines.add(new ReceiptLine("33S", "Thank you. Please come again.").getLine1());
        
        lines.add(new ReceiptLine("35S", sep).getLine1());
        lines.add(new ReceiptLine("-15s", "Cashier: Juan Dela Cruz").getLine1());
        lines.add(new ReceiptLine("-15s", "Date Time: 2018-1-1 12:00:00 PM").getLine1());
        
        
        for (int i=0; i<lines.size(); i++){
            System.out.print(lines.get(i));
        }
    }
}