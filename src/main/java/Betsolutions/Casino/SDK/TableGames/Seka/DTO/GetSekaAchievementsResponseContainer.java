package Betsolutions.Casino.SDK.TableGames.Seka.DTO;


public class GetSekaAchievementsResponseContainer {
    public int StatusCode;
    public SekaAchievementsPagingResult Data;
    public String Message;

    public GetSekaAchievementsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
