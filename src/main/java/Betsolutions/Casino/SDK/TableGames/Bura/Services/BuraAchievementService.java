package Betsolutions.Casino.SDK.TableGames.Bura.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.Enums.StatusCode;
import Betsolutions.Casino.SDK.Services.BaseService;
import Betsolutions.Casino.SDK.TableGames.Bura.DTO.BuraAchievementsFilter;
import Betsolutions.Casino.SDK.TableGames.Bura.DTO.GetBuraAchievementsResponseContainer;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class BuraAchievementService extends BaseService {
    public BuraAchievementService(MerchantAuthInfo merchantAuthInfo) {
        super(merchantAuthInfo, "BuraAchievement");
    }

    public GetBuraAchievementsResponseContainer GetAchievements(BuraAchievementsFilter requestModel) {

        HashBuilder hashBuilder = GetHashBuilder(merchantAuthInfo.PrivateKey);

        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.AchievementTypeId);
        hashBuilder.Add(requestModel.OrderingDirection);
        hashBuilder.Add(requestModel.OrderingField);
        hashBuilder.Add(requestModel.PageIndex);
        hashBuilder.Add(requestModel.PageSize);

        requestModel.Hash = hashBuilder.Build();
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, BuraAchievementsFilter.class);

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

            return new GetBuraAchievementsResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new GetBuraAchievementsResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, GetBuraAchievementsResponseContainer.class);
    }
}
