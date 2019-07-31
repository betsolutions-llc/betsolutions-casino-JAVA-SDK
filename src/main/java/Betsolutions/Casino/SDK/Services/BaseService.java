package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Objects;
import java.util.StringJoiner;

public abstract class BaseService {

    protected MerchantAuthInfo merchantAuthInfo;
    String baseUrl;
    SimpleDateFormat dateFormat;
    Gson gson;
    OkHttpClient httpClient;

    static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    public BaseService(MerchantAuthInfo merchantAuthInfo, String controller) {
        this.merchantAuthInfo = merchantAuthInfo;
        this.baseUrl = this.merchantAuthInfo.BaseUrl + "v1/" + controller + "/";
        this.dateFormat = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        this.gson = new GsonBuilder().setDateFormat(dateFormat.toPattern()).create();
        this.httpClient = new OkHttpClient();
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

    protected class HashBuilder {

        private String privateKey;
        private StringJoiner stringJoiner;

        protected HashBuilder(String privateKey) {
            this.privateKey = privateKey;
            this.Reset();
        }

        private void Reset() {
            this.stringJoiner = new StringJoiner("|");
        }

        public <T> void Add(T str) {

            this.stringJoiner.add(Objects.toString(str, ""));
        }

        public String Build() {
            this.stringJoiner.add(this.privateKey);
            String result = this.stringJoiner.toString();
            this.Reset();

            return result;
        }
    }
}
