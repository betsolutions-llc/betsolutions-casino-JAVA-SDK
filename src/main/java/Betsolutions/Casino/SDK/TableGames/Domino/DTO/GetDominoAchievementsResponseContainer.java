package Betsolutions.Casino.SDK.TableGames.Domino.DTO;


public class GetDominoAchievementsResponseContainer {
    public int StatusCode;
    public DominoAchievementsPagingResult Data;
    public String Message;

    public GetDominoAchievementsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
