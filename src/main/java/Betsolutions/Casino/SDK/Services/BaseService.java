package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;

public abstract class BaseService {

    protected MerchantAuthInfo merchantAuthInfo;
    String baseUrl;
    SimpleDateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
    Gson gson = new GsonBuilder().setDateFormat(dateFormat.toPattern()).create();

    static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public BaseService(MerchantAuthInfo merchantAuthInfo, String controller) {
        this.merchantAuthInfo = merchantAuthInfo;
        this.baseUrl = this.merchantAuthInfo.BaseUrl + "v1/" + controller + "/";
    }

    static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();

            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
