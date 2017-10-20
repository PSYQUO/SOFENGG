public class ReceiptLine{
    private String text;
    private String text1;
    private String text2;
    private String spacing;
    private String spacing1;
    private String spacing2;

    public ReceiptLine(String spacing, String text){
        this.spacing = spacing;
        this.text = text;
    }

    public ReceiptLine(String spacing1, String spacing2, String text1, String text2){
        this.spacing1 = spacing1;
        this.spacing2 = spacing2;
        this.text1 = text1;
        this.text2 = text2;
    }

    public ReceiptLine(String spacing, String spacing1, String spacing2, String text, String text1, String text2){
        this.spacing = spacing;
        this.spacing1 = spacing1;
        this.spacing2 = spacing2;
        this.text = text;
        this.text1 = text1;
        this.text2 = text2;
    }

    public String getLine1(){
        return String.format("%"+spacing+"\n", text);
    }

    public String getLine2(){
        return String.format("%"+spacing1+" %"+spacing2+"\n", text1, text2);
    }

    public String getLine3(){
        return String.format("%"+spacing+" %"+spacing1+" %"+spacing2+"\n", text, text1, text2);
    }
}