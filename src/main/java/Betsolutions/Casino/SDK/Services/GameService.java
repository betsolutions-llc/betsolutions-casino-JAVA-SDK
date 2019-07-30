package Betsolutions.Casino.SDK.Services;

import Betsolutions.Casino.SDK.DTO.Game.GetGamesResponseContainer;
import Betsolutions.Casino.SDK.DTO.MerchantAuthInfo;
import Betsolutions.Casino.SDK.Internal.GameRepository;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class GameService extends BaseService {

    private GameRepository gameRepository;

    public GameService(MerchantAuthInfo merchantAuthInfo) {
        super(merchantAuthInfo);
        this.gameRepository = new GameRepository(merchantAuthInfo);
    }

    public GetGamesResponseContainer GetGames() {
        try {
            return this.gameRepository.GetGames();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
