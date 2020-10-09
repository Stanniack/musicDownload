import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            new DownloadMusicFacade().listDownloadFacade(new HTTPRequest()
                    .openFile("C:\\Users\\Mateus\\OneDrive\\Área de Trabalho\\cantores.txt"));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
