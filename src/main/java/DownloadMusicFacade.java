import java.net.http.HttpRequest;
import java.util.List;

public class DownloadMusicFacade {

    public void listDownloadFacade(List<String> songsList) throws InterruptedException {
        new HTTPRequest().RequestSessionYtmp3(songsList);
    }
}
