package Betsolutions.Casino.SDK.DTO.Wallet;

public class GetBalanceResponseContainer {
    public int StatusCode;
    public GetBalanceResponse Data;
    public String Message;

    public GetBalanceResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
