package Assignment1;

import java.util.Scanner;

public class ass1code1 {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter a string for encryption using Caesar Cipher: ");
        String inputStr=sc.nextLine();
        System.out.println("Enter the value by which each character in the plaintext message gets shifted: ");
        int shiftKey=Integer.valueOf(sc.nextLine());
        System.out.println("Encrypted Data ===> "+EncryptData(inputStr, shiftKey));
        System.out.println("Decrypted Data ===> "+DecryptData(EncryptData(inputStr, shiftKey), shiftKey));
        sc.close();
    }
    public static String EncryptData(String msg,int key){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<msg.length();i++){
            int post=ALPHABET.indexOf(msg.charAt(i));
            int encryptPos=(key+post)%26;
            char encryptChar=ALPHABET.charAt(encryptPos);
            sb.append(encryptChar);
        }
        return sb.toString();
    }
    public static String DecryptData(String encrypted,int key){
        StringBuilder sc=new StringBuilder();

        for(int i=0;i<encrypted.length();i++){
            int post=ALPHABET.indexOf(encrypted.charAt(i));
            int decryptPos=(post-key)%26;
            if(decryptPos<0){
                decryptPos=ALPHABET.length()+decryptPos;
            }
            char decryptChar=ALPHABET.charAt(decryptPos);
            sc.append(decryptChar);
        }
        return sc.toString();
    }
}
