import org.apache.http.protocol.HTTP;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            new DownloadMusicFacade().listDownloadFacade(Arrays.asList(
                    "https://www.youtube.com/watch?v=AER3spDdLiY",
                    "https://www.youtube.com/watch?v=7ZyMEy64zS4",
                    "https://www.youtube.com/watch?v=J7p4bzqLvCw",
                    "https://www.youtube.com/watch?v=xXD5tltX9Pg",
                    "https://www.youtube.com/watch?v=Nj2U6rhnucI",
                    "https://www.youtube.com/watch?v=ApXoWvfEYVU",
                    "https://youtube.com/watch?v=PMivT7MJ41M",
                    "https://www.youtube.com/watch?v=weeI1G46q0o",
                    "https://www.youtube.com/watch?v=JXRN_LkCa_o",
                    "https://www.youtube.com/watch?v=w6QGe-pXgdI"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
