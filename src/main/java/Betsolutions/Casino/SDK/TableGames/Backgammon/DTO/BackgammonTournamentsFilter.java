package Betsolutions.Casino.SDK.TableGames.Backgammon.DTO;

import java.util.Date;

public class BackgammonTournamentsFilter {
    public Date StartDateFrom;
    public Date StartDateTo;
    public Date EndDateFrom;
    public Date EndDateTo;
    public Integer GameTypeId;
    public Integer TournamentTypeId;
    public int MerchantId;
    public Integer PageSize;
    public int PageIndex;
    public String OrderingField;
    public String OrderingDirection;
    public String Hash;

    public BackgammonTournamentsFilter(int pageIndex, int pageSize) {
        this.PageIndex = pageIndex;
        this.PageSize = pageSize;
    }
}
