import java.io.*;
public class candyCounter
{
    public candyCounter(File f) throws IOException
    {
        readLines(f);
    }
    
    public void readLines(File f) throws IOException
    {
        FileReader fr = new FileReader(f);
        FileWriter fw = new FileWriter("candycollector.out");
        
        BufferedReader br = new BufferedReader(fr);
        String line;
        line = br.readLine();
        
        String[] split = line.split("\\s+");
        int types = Integer.parseInt(split[0]);
        int missing = 0;
        int candy;
        boolean gotAll = true;
        boolean cHave[] = new boolean[types]; 
        
        while((line = br.readLine()) != null)
        {
            candy = Integer.parseInt(line);
            if(cHave[(candy - 1)] == false)
            {
                cHave[(candy - 1)] = true;
            }
        }
        for(int i = 0; i < types; i++)
        {
            if(cHave[i] == false) 
            {
                gotAll = false;
                missing += 1;
                
            }
            
        }
        if(gotAll == true)
        {
            fw.write("Yay! all "+types+" type(s) of candies collected.\n");
            
        }
        else
        {
            fw.write("Missing "+missing+" type(s) of candy.\n");
        }
        
        br.close();
        fr.close();
        fw.close();
    }
    
}
