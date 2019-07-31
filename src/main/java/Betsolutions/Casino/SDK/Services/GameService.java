package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.Game.GetGamesResponseContainer;
import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.Enums.StatusCode;
import com.google.gson.Gson;
import okhttp3.OkHttpClient;
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

        String rawHash = this.merchantAuthInfo.MerchantId + "|" + this.merchantAuthInfo.PrivateKey;
        String hash = sha256(rawHash);

        GetGamesRequest requestModel = new GetGamesRequest(this.merchantAuthInfo.MerchantId, hash);
        String requestJsonStr = new Gson().toJson(requestModel, GetGamesRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "GetGameList";

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

            return new GetGamesResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new GetGamesResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return new Gson().fromJson(responseBodyStr, GetGamesResponseContainer.class);
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
