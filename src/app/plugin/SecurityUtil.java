package app.plugin;

import java.nio.file.Files;
import java.nio.file.Path;
import java.security.*;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class SecurityUtil {

    public static PublicKey loadPublicKey(byte[] keyBytes) throws Exception {
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    public static boolean verify(Path jarPath, Path sigPath, PublicKey publicKey) {
        try {
            byte[] jarBytes = Files.readAllBytes(jarPath);
            byte[] sigBytes = Base64.getDecoder().decode(Files.readAllBytes(sigPath));

            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);
            signature.update(jarBytes);

            return signature.verify(sigBytes);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}