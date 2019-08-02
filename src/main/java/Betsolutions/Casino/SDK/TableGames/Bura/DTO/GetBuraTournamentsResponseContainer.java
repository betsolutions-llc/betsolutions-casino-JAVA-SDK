package Betsolutions.Casino.SDK.TableGames.Bura.DTO;


public class GetBuraTournamentsResponseContainer {
    public int StatusCode;
    public BuraTournamentPagingResult Data;
    public String Message;

    public GetBuraTournamentsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
