import java.util.*;
public class hi{
    public static void main(String[] args){
        String h1 = String.format("%28S\n", "Tony Joe's Barbeque");
        String h2 = String.format("%35S\n", "Parkwood 2 Gate, Legaspi Street,");
        String h3 = String.format("%28S\n", "Maybunga, Pasig City");
        String h4 = String.format("%32S\n\n", "VAT REG TIN: 2401-DLSU-MNL");
        String l = String.format("%35s\n", "-------------------------------------");
        String s = String.format("%-15s %5s %15s\n", "Item", "Qty", "Price");
        String s1 = String.format("%-15s %5s %15s\n", "----", "---", "-----");
        String order = String.format("%-15s %5s %15s\n", "Jordan Gana", "420", "99.99");
        String order2 = String.format("%-15s %5s %15s\n", "Mark Sanchez", "69", "69.69");
        String output = h1 + h2 + h3 + h4 + s + s1 + order + order2 + l;
        
        System.out.println(output);
    }
}