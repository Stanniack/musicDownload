import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.http.HttpClient;

public class Download {

    public void downloadFileByUrlAndFile(String urlContent, String fileDirectory) {

        try {
            URL url = new URL(urlContent);
            System.out.println(url.getPath());
            File file = new File(fileDirectory);
            FileUtils.copyURLToFile(url, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
