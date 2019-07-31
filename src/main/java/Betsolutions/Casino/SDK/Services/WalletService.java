package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.DTO.Wallet.GetBalanceRequest;
import Betsolutions.Casino.SDK.DTO.Wallet.GetBalanceResponseContainer;
import Betsolutions.Casino.SDK.Enums.StatusCode;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class WalletService extends BaseService {

    public WalletService(MerchantAuthInfo merchantAuthInfo) {
        super(merchantAuthInfo, "Wallet");
    }

    public GetBalanceResponseContainer GetBalance(GetBalanceRequest requestModel) {

        String rawHash = requestModel.Currency + "|" + this.merchantAuthInfo.MerchantId + "|" + requestModel.Token + "|" + requestModel.UserId + "|" + this.merchantAuthInfo.PrivateKey;

        requestModel.Hash = sha256(rawHash);
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, GetBalanceRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "GetBalance";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {
            OkHttpClient client = new OkHttpClient();
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new GetBalanceResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new GetBalanceResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, GetBalanceResponseContainer.class);
    }
}
