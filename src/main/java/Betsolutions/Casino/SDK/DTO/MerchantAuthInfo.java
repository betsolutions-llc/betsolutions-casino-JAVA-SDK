package Betsolutions.Casino.SDK.DTO;

public class MerchantAuthInfo {
    public MerchantAuthInfo(int merchantId, String privateKey, String baseUrl) {
        this.MerchantId = merchantId;
        this.PrivateKey = privateKey;
        this.BaseUrl = baseUrl;
    }

    public int MerchantId;
    public String PrivateKey;
    public String BaseUrl;
}
