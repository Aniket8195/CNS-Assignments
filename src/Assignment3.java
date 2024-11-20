import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a message to encrypt: ");
        String message = scanner.nextLine();

        System.out.print("Enter an integer shift for encryption: ");
        int shift = scanner.nextInt();

        System.out.print("Enter an integer key for encryption: ");
        int key = scanner.nextInt();

        System.out.print("Enter an integer rotation for encryption: ");
        int rotation = scanner.nextInt();

        String encryptedMessage = encrypt(message, shift, key, rotation);
        System.out.println("Encrypted Message: " + encryptedMessage);

        String decryptedMessage = decrypt(encryptedMessage, shift, key, rotation);
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
    public static String encrypt(String message, int shift , int key, int rotate){
        StringBuilder sb=new StringBuilder();

        for(char c:message.toCharArray()){
         char shiftedChar=  (char)((c+shift)%Character.MAX_VALUE);
         char xorChar=(char) ((shiftedChar^key)%Character.MAX_VALUE);
         char rotatedChar=(char) ((xorChar+rotate)%Character.MAX_VALUE);

         sb.append(rotatedChar);
        }
        return sb.toString();
    }
    public  static String decrypt(String message, int shift, int key ,int rotate){
        StringBuilder sb=new StringBuilder();
        for(char c:message.toCharArray()){
            char unRoatedChar=(char) ((c-rotate)%Character.MAX_VALUE);
            char unXorChar=(char) ((unRoatedChar^key)%Character.MAX_VALUE);
            char unShiftedChar=(char) ((unXorChar-shift)%Character.MAX_VALUE);
            sb.append(unShiftedChar);
        }
        return sb.toString();
    }
}
