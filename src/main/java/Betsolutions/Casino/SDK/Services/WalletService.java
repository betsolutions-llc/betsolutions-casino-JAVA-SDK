package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.DTO.Wallet.DepositRequest;
import Betsolutions.Casino.SDK.DTO.Wallet.DepositResponseContainer;
import Betsolutions.Casino.SDK.DTO.Wallet.GetBalanceRequest;
import Betsolutions.Casino.SDK.DTO.Wallet.GetBalanceResponseContainer;
import Betsolutions.Casino.SDK.Enums.StatusCode;
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

        HashBuilder hashBuilder = new HashBuilder(merchantAuthInfo.PrivateKey);
        hashBuilder.Add(requestModel.Currency);
        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.Token);
        hashBuilder.Add(requestModel.UserId);

        String rawHash = hashBuilder.Build();

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

            response = httpClient.newCall(request).execute();
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

    public DepositResponseContainer Deposit(DepositRequest requestModel) {

        HashBuilder hashBuilder = new HashBuilder(merchantAuthInfo.PrivateKey);

        hashBuilder.Add(requestModel.Amount);
        hashBuilder.Add(requestModel.Currency);
        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.TransactionId);
        hashBuilder.Add(requestModel.Token);
        hashBuilder.Add(requestModel.UserId);

        String rawHash = hashBuilder.Build();

        requestModel.Hash = sha256(rawHash);
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, DepositRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "Deposit";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {

            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new DepositResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new DepositResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, DepositResponseContainer.class);
    }
}
