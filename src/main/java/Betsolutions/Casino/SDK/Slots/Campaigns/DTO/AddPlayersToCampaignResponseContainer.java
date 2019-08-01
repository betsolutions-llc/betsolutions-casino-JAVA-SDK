package Betsolutions.Casino.SDK.Slots.Campaigns.DTO;

public class AddPlayersToCampaignResponseContainer {
    public int StatusCode;
    public String Message;

    public AddPlayersToCampaignResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
