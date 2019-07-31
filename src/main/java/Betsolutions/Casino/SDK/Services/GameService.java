package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.Game.GetGamesResponseContainer;
import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.Enums.StatusCode;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class GameService extends BaseService {

    public GameService(MerchantAuthInfo merchantAuthInfo) {
        super(merchantAuthInfo, "Game");
    }

    public GetGamesResponseContainer GetGames() {

        HashBuilder hashBuilder = new HashBuilder(merchantAuthInfo.PrivateKey);
        hashBuilder.Add(this.merchantAuthInfo.MerchantId);

        String rawHash = hashBuilder.Build();
        String hash = sha256(rawHash);

        GetGamesRequest requestModel = new GetGamesRequest(this.merchantAuthInfo.MerchantId, hash);
        String requestJsonStr = gson.toJson(requestModel, GetGamesRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "GetGameList";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;
        try {
            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new GetGamesResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new GetGamesResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, GetGamesResponseContainer.class);
    }

    private class GetGamesRequest {
        int MerchantId;
        String Hash;

        GetGamesRequest(int merchantId, String hash) {
            this.Hash = hash;
            this.MerchantId = merchantId;
        }
    }
}
