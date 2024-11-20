package Assignment1;

public class Vernam {
    public static void main(String[] args) {
        String plaintext = "HELLO";
        String key = "XMCKL";

        String encrypted = encrypt(plaintext, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted: " + decrypted);


    }
    public static String encrypt(String plaintext, String key) {
        // Ensure the key is of the same length as the plaintext
        if (plaintext.length() != key.length()) {
            throw new IllegalArgumentException("Key length must be the same as plaintext length");
        }

        StringBuilder ciphertext = new StringBuilder();

        // XOR each character of the plaintext with the corresponding character in the key
        for (int i = 0; i < plaintext.length(); i++) {
            char p = plaintext.charAt(i);
            char k = key.charAt(i);

            // XOR the characters and convert the result back to a character
            char c = (char) (p ^ k);
            ciphertext.append(c);
        }

        return ciphertext.toString();
    }

    // Method to decrypt the ciphertext using the Vernam cipher (XOR operation)
    public static String decrypt(String ciphertext, String key) {
        // Ensure the key is of the same length as the ciphertext
        if (ciphertext.length() != key.length()) {
            throw new IllegalArgumentException("Key length must be the same as ciphertext length");
        }

        StringBuilder plaintext = new StringBuilder();

        // XOR each character of the ciphertext with the corresponding character in the key
        for (int i = 0; i < ciphertext.length(); i++) {
            char c = ciphertext.charAt(i);
            char k = key.charAt(i);

            // XOR the characters and convert the result back to a character
            char p = (char) (c ^ k);
            plaintext.append(p);
        }

        return plaintext.toString();
    }
}
