import java.math.BigInteger;
import java.security.SecureRandom;

public class Assignment4 {
    public static void main(String[] args) {
        final BigInteger PRIME=new BigInteger("233");
        final BigInteger GENERATOR=new BigInteger("5");

        SecureRandom random=new SecureRandom();
        BigInteger AlicePrivate=new BigInteger(5,random);
        BigInteger AlicePublic=GENERATOR.modPow(AlicePrivate,PRIME);

        BigInteger BobPrivate=new BigInteger(5,random);
        BigInteger BobPublic=GENERATOR.modPow(BobPrivate,PRIME);


        BigInteger MalloryPrivateA=new BigInteger(5,random);
        BigInteger MalloryPublicA=GENERATOR.modPow(MalloryPrivateA,PRIME);

        BigInteger MalloryPrivateB=new BigInteger(5,random);
        BigInteger MalloryPublicB=GENERATOR.modPow(MalloryPrivateB,PRIME);


        //Simulating what Alice and Bob receive
        //Alice thinks this is Bob's public key
        BigInteger AliceReceivedPublic=MalloryPublicB;

        //Bob thinks this is Alice's public key
        BigInteger BobReceivedPublic=MalloryPublicA;

        BigInteger AliceGeneratedSharedKey=AliceReceivedPublic.modPow(AlicePrivate,PRIME);
        BigInteger BobGeneratedSharedKey=BobReceivedPublic.modPow(BobPrivate,PRIME);

        //Mallory Generated Shared Key with Alice
        BigInteger MallorySharedKeyA=AlicePublic.modPow(MalloryPrivateB,PRIME);
        //Mallory Generated Shared Key with Bob
        BigInteger MallorySharedKeyB=BobPublic.modPow(MalloryPrivateA,PRIME);

        System.out.println("Alice's Shared Key (with Mallory pretending to be Bob): "+AliceGeneratedSharedKey);
        System.out.println("Bob's Shared Key (with Mallory pretending to be Alice): "+BobGeneratedSharedKey);

        System.out.println("Mallory's Shared Key with Alice: "+MallorySharedKeyA);
        System.out.println("Mallory's Shared Key with Bob: "+MallorySharedKeyB);
    }
}
