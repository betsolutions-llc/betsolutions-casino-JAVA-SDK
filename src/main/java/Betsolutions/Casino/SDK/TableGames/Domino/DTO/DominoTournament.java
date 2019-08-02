package Betsolutions.Casino.SDK.TableGames.Domino.DTO;


import java.util.Date;
import java.util.List;

public class DominoTournament {
    public int Id;
    public float BetAmount;
    public float Prize;
    public int MaxPlayerCount;
    public int MinPlayerCount;
    public int RegisteredPlayerCount;
    public int TournamentTypeId;
    public Date StartDate;
    public Date EndDate;
    public int StatusId;
    public int GameTypeId;
    public Date CreateDate;
    public boolean IsHidden;
    public List<DominoTournamentTranslation> Translations;
    public int FilteredCount;
    public boolean IsNetwork;
    public int FinalPoint;
    public List<DominoTournamentPrize> Prizes;
}
