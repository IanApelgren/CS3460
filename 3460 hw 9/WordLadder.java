import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WordLadder {
	private static String start;
	private static String end;
	private static StringMap T;			// This map stores the dictionary of words.
	private static StringMap R;			// This map keeps track of all the words that are visited during breadth-first-search.
	static String[] stack;
    static int index;																// The key field is the word that is visited, and its value field can hold the predecessor pointer.
	private static Queue Q;					// A queue to perform the breadth-first-search.

	public static void main(String [] args) throws IOException {
		// Loading the dictionary of words into the StringMap T.
		T = new StringMap();
		File file = new File("dictionary4");
		Scanner f = new Scanner(file);
		while (f.hasNext()) {
			String word = f.nextLine();
			T.insert(word, "");
		}
		f.close();

		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the start word: ");
		start = kb.nextLine();
		System.out.print("Enter the end word: ");
		end = kb.nextLine();

		// TODO: Solution to find the shortest set of words that transforms the start word to the end word.
		Q = new Queue();
		Q.enqueue(new QNode(0, start));
		stack = new String[1000];
        index = 0;
		//boolean dfsCheck = false;
		boolean dfsCheck = dfs(start, end);
		if(dfsCheck == true)
		{
		    System.out.println("Yay! A word ladder is possible");
		    for (int i = index; i > 0; i--)
            {
               System.out.println(pop());
            }
		}
		

	}
	
	public static boolean dfs(String word1, String word2)
	{
	    //looking at letters for it they are like word 2 we swap
	   for (int i = 0; i < word1.length(); i++)
	   {
	       //looping through letters
	       for(char j = 'a'; j < 'z'; j++)
	       {
	           char[] newWord = word1.toCharArray();
	           newWord[i] = j;
	           String strWord = new String(newWord);
	           if(T.find(strWord)  != null)
	           {
	               //R.insert(strWord, word1);
	               push(strWord);
	               if(strWord.equals(word2))
	               {
	                   return true;
	               }
	           }
	           
	       }
	   }
	    
	    
	    
        return false;
	    
	}
	
	public static boolean check(boolean a,boolean b)
    {
        //var = a||b
        if( a == true || b == true)
        {
            return true;
        }
        else 
        {
            return false;
        }
        
    }
	
	//push for stack function
    public static void push(String str)
    {
        stack[index] = str;
        index = index + 1;
    }
    
    //pop for stack function
    public static String pop()
    {
        if (index > 0)
        {
            index = index - 1;
            return stack[index];
        }
        else
        {
            return null;
        }
    }
 
}
