import org.apache.http.protocol.HTTP;
import utils.OpenFile;
import utils.Tabs;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            List<String> songList = new OpenFile().openSongListFile("C:\\Users\\Mateus\\OneDrive\\Área de Trabalho\\cantores.txt");
            new DownloadMusicFacade().listDownloadFacade(songList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //new Tabs().closeAllSecondaryTabs(null);

    }
}
