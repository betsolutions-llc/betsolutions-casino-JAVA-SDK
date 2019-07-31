package Betsolutions.Casino.SDK.Enums;

public class StatusCode {
    public static final int Success = 200;
    public static final int AlreadyProcessedTransaction = 201;
    public static final int InactiveToken = 401;
    public static final int InsufficientBalance = 402;
    public static final int InvalidHash = 403;
    public static final int InvalidToken = 404;
    public static final int TransferLimit = 405;
    public static final int UserNotFound = 406;
    public static final int InvalidAmount = 407;
    public static final int DuplicatedTransactionId = 408;
    public static final int SessionExpired = 409;
    public static final int InvalidCurrency = 410;
    public static final int InvalidRequest = 411;
    public static final int GeneralError = 500;
}
