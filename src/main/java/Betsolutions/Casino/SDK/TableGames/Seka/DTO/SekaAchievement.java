package Betsolutions.Casino.SDK.TableGames.Seka.DTO;


import java.util.Date;
import java.util.List;

public class SekaAchievement {
    public int Id;
    public Date CreateDate;
    public int AchievementTypeId;
    public int Count;
    public int MinRank;
    public double Prize;
    public boolean IsActive;
    public List<SekaAchievementTranslation> Translations;
    public int FilteredCount;
    public boolean IsNetwork;
    public Integer Card;
}
