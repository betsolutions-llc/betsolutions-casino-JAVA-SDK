package Betsolutions.Casino.SDK.TableGames.Okey.DTO;


import java.util.Date;
import java.util.List;

public class OkeyAchievement {
    public int Id;
    public Date CreateDate;
    public int AchievementTypeId;
    public int Count;
    public int MinRank;
    public double Prize;
    public boolean IsActive;
    public List<OkeyAchievementTranslation> Translations;
    public int FilteredCount;
    public boolean IsNetwork;
}
