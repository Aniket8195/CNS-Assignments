public class Assignment2 {
    private static long n, d, phi, e;

    public static void main(String[] args) {
        genKey(8);
        long message = 11;
        long encryptedMsg = encrypt(message);
        decrypt(encryptedMsg);
    }

    public static void genKey(int key) {
        long p = 61;
        long q = 53;
        n = p * q;
        phi = (p - 1) * (q - 1);

        e = 3;
        while (gcd(e, phi) != 1) {
            e++;
        }

        d = modin(e, phi);

        System.out.println("Public Key: (" + e + ", " + n + ")");
        System.out.println("Private Key: (" + d + ", " + n + ")");
    }

    public static long modin(long a, long m) {
        long m0 = m, t, q;
        long x0 = 0, x1 = 1;

        if (m == 1)
            return 0;

        while (a > 1) {
            q = a / m;
            t = m;

            m = a % m;
            a = t;
            t = x0;

            x0 = x1 - q * x0;
            x1 = t;
        }

        if (x1 < 0)
            x1 += m0;

        return x1;
    }

    public static long encrypt(long message) {
        System.out.println("Message to be encrypted: " + message);
        long c = modExp(message, e, n);
        System.out.println("Encrypted message: " + c);
        return c;
    }

    public static void decrypt(long encryptedMessage) {
        System.out.println("Message to be decrypted: " + encryptedMessage);
        long m = modExp(encryptedMessage, d, n);
        System.out.println("Decrypted message: " + m);
    }

    public static long modExp(long base, long exp, long mod) {
        long result = 1;

        base = base % mod;
        while (exp > 0) {
            if (exp % 2 == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp = exp >> 1;
        }

        return result;
    }

    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
