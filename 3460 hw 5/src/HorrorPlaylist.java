import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class HorrorPlaylist
{  
    
    
    public HorrorPlaylist(File f) throws IOException
    {
        readLines(f);
    }
    /*
     * a sloppy class i know
     * this class is responcible for reading and writing to files as well
     * as the logic of calculating clicks
     */
    public void readLines(File f) throws IOException
    {

        FileReader fr = new FileReader(f);
        FileWriter fw = new FileWriter("horrorPlaylist.out");
    
        BufferedReader br = new BufferedReader(fr);
        String line;
        line = br.readLine();
    
        String[] split = line.split("\\s+");
        
        //number of elements
        int number = Integer.parseInt(split[0]);

        //different video types
        int types = Integer.parseInt(split[1]);
        
        line = br.readLine();
        
        //our "videos"
        String[] videos = line.split("\\s+");
        
        
        line = br.readLine();
        
        
        String[] order = line.split("\\s+");
        
        int[] labeledOrder = convert(number, videos, order);
        
        //1 to account for the first insert of current
        int clickCounter = 1;
        int current = -1;
        boolean hasSeen = false;
        int previous;
        
        
        //goes through each now ordered type if its the first time seeing the video it requires a click if and if you 
        //have to skip over videos then its a click should run in n^2 time 
        for(int i = 0; i < types; i++)
        {
            hasSeen = false;
            for(int j = 0; j < number; j++)
            {
                previous = current;
                current = labeledOrder[j];
                if(current == i )
                {
                    
                    if (previous > current && hasSeen == true)
                    {
                        clickCounter += 1; 
                    }
                    if (hasSeen == false)
                    {
                        hasSeen = true;
                        clickCounter +=1;
                    }
                }
            }
        }
        fw.write(clickCounter + "\n");
        

        
        
        
        
        
        fr.close();
        fw.close();
        br.close();
    }
    
    
    /*
     *this function takes the unordered array and orders it based on whats listed in the ordered array 
     * 
     * params: number length of our array
     * params: videos the actual array of unordered strings
     * params: order the corect order were looking for
     */
    private int[] convert(int number, String[] videos, String[] order)
    {
        int[] ordered = new int[number];
        
        //for each type we must go and set it to the correct value
        for(int i = 0; i < number; i++)
        {
            ordered[i] = Integer.parseInt(order[Integer.parseInt(videos[i])-1]);
        }
        
        return ordered;
    }




    
    
}
