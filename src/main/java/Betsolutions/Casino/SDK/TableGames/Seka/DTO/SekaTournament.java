package Betsolutions.Casino.SDK.TableGames.Seka.DTO;


import java.util.Date;
import java.util.List;

public class SekaTournament {
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
    public List<SekaTournamentTranslation> Translations;
    public int FilteredCount;
    public boolean IsNetwork;
    public int FinalPoint;
    public List<SekaTournamentPrize> Prizes;
    public boolean WithRebuy;
    public int RebuyMaxLevel;
}
