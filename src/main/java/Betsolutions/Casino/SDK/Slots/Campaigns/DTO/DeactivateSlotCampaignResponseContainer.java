package Betsolutions.Casino.SDK.Slots.Campaigns.DTO;

public class DeactivateSlotCampaignResponseContainer {
    public int StatusCode;
    public String Message;
    public CreateSlotCampaignResponse Data;

    public DeactivateSlotCampaignResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
