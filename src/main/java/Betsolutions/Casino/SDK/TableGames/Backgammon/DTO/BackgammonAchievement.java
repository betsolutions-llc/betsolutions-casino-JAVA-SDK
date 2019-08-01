package Betsolutions.Casino.SDK.TableGames.Backgammon.DTO;

import java.util.Date;
import java.util.List;

public class BackgammonAchievement {
    public int Id;
    public Date CreateDate;
    public int AchievementTypeId;
    public int Count;
    public int MinRank;
    public Integer Dice1;
    public Integer Dice2;
    public double Prize;
    public boolean IsActive;
    public List<BackgammonAchievementTranslation> Translations;
    public int FilteredCount;
    public boolean IsNetwork;
}
