package Betsolutions.Casino.SDK.Slots.Campaigns.DTO;

import java.util.Date;

public class GetSlotCampaignsRequest {
    public String Name;
    public Integer GameId;
    public Integer StatusId;
    public Date StartDateFrom;
    public Date StartDateTo;
    public Date EndDateFrom;
    public Date EndDateTo;
    public int PageSize;
    public int PageIndex;
    public int MerchantId;
    public String OrderingField;
    public String OrderingDirection;
    public Integer CampaignId;
    public String Hash;

    public GetSlotCampaignsRequest(int pageIndex, int pageSize) {
        this.PageIndex = pageIndex;
        this.PageSize = pageSize;
    }
}
