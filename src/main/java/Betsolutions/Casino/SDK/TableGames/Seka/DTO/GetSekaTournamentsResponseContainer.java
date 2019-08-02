package Betsolutions.Casino.SDK.TableGames.Seka.DTO;


public class GetSekaTournamentsResponseContainer {
    public int StatusCode;
    public SekaTournamentsPagingResult Data;
    public String Message;

    public GetSekaTournamentsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
