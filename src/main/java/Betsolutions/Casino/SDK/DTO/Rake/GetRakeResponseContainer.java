package Betsolutions.Casino.SDK.DTO.Rake;

public class GetRakeResponseContainer {
    public int StatusCode;
    public GetRakeResponse Data;
    public String Message;

    public GetRakeResponseContainer(int statusCode, String message){
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
