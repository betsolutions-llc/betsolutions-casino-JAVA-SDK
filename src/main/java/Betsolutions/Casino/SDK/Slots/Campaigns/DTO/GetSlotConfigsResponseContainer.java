package Betsolutions.Casino.SDK.Slots.Campaigns.DTO;

public class GetSlotConfigsResponseContainer {
    public int StatusCode;
    public String Message;
    public GetSlotConfigsResponse Data;

    public GetSlotConfigsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
