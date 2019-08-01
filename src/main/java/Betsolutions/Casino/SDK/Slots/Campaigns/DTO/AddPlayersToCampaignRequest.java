package Betsolutions.Casino.SDK.Slots.Campaigns.DTO;

import java.util.List;

public class AddPlayersToCampaignRequest {
    public int MerchantId;
    public int CampaignId;
    public List<String> PlayerIds;
    public String Hash;
}
