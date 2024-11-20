package Assignment1;

import java.util.Locale;

public class Vigener {
    public static void main(String[] args) {

        String s="HELLO";
        String key="PCCOE";
        s=s.toUpperCase(Locale.ROOT);
        key=key.toUpperCase(Locale.ROOT);
        key=genKey(s,key);
        String c=ciphar(s,key);
        System.out.println("Cipher Text: "+c);
        System.out.println("Decipher Text: "+dciphar(c,key));
    }
    public static String  genKey(String s,String key){
        for(int i=0;;i++){
            if(key.length()==s.length()){
                break;
            }
            key+=key.charAt(i%key.length());
        }


        return key;
    }


    public static String ciphar(String s,String key){
        String c="";

        for(int i=0;i<s.length();i++){
            int x=(s.charAt(i)-'A'+key.charAt(i)-'A')%26;
            c+=(char)(x+'A');
        }


        return c;
    }

    public static String dciphar(String s,String key){
        String c="";
        for(int i=0;i<s.length();i++){
            int x=(s.charAt(i)+'A'-key.charAt(i)-'A')%26;
            c+=(char)(x+'A');
        }
        return c;
    }
}
