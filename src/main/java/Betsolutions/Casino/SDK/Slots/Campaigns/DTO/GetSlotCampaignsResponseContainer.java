package Betsolutions.Casino.SDK.Slots.Campaigns.DTO;

public class GetSlotCampaignsResponseContainer {
    public int StatusCode;
    public String Message;
    public GetSlotCampaignsResponse Data;

    public GetSlotCampaignsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
