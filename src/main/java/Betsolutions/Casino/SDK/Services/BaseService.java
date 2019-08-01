package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;


public abstract class BaseService {

    protected MerchantAuthInfo merchantAuthInfo;
    protected String baseUrl;
    protected Gson gson;
    protected OkHttpClient httpClient;
    protected DateFormatter dateFormatter;
    protected static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private static final String DateFormat = "MM-dd-yyyy HH:mm:ss";

    public BaseService(MerchantAuthInfo merchantAuthInfo, String controller) {
        this.merchantAuthInfo = merchantAuthInfo;
        this.baseUrl = this.merchantAuthInfo.BaseUrl + "v1/" + controller + "/";
        this.dateFormatter = new DateFormatter(DateFormat);
        this.gson = new GsonBuilder().setDateFormat(DateFormat).create();
        this.httpClient = new OkHttpClient();
    }

    protected HashBuilder GetHashBuilder(String privateKey){
        return new HashBuilder(privateKey, dateFormatter, gson);
    }

    protected class DateFormatter {

        private SimpleDateFormat dateFormat;

        public DateFormatter(String format) {
            dateFormat = new SimpleDateFormat(format);
        }

        public String format(Date date) {
            return this.dateFormat.format(date);
        }
    }

    protected class HashBuilder {

        private String privateKey;
        private StringJoiner stringJoiner;
        private DateFormatter dateFormatter;
        private Gson gson;

        HashBuilder(String privateKey, DateFormatter dateFormatter, Gson gson) {
            this.privateKey = privateKey;
            this.dateFormatter = dateFormatter;
            this.gson = gson;
            this.Reset();
        }

        private void Reset() {
            this.stringJoiner = new StringJoiner("|");
        }

        public <T> void Add(T obj) {

            this.stringJoiner.add(Objects.toString(obj, ""));
        }

        public void Add(Date date) {

            String toDateStr = null;

            if (null != date) {
                toDateStr = this.dateFormatter.format(date);
            }

            this.Add(toDateStr);
        }

        public <T> void Add(List<T> list) {

            String listStr = gson.toJson(list);
            this.Add(listStr);
        }

        public String Build() {
            this.stringJoiner.add(this.privateKey);
            String result = sha256(this.stringJoiner.toString());
            this.Reset();

            return result;
        }

        String sha256(String base) {
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
}
