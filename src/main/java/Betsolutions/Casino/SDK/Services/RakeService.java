package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.DTO.Rake.GetRakeDetailedRequest;
import Betsolutions.Casino.SDK.DTO.Rake.GetRakeDetailedResponseContainer;
import Betsolutions.Casino.SDK.DTO.Rake.GetRakeRequest;
import Betsolutions.Casino.SDK.DTO.Rake.GetRakeResponseContainer;
import Betsolutions.Casino.SDK.Enums.StatusCode;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class RakeService extends BaseService {
    public RakeService(MerchantAuthInfo merchantAuthInfo) {
        super(merchantAuthInfo, "Rake");
    }

    public GetRakeResponseContainer GetRake(GetRakeRequest requestModel) {

        String fromDateStr = null;

        if (null != requestModel.FromDate) {
            fromDateStr = this.dateFormatter.format(requestModel.FromDate);
        }

        String toDateStr = null;

        if (null != requestModel.ToDate) {
            toDateStr = this.dateFormatter.format(requestModel.ToDate);
        }

        HashBuilder hashBuilder = GetHashBuilder(merchantAuthInfo.PrivateKey);
        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.UserId);
        hashBuilder.Add(fromDateStr);
        hashBuilder.Add(toDateStr);
        hashBuilder.Add(requestModel.GameId);

        requestModel.Hash = hashBuilder.Build();
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, GetRakeRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "GetRake";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {
            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new GetRakeResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new GetRakeResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, GetRakeResponseContainer.class);
    }

    public GetRakeDetailedResponseContainer GetRakeDetailed(GetRakeDetailedRequest requestModel) {

        String fromDateStr = null;

        if (null != requestModel.FromDate) {
            fromDateStr = this.dateFormatter.format(requestModel.FromDate);
        }

        String toDateStr = null;

        if (null != requestModel.ToDate) {
            toDateStr = this.dateFormatter.format(requestModel.ToDate);
        }

        HashBuilder hashBuilder = GetHashBuilder(merchantAuthInfo.PrivateKey);
        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.UserId);
        hashBuilder.Add(fromDateStr);
        hashBuilder.Add(toDateStr);
        hashBuilder.Add(requestModel.GameId);

        requestModel.Hash = hashBuilder.Build();
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, GetRakeDetailedRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "GetRakeDetailed";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {
            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new GetRakeDetailedResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new GetRakeDetailedResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, GetRakeDetailedResponseContainer.class);
    }
}
