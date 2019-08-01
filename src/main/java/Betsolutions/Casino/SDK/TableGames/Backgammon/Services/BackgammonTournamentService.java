package Betsolutions.Casino.SDK.TableGames.Backgammon.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.Enums.StatusCode;
import Betsolutions.Casino.SDK.Services.BaseService;
import Betsolutions.Casino.SDK.TableGames.Backgammon.DTO.BackgammonTournamentsFilter;
import Betsolutions.Casino.SDK.TableGames.Backgammon.DTO.GetBackgammonTournamentsResponseContainer;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class BackgammonTournamentService extends BaseService {
    public BackgammonTournamentService(MerchantAuthInfo merchantAuthInfo) {
        super(merchantAuthInfo, "BackgammonTournament");
    }

    public GetBackgammonTournamentsResponseContainer GetTournaments(BackgammonTournamentsFilter requestModel) {

        HashBuilder hashBuilder = GetHashBuilder(merchantAuthInfo.PrivateKey);

        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.EndDateTo);
        hashBuilder.Add(requestModel.EndDateFrom);
        hashBuilder.Add(requestModel.GameTypeId);
        hashBuilder.Add(requestModel.OrderingDirection);
        hashBuilder.Add(requestModel.OrderingField);
        hashBuilder.Add(requestModel.PageIndex);
        hashBuilder.Add(requestModel.PageSize);
        hashBuilder.Add(requestModel.StartDateFrom);
        hashBuilder.Add(requestModel.StartDateTo);
        hashBuilder.Add(requestModel.TournamentTypeId);

        requestModel.Hash = hashBuilder.Build();
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, BackgammonTournamentsFilter.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "GetTournaments";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {

            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new GetBackgammonTournamentsResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new GetBackgammonTournamentsResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, GetBackgammonTournamentsResponseContainer.class);
    }
}
