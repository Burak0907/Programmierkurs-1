import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class CopyClass {
    static void copy(File from, File to) throws IOException{
        RandomAccessFile r = null;
        RandomAccessFile w = null;
        try {
            r = new RandomAccessFile(from, "r");
            w = new RandomAccessFile(to, "rw"); 
            for(int i= 0; i< r.length(); i++){
                w.write(r.read());
            }
        } catch (IOException e) {
            System.out.print("Fehler gefunden");
            e.printStackTrace();
            throw e;
        } finally{
            if (r !=null) {
                try {
                    r.close();
                } catch (IOException e) {
                    System.out.println("Fehler beim Schließen der Quelldatei.");
                    e.printStackTrace();
                    throw e;
                }
            }
            if (w !=null) {
                try {
                    w.close();
                } catch (IOException e) {
                    System.out.println("Fehler beim Schließen der Zieldatei.");
                    e.printStackTrace();
                    throw e;
                }
            }
            
        }
    }
}