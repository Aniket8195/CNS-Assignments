package Assignment1;

import java.util.Locale;
import java.util.Scanner;



import java.util.Scanner;

public class Vigener {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter message:");
        String msg = sc.nextLine();

        System.out.println("Enter key:");
        String key = sc.nextLine();

        String s = msg.toUpperCase();
        key = key.toUpperCase();

        String generatedKey = genKey(s, key);
        String c = ciphar(s, generatedKey);
        System.out.println("Cipher Text: " + c);
        System.out.println("Decipher Text: " + dciphar(c, generatedKey));
    }

    public static String genKey(String s, String key) {
        for (int i = 0;; i++) {
            if (key.length() == s.length()) {
                break;
            }
            key += key.charAt(i % key.length());
        }
        return key;
    }

    public static String ciphar(String s, String key) {
        String c = "";

        for (int i = 0; i < s.length(); i++) {
            int x = ((s.charAt(i) - 'A' + key.charAt(i) - 'A') + 26) % 26;
            c += (char)(x + 'A');
        }

        return c;
    }

    public static String dciphar(String s, String key) {
        String c = "";
        for (int i = 0; i < s.length(); i++) {
            int x = ((s.charAt(i) - 'A') - (key.charAt(i) - 'A') + 26) % 26;
            c += (char)(x + 'A');
        }
        return c;
    }
}

