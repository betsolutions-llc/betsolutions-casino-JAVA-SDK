package Betsolutions.Casino.SDK.Slots.Campaigns.DTO;

public class CreateSlotCampaignResponseContainer {
    public int StatusCode;
    public String Message;
    public CreateSlotCampaignResponse Data;

    public CreateSlotCampaignResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
