import java.net.http.HttpRequest;
import java.util.List;

public class DownloadMusicFacade {

    public void listDownloadFacade (List<String> songsList) throws InterruptedException {
        for (String song : songsList) {
            new HTTPRequest().RequestSessionYtmp3(song);
        }
    }
}
