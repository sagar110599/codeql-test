// Is there any method to generate MD5 hash of a string in Java?

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashGenerator {
    public static void main(String[] args) {
        String input = "Hello, World!";
        String md5Hash = generateMD5Hash(input);
        System.out.println("MD5 Hash: " + md5Hash);
    }

    public static String generateMD5Hash(String input) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(input.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : messageDigest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}
