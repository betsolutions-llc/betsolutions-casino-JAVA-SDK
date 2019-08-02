package Betsolutions.Casino.SDK.TableGames.Domino.DTO;


public class GetDominoTournamentsResponseContainer
{
    public int StatusCode;
    public DominoTournamentsPagingResult Data;
    public String Message;

    public GetDominoTournamentsResponseContainer(int statusCode, String message) {
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
