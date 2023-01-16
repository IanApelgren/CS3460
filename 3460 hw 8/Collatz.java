import java.util.Scanner;


public class Collatz
{
    static long[] collatzKeeper;

    public static void main(String[] args)
    {
        System.out.print("Enter the range: ");
        Scanner scanner = new Scanner(System.in);
        initilize();
        
        long a = scanner.nextInt();
        
        long b = scanner.nextInt();
        //System.out.println(a + b);
        
        
        //if our range is good run
        if( (a >= 1 && a <= b) && (b >= a && b <= 100000000))
        {
            //the greatest we will return
            long greatest = 0;
            long greatestCounter = 0;
            
            for (long i = a; i <= b; i++)
            {
                
                long iCounter = 0;
                iCounter = collatzLength(i);
                
                
                
                //check if its bigger than our current greatest
                if (iCounter > greatestCounter)
                {
                    greatest = i;
                    greatestCounter = iCounter;
                }
            }
            //after the for loop print
            System.out.println("The number with the maximum Collatz length in the range: " + greatest);
            System.out.println("Its Collatz length: " + greatestCounter);
        }
        else
        {
            System.out.println("please make sure a is bigger than or equal to b");
        }
        scanner.close();

    }
    
    /**
     * a shell for what we really need to do
     * @param x
     * @return
     */
    public static long collatzLength(long x)
    {
        long retCounter = 0;
        retCounter = collatzLength(x, retCounter); 
        
        return retCounter;
    }
    
    /**
     * where the magic happens responsible for recursivly going through x's itterations and checking if we already have them
     * rather than computing
     * @param x
     * @param counter
     * @return
     */
    private static long collatzLength(long x, long counter)
    {
        //System.out.println(x + " " + counter);
        if (x == 0)
        {
            
            return counter;
        }
        if (x == 1)
        {
            
            return counter + 1;
        }
        
        //if x is even
        else if (x % 2 == 0)
        {
            //check if we have it first
            if(getCollatz(x) != 0)
            {
                
               return(getCollatz(x) + counter); 
            }
            //see if we have the next one
            else if(getCollatz((x/2)) != 0)
            {
                
                counter = getCollatz((x/2)) + counter + 1;
                setCollatz(x, getCollatz((x/2)) + 1);
                return(counter);
                
            }
            else
            {
                
                counter = counter + 1;
                x = x/2;
                return collatzLength(x, counter);
            }
        }
        
        //if x is odd
        else
        {
            //check if we have it first
            if(getCollatz(x) != 0)
            {  
               return(getCollatz(x) + counter); 
            }
            //see if we have the next one
            else if(getCollatz( ((x*3)+1) ) != 0)
            {
                
                counter = getCollatz( ((x*3)+1) )  + counter + 1;
                setCollatz(x, getCollatz( ((x*3)+1) ) + 1);
                return(counter);
                
            }
            else
            {
                
                counter = counter + 1;
                x = (x*3) + 1;
                return collatzLength(x, counter);
                
            }
        }
            
        
    }
    
    
    
    /**
     * starts the array at 1- 100000000
     */
    private static void initilize()
    {
        collatzKeeper = new long[100000001];
        setCollatz(1,1);
        
    }
    
    private static void setCollatz(long x, long input)
    {
        if(x <= 100000000)
        {
            collatzKeeper[(int)x] = input;
        }
    }
    
    private static long getCollatz(long index)
    {
        if(index <= 100000000)
        {
            return collatzKeeper[(int)index];
        }
        else
        {
            return 0;
        }
    }

}
