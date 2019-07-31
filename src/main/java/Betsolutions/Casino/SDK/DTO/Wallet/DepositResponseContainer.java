package Betsolutions.Casino.SDK.DTO.Wallet;

public class DepositResponseContainer {
    public int StatusCode;
    public DepositResponse Data;
    public String Message;

    public DepositResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
