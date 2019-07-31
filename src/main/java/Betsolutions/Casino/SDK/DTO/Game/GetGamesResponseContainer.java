package Betsolutions.Casino.SDK.DTO.Game;

public class GetGamesResponseContainer {
    public int StatusCode;
    public GetGamesResponse Data;
    public String Message;

    public GetGamesResponseContainer(int statusCode, String message){
        this.Message = message;
        this.StatusCode = statusCode;
    }
}
