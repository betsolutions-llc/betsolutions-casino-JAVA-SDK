package Betsolutions.Casino.SDK.DTO.Rake;

public class GetRakeDetailedResponseContainer {
    public int StatusCode;
    public GetRakeDetailedResponse Data;
    public String Message;

    public GetRakeDetailedResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
