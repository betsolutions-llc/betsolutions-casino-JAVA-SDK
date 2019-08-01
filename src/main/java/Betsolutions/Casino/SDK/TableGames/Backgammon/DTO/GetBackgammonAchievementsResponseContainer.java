package Betsolutions.Casino.SDK.TableGames.Backgammon.DTO;

public class GetBackgammonAchievementsResponseContainer {
    public int StatusCode;
    public BackgammonAchievementPagingResult Data;
    public String Message;

    public GetBackgammonAchievementsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
