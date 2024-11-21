package RSA;

import java.util.Scanner;
public class rsa{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        //key generation
        System.out.print("Enter first prime number(p):");
        long p=sc.nextLong();
        System.out.print("Enter second prime number(q):");
        long q=sc.nextLong();

        long n=p*q;
        long phi=(p-1)*(q-1);
        long e=7;
        while(gcd(e,phi)!=1) {
            e+=2;
        }

        long d=modInverse(e,phi);
        System.out.println("Public key:("+e+","+n+")");
        System.out.println("Private Key:(" +d+","+n+")");

        //encrytion
        System.out.print("Enter message to encrypt(as a integer):");
        long message=sc.nextLong();
        long startencrypt = System.nanoTime();
        long ciphertext=modexp(message,e,n);
        long endencrypt=System.nanoTime();
        System.out.println("Encryption time: %.3f ms\n" +(endencrypt-startencrypt)/ 1e6);
        System.out.println("Encrypted Message:"+ciphertext);
//decryption
        long startdecrypt = System.nanoTime();
        long decryptedmsg=modexp(ciphertext,d,n);
        long enddecrypt=System.nanoTime();
        System.out.println("Encryption time: %.3f ms\n" +(enddecrypt-startdecrypt)/ 1e6);
        System.out.println("Decrypted Message:"+ decryptedmsg);
        sc.close();
    }
    private static long gcd(long a, long b) {
        while(b!=0) {
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;

    }

    private static long modexp(long base, long exp, long mod) {
        long result=1;
        base=base%mod;
        while(exp>0) {
            if((exp&1)==1) {
                result=(result*base)%mod;
            }
            exp=exp>>1;
            base=(base*base)%mod;
        }

        return result;
    }


    private static long modInverse(long e, long phi) {
        for(long d=1;d<phi;d++) {
            if((e*d)%phi==1) {
                return d;
            }
        }
        throw new IllegalArgumentException("Modular inverse not found");
    }
}
