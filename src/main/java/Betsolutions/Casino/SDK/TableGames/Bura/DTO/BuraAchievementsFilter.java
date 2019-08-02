package Betsolutions.Casino.SDK.TableGames.Bura.DTO;

public class BuraAchievementsFilter {
    public Integer AchievementTypeId;
    public int MerchantId;
    public int PageSize;
    public int PageIndex;
    public String OrderingField;
    public String OrderingDirection;
    public String Hash;

    public BuraAchievementsFilter(int pageIndex, int pageSize) {
        this.PageIndex = pageIndex;
        this.PageSize = pageSize;
    }
}
