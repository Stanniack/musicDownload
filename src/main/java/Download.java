import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Download {

    public void downloadFileByUrlAndFile(String urlContent, String fileDirectory) {

        try {
            URL url = new URL(urlContent);
            File file = new File(fileDirectory);
            FileUtils.copyURLToFile(url, file);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
