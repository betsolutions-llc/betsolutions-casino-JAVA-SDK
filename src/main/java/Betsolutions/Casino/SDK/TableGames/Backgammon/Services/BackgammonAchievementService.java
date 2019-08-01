package Betsolutions.Casino.SDK.TableGames.Backgammon.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.Enums.StatusCode;
import Betsolutions.Casino.SDK.Services.BaseService;
import Betsolutions.Casino.SDK.TableGames.Backgammon.DTO.BackgammonAchievementsFilter;
import Betsolutions.Casino.SDK.TableGames.Backgammon.DTO.GetBackgammonAchievementsResponseContainer;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class BackgammonAchievementService extends BaseService {
    public BackgammonAchievementService(MerchantAuthInfo merchantAuthInfo) {
        super(merchantAuthInfo, "BackgammonAchievement");
    }

    public GetBackgammonAchievementsResponseContainer GetAchievements(BackgammonAchievementsFilter requestModel) {

        HashBuilder hashBuilder = GetHashBuilder(merchantAuthInfo.PrivateKey);

        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.AchievementTypeId);
        hashBuilder.Add(requestModel.OrderingDirection);
        hashBuilder.Add(requestModel.OrderingField);
        hashBuilder.Add(requestModel.PageIndex);
        hashBuilder.Add(requestModel.PageSize);

        requestModel.Hash = hashBuilder.Build();
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, BackgammonAchievementsFilter.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "GetAchievements";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {

            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new GetBackgammonAchievementsResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new GetBackgammonAchievementsResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, GetBackgammonAchievementsResponseContainer.class);
    }
}
