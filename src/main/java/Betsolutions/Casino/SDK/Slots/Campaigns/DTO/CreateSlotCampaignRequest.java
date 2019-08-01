package Betsolutions.Casino.SDK.Slots.Campaigns.DTO;

import java.util.Date;
import java.util.List;

public class CreateSlotCampaignRequest {
    public List<SlotCampaignBetAmountCurrency> BetAmountsPerCurrency;
    public int CampaignTypeId;
    public Date EndDate;
    public int FreespinCount;
    public int GameId;
    public String Name;
    public List<String> PlayerIds;
    public Date StartDate;
    public boolean AddNewlyRegisteredPlayers;
    public String Hash;
    public int MerchantId;
}
