//I have a project to make an encryption and decryption for string input in java. I've been stuck for a week doing some research in it. I really appreciate if you have sample source code or function method for Algorithm AES and Algorithm Twofish in java that I may use in my project. I really need your help ... hope someone out there could be my savior. Thanks very much.
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class AESEncryption {

    private static final String ALGORITHM = "AES";

    public static String encrypt(String data, String key) throws Exception {
        Key aesKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] encryptedValue = cipher.doFinal(data.getBytes());
        return Base64.getEncoder().encodeToString(encryptedValue); // Encode for readability
    }

    public static String decrypt(String encryptedData, String key) throws Exception {
        Key aesKey = new SecretKeySpec(key.getBytes(), ALGORITHM);
        Cipher cipher = Cipher.getInstance(ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, aesKey);
        byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(encryptedData)); // Decode before decryption
        return new String(decryptedValue);
    }

    public static void main(String[] args) throws Exception {
        String data = "This is a secret message";
        String key = "1234567890123456"; // 256-bit key (32 characters)

        String encryptedData = encrypt(data, key);
        System.out.println("Encrypted data: " + encryptedData);

        String decryptedData = decrypt(encryptedData, key);
        System.out.println("Decrypted data: " + decryptedData);
    }
}