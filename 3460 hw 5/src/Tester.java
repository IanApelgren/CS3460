import java.io.File;
import java.io.IOException;

public class Tester
{
    public static void main(String args[]) throws IOException
    {
        File h = new File("horrorplaylist.in");
        HorrorPlaylist hp = new HorrorPlaylist(h);
          
        File f = new File("candycollector.in");
        candyCounter cc = new candyCounter(f);
            
    }
}
