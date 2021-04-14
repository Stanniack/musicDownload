import botsMp3Converser.Ytmp3;

import java.net.http.HttpRequest;
import java.util.List;

public class DownloadMusicFacade {

    public void listDownloadFacade(List<String> songsList) throws InterruptedException {
        new Ytmp3().requestSession(songsList);
    }
}
