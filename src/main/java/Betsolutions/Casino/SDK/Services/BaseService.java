package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;

public abstract class BaseService {

    protected MerchantAuthInfo merchantAuthInfo;

    public BaseService(MerchantAuthInfo merchantAuthInfo) {
        this.merchantAuthInfo = merchantAuthInfo;
    }
}
