package Betsolutions.Casino.SDK.TableGames.Bura.DTO;


import java.util.Date;
import java.util.List;

public class BuraAchievement {
    public int Id;
    public Date CreateDate;
    public int AchievementTypeId;
    public int Count;
    public int MinRank;
    public double Prize;
    public boolean IsActive;
    public List<BuraAchievementTranslation> Translations;
    public int FilteredCount;
    public boolean IsNetwork;
}
