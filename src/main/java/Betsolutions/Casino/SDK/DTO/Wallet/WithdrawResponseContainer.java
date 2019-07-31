package Betsolutions.Casino.SDK.DTO.Wallet;

public class WithdrawResponseContainer {
    public int StatusCode;
    public DepositResponse Data;
    public String Message;

    public WithdrawResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
