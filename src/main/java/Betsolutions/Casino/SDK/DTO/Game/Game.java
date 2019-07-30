package Betsolutions.Casino.SDK.DTO.Game;

import java.util.List;

public class Game {
    public int GameId ;
    public int ProductId ;
    public boolean HasFreePlay ;
    public String Name ;
    public String LaunchUrl ;
    public int RTP ;
    public int RakePercent ;
    public boolean HasMobileDeviceSupport ;
    public List<GameThumbnail> Thumbnails ;
}
