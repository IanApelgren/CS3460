import java.util.Scanner;
//3 actions
//fill jug
//
//

public class Jugs
{
    static int jug1; //size of first jug
    static int jug2; //size of second jug
    //we want 1 + 2 = 3
    static int jug3; //size of thrid jug
    static boolean[][] visited;
    static String[] stack;
    static int index;
    
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter A: ");
        jug1 = kb.nextInt();
        System.out.println("Enter B: ");
        jug2 = kb.nextInt();
        System.out.println("Enter C: ");
        jug3 = kb.nextInt();
        initilize();
        kb.close();
        boolean dfsCheck = dfs(0,0);
        if (dfsCheck == true)
        {
            System.out.println("Yay! Found a solution.");
            //if we find solutioon go trhough and pop it all off
            for (int i = index; i > 0; i--)
            {
               System.out.println(pop()); 
            }
        }
        else 
        {
            System.out.println("Impossible!");
        }
        
    }
    
    /**
     * initilizes our arrays 1000 is our max so thats how big our arrays should be
     */
    public static void initilize()
    {
        
        visited = new boolean[1000][1000];
        stack = new String[1000];
        index = 0;
    }
    
    //if either are true then we keep going
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
    
    /**
     * our depth first search where we will proform the 3 things you can do with jugs
     * 1: fill a jug 
     * 2: move water from jugs until one is empty or the other is full
     * 3: empty a jug
     * 
     * we want to get EXACTLY the goal between the 2
     * 
     * calls all ops and fills out the visited array until we get a + b  = c 
     * 
     * @param a
     * @param b
     * @return
     */
    public static boolean dfs(int a, int b)
    {
        //case 1 we got the answer returns true so we can get printing
        if (a + b == getGoal())
        {
            return true;
        }
        
        //if weve been here before get out
        if (visited[a][b] == true)
        {
            return false;
        }
        
        //otherwise indicate were here
        else
        {
            visited[a][b] = true;
        }
        
        boolean cont = false;
        
        //fill a
        cont = check(cont, dfs(jug1, b));
        if (cont == true)
        {
            push("Fill Jug 1 [ a = " + jug1 + ", b = " + b + "] ");
            return true;
        }
        
        
        //fill b
        cont = check(cont, dfs(a, jug2));
        if (cont == true)
        {
            push("Fill Jug 2 [ a = " + a + ", b = " + jug2 + "] ");
            return true;
        }
        
        
        //poar a -> b
        int jugA = a;
        int jugB = b;
        
        while(jugA > 0 && jugB < jug2)
        {
            jugA--;
            jugB++;
        }
        cont = check(cont, dfs(jugA, jugB));
        if (cont == true)
        {
            push("Pour Jug 1 -> Jug 2 [ a = " + jugA + ", b = " + jugB + "] ");
            return true;
        }
        
        
        // poar b -> a
        while(jugA < jug1 && jugB > 0)
        {
            jugA++;
            jugB--;
        }
        cont = check(cont, dfs(jugA, jugB));
        if (cont == true)
        {
            push("Pour Jug 2 -> Jug 1 [ a = " + jugA + ", b = " + jugB + "] ");
            return true;
        }
        
        //empty a
        cont = check(cont, dfs(0, b));
        if (cont == true)
        {
            push("Empty Jug 1 [ a = " + 0 + ", b = " + b + "] ");
            return true;
        }
        
        //empty b
        cont = check(cont, dfs(a, 0));
        if (cont == true)
        {
            push("Empty Jug 2 [ a = " + a + ", b = " + 0 + "] ");
            return true;
        }
        return cont;
        
    }
    
    
    //returns what we want to find
    public static int getGoal()
    {
        return jug3;
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
