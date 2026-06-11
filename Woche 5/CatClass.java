import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CatClass{
    static void cat(File quelle) throws IOException{
        try (RandomAccessFile r = new RandomAccessFile(quelle, "r");){
            String zeile;
            while((zeile = r.readLine()) != null) {
                System.out.println(zeile);
            }
        } catch (IOException e) {
            System.out.print("Fehler gefunden");
            e.printStackTrace();
            throw e;
        }
    }
}
