import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
public class EncrypData {
    private static SecretKeySpec SecretKey;
    private static byte[] key;
    private static final String Algorithm = "AES";


    public void prepareSecretKey(String MyKey) {
        MessageDigest Sha = null;
        try {
            key = MyKey.getBytes(StandardCharsets.UTF_8);
            Sha = MessageDigest.getInstance("SHA-1");
            key = Sha.digest(key);
            key = Arrays.copyOf(key, 16);
            SecretKey = new SecretKeySpec(key, Algorithm);


        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    public String encrypt(String strToEncrypt, String secret) {
        try {
            prepareSecretKey(secret);
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, SecretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));


        } catch (Exception e) {

            System.out.println("Error while encrypting: " + e.toString());


        }

        return null;
    }
    public String decrypt(String strToDecrypt, String secret) {
        try {
            prepareSecretKey(secret);
            Cipher cipher = Cipher.getInstance(Algorithm);
            cipher.init(Cipher.DECRYPT_MODE, SecretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            System.out.println("Error while decrypting: " + e.toString());
        }
        return null;
    }

}