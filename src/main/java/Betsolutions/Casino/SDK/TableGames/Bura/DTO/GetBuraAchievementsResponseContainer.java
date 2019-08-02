package Betsolutions.Casino.SDK.TableGames.Bura.DTO;

public class GetBuraAchievementsResponseContainer {
    public int StatusCode;
    public BuraAchievementPagingResult Data;
    public String Message;

    public GetBuraAchievementsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
