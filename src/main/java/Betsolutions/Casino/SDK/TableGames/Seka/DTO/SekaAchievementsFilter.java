package Betsolutions.Casino.SDK.TableGames.Seka.DTO;

public class SekaAchievementsFilter {
    public Integer AchievementTypeId;
    public int MerchantId;
    public int PageSize;
    public int PageIndex;
    public String OrderingField;
    public String OrderingDirection;
    public String Hash;

    public SekaAchievementsFilter(int pageIndex, int pageSize) {
        this.PageIndex = pageIndex;
        this.PageSize = pageSize;
    }
}
