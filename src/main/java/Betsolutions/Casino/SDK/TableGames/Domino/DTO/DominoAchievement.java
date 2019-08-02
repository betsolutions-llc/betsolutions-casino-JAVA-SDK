package Betsolutions.Casino.SDK.TableGames.Domino.DTO;


import java.util.Date;
import java.util.List;

public class DominoAchievement {
    public int Id;
    public Date CreateDate;
    public int AchievementTypeId;
    public int Count;
    public int MinRank;
    public double Prize;
    public boolean IsActive;
    public List<DominoAchievementTranslation> Translations;
    public int FilteredCount;
    public boolean IsNetwork;
}
