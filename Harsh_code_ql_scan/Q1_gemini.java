import java.security.MessageDigest;
import java.math.BigInteger;

public class MD5HashGenerator {

  public static String generateMD5Hash(String message) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] messageBytes = message.getBytes();
      md.update(messageBytes);
      byte[] digest = md.digest();
      BigInteger bigInt = new BigInteger(1, digest);
      return bigInt.toString(16);
    } catch (Exception e) {
      // Handle exception
      return null;
    }
  }

  public static void main(String[] args) {
    String message = "This is a message to be hashed";
    String md5Hash = generateMD5Hash(message);
    System.out.println("MD5 hash of '" + message + "' is: " + md5Hash);
  }
}
