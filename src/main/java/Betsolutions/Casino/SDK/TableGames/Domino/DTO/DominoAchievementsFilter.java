package Betsolutions.Casino.SDK.TableGames.Domino.DTO;

public class DominoAchievementsFilter { public Integer AchievementTypeId;
    public int MerchantId;
    public int PageSize;
    public int PageIndex;
    public String OrderingField;
    public String OrderingDirection;
    public String Hash;

    public DominoAchievementsFilter(int pageIndex, int pageSize) {
        this.PageIndex = pageIndex;
        this.PageSize = pageSize;
    }
}
