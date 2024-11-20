package Assignment1;

import java.util.Scanner;

public class monoCipher {
    public static char []normalChar={
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
        'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't',
        'u', 'v', 'w', 'x', 'y', 'z' };
    public static char []codedChar={
        'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O', 'P',
        'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z',
        'X', 'C', 'V', 'B', 'N', 'M' };

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string for encryption using Monoalphabetic cipher: ");
        String inputStr=sc.nextLine();
        System.out.println("Encrypted Data ===> "+encrypt(inputStr));
        System.out.println("Decrypted Data ===> "+decrypt(encrypt(inputStr)));
    }
    public static String encrypt(String msg){
        String encryptedString = "";

        for(int i=0;i<msg.length();i++){
            char curr=msg.charAt(i);

            if(curr< 'a' || curr> 'z'){
                encryptedString+=curr;
                continue;
            }
            for(int j=0;j<26;j++){
                if(curr==normalChar[j]){
                    encryptedString+=codedChar[j];
                    break;
                }
            }
        }
        return encryptedString;
    }
    public static String decrypt(String msg){
        String decrypted="";

        for(int i=0;i<msg.length();i++){
            char curr=msg.charAt(i);

            if(curr< 'A' || curr> 'Z'){
                decrypted+=curr;
                continue;
            }
            for(int j=0;j<26;j++){
                if(curr==codedChar[j]){
                    decrypted+=normalChar[j];
                    break;
                }
            }
        }
        return decrypted;
    }
}
