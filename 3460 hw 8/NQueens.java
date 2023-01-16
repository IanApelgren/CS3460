import java.util.Scanner;

public class NQueens
{
    //holds our current iteration
    static int[][] queens;
    //holds where queens ahve already been
    static int[][] pastQueens;
    static int[][] pastQueensCopy;
    static int counter;
    public static void main(String[] args)
    {
        System.out.print("Enter the number of queens: ");
        Scanner scanner = new Scanner(System.in);
        
        //so we dont put queens where theyve already been
        queens = pastQueens;
        pastQueensCopy = pastQueens;
        int n = scanner.nextInt();
        
        initilize(n);
        scanner.close();
        
        
            //update it with where queens have already been
            queens = pastQueens;
            pastQueensCopy = pastQueens;
            check_row(n);
        
        System.out.println("The number of valid arrangements is " + counter);
        
        
    }
    public static void check_row(int r)
    {
        int numberQueens = 0;
        check_row(r, numberQueens);
        
    }

    private static void check_row(int r, int numberQueens)
    {
        if (r == queens.length)
        {
            increment();
        }
        //check that theres a spot in the row
        int numBlocked = 0;
        for(int i = 0; i < queens.length-1; i++)
        {
            if( queens[r-1][i] == 2)
            {
                numBlocked +=1;
            }
            else if( queens[r-1][i] == 0)
            {
                setQueens(r,i);
            }
            
        }
        if (numBlocked == queens.length || r -1  <= queens.length)
        {
            return;
        }
        
        else
        {
             check_row(r-1, numberQueens-1);
        }
        
    }
    //makes our nxn array
    private static void initilize(int n)
    {
        queens = new int[n][n];
        pastQueens = new int[n][n];
        pastQueensCopy = new int[n][n];
        counter = 0;
        
    }
    public static void increment()
    {
        counter = counter+ 1;
    }
    
    /**
     * sets queen at i, j and blovks spaces she could attack
     * @param i
     * @param j
     */
    public static void setQueens( int i, int j)
    {
        if (i < queens.length && j < queens.length)
        {
            queens[i][j] = 1;
            pastQueens[i][j] = 2;
            
            for( int ni = i; ni < queens.length; ni++)
            {
                //horizontal blocked
                queens[ni][j] = 2;
                for ( int nj = j; nj < queens.length; nj++)
                {
                    //vertical blocked
                    queens[i][nj] = 2;
                    //diagnal blocked
                    queens[ni][nj] = 2;
                }
            }
        }
    }
    
}
