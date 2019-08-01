package Betsolutions.Casino.SDK.Slots.Campaigns.DTO;

public class DeactivateSlotCampaignRequest {
    public int Id;
    public int MerchantId;
    public String Hash;

    public DeactivateSlotCampaignRequest(int campaignId){
        this.Id = campaignId;
    }
}
