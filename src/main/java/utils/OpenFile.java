package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenFile {

    public List<String> openSongListFile(String songListFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(songListFile));
        List<String> list = new ArrayList<>();

        while (bufferedReader.ready()) {
            list.add(bufferedReader.readLine());
        }

        return list;
    }
}
