package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.DTO.Rake.GetRakeRequest;
import Betsolutions.Casino.SDK.DTO.Rake.GetRakeResponseContainer;
import Betsolutions.Casino.SDK.Enums.StatusCode;
import okhttp3.OkHttpClient;
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
            fromDateStr = dateFormat.format(requestModel.FromDate);
        }

        String toDateStr = null;

        if (null != requestModel.ToDate) {
            toDateStr = dateFormat.format(requestModel.ToDate);
        }

        String rawHash = this.merchantAuthInfo.MerchantId + "|" + Objects.toString(requestModel.UserId, "") + "|" + Objects.toString(fromDateStr, "") + "|" + Objects.toString(toDateStr, "") + "|" + Objects.toString(requestModel.GameId, "") + "|" + this.merchantAuthInfo.PrivateKey;

        requestModel.Hash = sha256(rawHash);
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
            OkHttpClient client = new OkHttpClient();
            response = client.newCall(request).execute();
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
}