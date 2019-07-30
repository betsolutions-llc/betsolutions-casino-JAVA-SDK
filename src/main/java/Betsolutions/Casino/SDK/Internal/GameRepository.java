package Betsolutions.Casino.SDK.Internal;


import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.DTO.Game.GetGamesResponseContainer;
import com.google.gson.Gson;
import okhttp3.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


public class GameRepository {

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
    private MerchantAuthInfo merchantAuthInfo;

    public GameRepository(MerchantAuthInfo merchantAuthInfo) {
        this.merchantAuthInfo = merchantAuthInfo;
    }

    public GetGamesResponseContainer GetGames() throws NoSuchAlgorithmException, IOException {

        String rawHash = this.merchantAuthInfo + "|" + this.merchantAuthInfo.PrivateKey;

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashArr = digest.digest(rawHash.getBytes(StandardCharsets.UTF_8));
        String hash = Base64.getEncoder().encodeToString(hashArr);

        OkHttpClient client = new OkHttpClient();

        Object o = new Object() {
            public final int MerchantId = merchantAuthInfo.MerchantId;
            public final String Hash = hash;
        };

        RequestBody body = RequestBody.create(JSON, new Gson().toJson(o));

        Request request = new Request.Builder()
                .url("url")
                .post(body)
                .build();

        Response response = client.newCall(request).execute();
        String respo = response.body().string();
        GetGamesResponseContainer finalResult = new Gson().fromJson(respo, GetGamesResponseContainer.class);

        return finalResult;
    }
}
