package Betsolutions.Casino.SDK.TableGames.Okey.DTO;


public class GetOkeyTournamentsResponseContainer {
    public int StatusCode;
    public OkeyTournamentPagingResult Data;
    public String Message;

    public GetOkeyTournamentsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
