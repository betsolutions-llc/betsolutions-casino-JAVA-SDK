package Betsolutions.Casino.SDK.TableGames.Backgammon.DTO;

public class BackgammonAchievementsFilter {
    public Integer AchievementTypeId;
    public int MerchantId;
    public int PageSize;
    public int PageIndex;
    public String OrderingField;
    public String OrderingDirection;
    public String Hash;

    public BackgammonAchievementsFilter(int pageIndex, int pageSize) {
        this.PageIndex = pageIndex;
        this.PageSize = pageSize;
    }
}
