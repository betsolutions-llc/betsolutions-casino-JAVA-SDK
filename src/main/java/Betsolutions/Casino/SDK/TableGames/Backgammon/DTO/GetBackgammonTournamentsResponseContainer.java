package Betsolutions.Casino.SDK.TableGames.Backgammon.DTO;

public class GetBackgammonTournamentsResponseContainer {
    public int StatusCode;
    public BackgammonTournamentPagingResult Data;
    public String Message;

    public GetBackgammonTournamentsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
