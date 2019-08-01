package Betsolutions.Casino.SDK.Slots.Campaigns.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.Enums.StatusCode;
import Betsolutions.Casino.SDK.Services.BaseService;
import Betsolutions.Casino.SDK.Slots.Campaigns.DTO.*;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;
import java.util.Objects;

public class SlotCampaignService extends BaseService {
    public SlotCampaignService(MerchantAuthInfo merchantAuthInfo) {
        super(merchantAuthInfo, "SlotCampaign");
    }

    public CreateSlotCampaignResponseContainer CreateSlotCampaign(CreateSlotCampaignRequest requestModel) {

        HashBuilder hashBuilder = GetHashBuilder(merchantAuthInfo.PrivateKey);

        hashBuilder.Add(requestModel.CampaignTypeId);
        hashBuilder.Add(requestModel.EndDate);
        hashBuilder.Add(requestModel.StartDate);
        hashBuilder.Add(requestModel.FreespinCount);
        hashBuilder.Add(requestModel.GameId);
        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.Name);
        hashBuilder.Add(requestModel.BetAmountsPerCurrency);
        hashBuilder.Add(requestModel.PlayerIds);

        requestModel.Hash = hashBuilder.Build();
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, CreateSlotCampaignRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "CreateSlotCampaign";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {

            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new CreateSlotCampaignResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new CreateSlotCampaignResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, CreateSlotCampaignResponseContainer.class);
    }

    public AddPlayersToCampaignResponseContainer AddPlayersToCampaign(AddPlayersToCampaignRequest requestModel) {

        HashBuilder hashBuilder = GetHashBuilder(merchantAuthInfo.PrivateKey);

        hashBuilder.Add(requestModel.CampaignId);
        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.PlayerIds);

        requestModel.Hash = hashBuilder.Build();
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, AddPlayersToCampaignRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "AddPlayersToSlotCampaign";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {

            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new AddPlayersToCampaignResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new AddPlayersToCampaignResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, AddPlayersToCampaignResponseContainer.class);
    }

    public DeactivateSlotCampaignResponseContainer DeactivateSlotCampaign(DeactivateSlotCampaignRequest requestModel) {

        HashBuilder hashBuilder = GetHashBuilder(merchantAuthInfo.PrivateKey);

        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.Id);

        requestModel.Hash = hashBuilder.Build();
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, DeactivateSlotCampaignRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "DeactivateSlotCampaign";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {

            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new DeactivateSlotCampaignResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new DeactivateSlotCampaignResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, DeactivateSlotCampaignResponseContainer.class);
    }

    public GetSlotConfigsResponseContainer GetSlotConfigs() {

        GetSlotConfigsRequest requestModel = new GetSlotConfigsRequest();

        HashBuilder hashBuilder = GetHashBuilder(merchantAuthInfo.PrivateKey);

        hashBuilder.Add(this.merchantAuthInfo.MerchantId);

        requestModel.Hash = hashBuilder.Build();
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, GetSlotConfigsRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "GetMerchantSlotConfigs";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {

            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new GetSlotConfigsResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new GetSlotConfigsResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, GetSlotConfigsResponseContainer.class);
    }

    public GetSlotCampaignsResponseContainer GetSlotCampaigns(GetSlotCampaignsRequest requestModel) {

        HashBuilder hashBuilder = GetHashBuilder(merchantAuthInfo.PrivateKey);

        hashBuilder.Add(this.merchantAuthInfo.MerchantId);
        hashBuilder.Add(requestModel.CampaignId);
        hashBuilder.Add(requestModel.EndDateFrom);
        hashBuilder.Add(requestModel.EndDateTo);
        hashBuilder.Add(requestModel.StartDateFrom);
        hashBuilder.Add(requestModel.StartDateTo);
        hashBuilder.Add(requestModel.StatusId);
        hashBuilder.Add(requestModel.GameId);
        hashBuilder.Add(requestModel.Name);
        hashBuilder.Add(requestModel.OrderingDirection);
        hashBuilder.Add(requestModel.OrderingField);
        hashBuilder.Add(requestModel.PageIndex);
        hashBuilder.Add(requestModel.PageSize);

        requestModel.Hash = hashBuilder.Build();
        requestModel.MerchantId = merchantAuthInfo.MerchantId;

        String requestJsonStr = gson.toJson(requestModel, GetSlotCampaignsRequest.class);

        RequestBody body = RequestBody.create(requestJsonStr, JSON);

        String url = this.baseUrl + "GetSlotCampaigns";

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();

        Response response;

        try {

            response = httpClient.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();

            return new GetSlotCampaignsResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        String responseBodyStr;

        try {
            responseBodyStr = Objects.requireNonNull(response.body()).string();
        } catch (IOException | NullPointerException e) {
            e.printStackTrace();
            return new GetSlotCampaignsResponseContainer(StatusCode.GeneralError, e.getMessage());
        }

        return gson.fromJson(responseBodyStr, GetSlotCampaignsResponseContainer.class);
    }

    class GetSlotConfigsRequest {
        public int MerchantId;
        public String Hash;
    }
}
