package Betsolutions.Casino.SDK.TableGames.Okey.DTO;

public class OkeyAchievementsFilter {
    public Integer AchievementTypeId;
    public int MerchantId;
    public int PageSize;
    public int PageIndex;
    public String OrderingField;
    public String OrderingDirection;
    public String Hash;

    public OkeyAchievementsFilter(int pageIndex, int pageSize) {
        this.PageIndex = pageIndex;
        this.PageSize = pageSize;
    }
}
