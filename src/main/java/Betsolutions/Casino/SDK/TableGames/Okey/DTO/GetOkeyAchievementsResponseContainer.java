package Betsolutions.Casino.SDK.TableGames.Okey.DTO;

public class GetOkeyAchievementsResponseContainer {
    public int StatusCode;
    public OkeyAchievementPagingResult Data;
    public String Message;

    public GetOkeyAchievementsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
