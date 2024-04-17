
// Is there any method to generate MD5 hash of a string in Java?

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashGenerator {

  public static String generateMD5Hash(String message) throws NoSuchAlgorithmException {
    MessageDigest md = MessageDigest.getInstance("MD5");
    byte[] bytes = message.getBytes();
    md.update(bytes);
    byte[] digest = md.digest();
    return convertByteArrayToHexString(digest);
  }

  private static String convertByteArrayToHexString(byte[] array) {
    StringBuilder sb = new StringBuilder(2 * array.length);
    for (byte b : array) {
      sb.append(String.format("%02x", b & 0xff));
    }
    return sb.toString();
  }

  public static void main(String[] args) throws NoSuchAlgorithmException {
    String message = "This is a string";
    String hash = generateMD5Hash(message);
    System.out.println("MD5 Hash of \"" + message + "\": " + hash);
  }
}