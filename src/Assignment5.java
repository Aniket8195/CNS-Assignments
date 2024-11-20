import java.security.MessageDigest;
import java.util.Arrays;

public class Assignment5 {
    public static void main(String[] args) throws Exception {
        String msg="Hello World";

        byte[]hash=HashMessage1(msg);
        System.out.println("Hash: "+byteToHex1(hash));

        String receivedMessage=msg;
        byte[] recivedHash=HashMessage1(receivedMessage);

        if(Arrays.equals(hash,recivedHash)){
            System.out.println("Message is verified: Hash values match.");

        }else{
            System.out.println("Warning: Message has been tampered with!");
        }
    }
    public static byte[] HashMessage1(String message) throws Exception{
        MessageDigest digest=MessageDigest.getInstance("SHA-256");
        return digest.digest(message.getBytes());
    }
    public static String byteToHex1(byte[] bytes){
        StringBuilder hexString=new StringBuilder();
        for(byte b:bytes){
            hexString.append(String.format("%02x",b));
        }
        return hexString.toString();
    }
}
