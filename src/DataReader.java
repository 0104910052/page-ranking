import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by exil33t on 9/1/2017.
 */
public class DataReader {
    private final String path = "/search-engine/";    // relative to C:
    private File folder;
    private ArrayList<File> files;
    private ArrayList<Page> pages;


    public DataReader() {
        files = new ArrayList<>();
        pages = new ArrayList<>();
        try{
            folder = new File(path);
            files = new ArrayList<>(Arrays.asList(folder.listFiles()));
            readFiles();
        }catch(Exception e){
            System.out.println("Please reconfigure path provided.");
        }
    }

    private void readFiles() {
        files.forEach(p -> addPage(p));
    }

    private void addPage(File p) {
        try {
            String txt = new String(Files.readAllBytes(p.toPath()));
            pages.add(new Page(txt, p.getPath()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Page> getPages(){
        return pages;
    }

}
