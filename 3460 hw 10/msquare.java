import java.util.Scanner;

public class msquare
{
    static String goal;
    static String magicSquare;
    
    
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        
         goal = kb.next();
        
        initilize();
        kb.close();
        Node start = new Node();
        start.setData(magicSquare);
        if (check(goal) == true)
        {
            StringBuilder outp = new StringBuilder();
            Node end = bfs(magicSquare, goal,start);
            int counter = 0;
            while(end.hasPrev() == true)
            {
               
                counter++;
                outp.append(end.getType());
                end = end.getPrev();
            }
            System.out.println(counter);
            System.out.println(outp.toString());
        }
        
        
        
    }
    
    /**
     * initilizes our arrays 1000 is our max so thats how big our arrays should be
     */
    public static void initilize()
    {
        magicSquare = "1 2 3 4 5 6 7 8";
    }
    
    //if either are true then we keep going
    public static boolean check(String square)
    {
       if (square.length() != 15)
       {
            return false;
       }
        
        else 
        {
            return true;
        }
        
    }
    
    
    public static Node bfs(String start, String finish, Node curr)
    {
        //case 1 we got the answer returns true so we can get printing
        if (start.equals(finish))
        {
            return curr;
        }
        
        
        //func A
        String ina = funcSel("A",start);
        Node Anode = new Node();
        Anode.setPrev(curr);
        curr.setA(Anode);
        Anode.setData(ina);
        Anode.setType("A");
        bfs(ina,finish, Anode);
        
        
        
        //func B
        String inb = funcSel("B",start);
        Node Bnode = new Node();
        Bnode.setPrev(curr);
        curr.setB(Bnode);
        Bnode.setData(inb);
        Bnode.setType("B");
        bfs(inb, finish,Bnode);
       
        
        //func C
        String inc = funcSel("C",start);
        Node Cnode = new Node();
        Cnode.setPrev(curr);
        curr.setC(Cnode);
        Cnode.setData(inc);
        Cnode.setType("C");
        bfs(inc, finish,Cnode);
        
        return curr;
        
        
    }
    
    

    public static String funcSel(String func, String square)
    {
        char num1 = square.charAt(0);
        char num2 = square.charAt(2);
        char num3 = square.charAt(4);
        char num4 = square.charAt(6);
        char num5 = square.charAt(8);
        char num6 = square.charAt(10);
        char num7 = square.charAt(12);
        char num8 = square.charAt(14);
        String ret = "";
        if (func.equals("A"))
        {
            ret = num8 + " " + num7 + " " + num6 + " " + num5 + " " + num4 + " " + num3 + " " + num2 + " " + num1;
        }
        if (func.equals("B"))
        {
            ret = num4 + " " + num1 + " " + num2 + " " + num3 + " " + num6 + " " + num7 + " " + num8 + " " + num5;
        }
        if (func.equals("C"))
        {
            ret = num1 + " " + num7 + " " + num2 + " " + num4 + " " + num5 + " " + num3 + " " + num6 + " " + num8;
        }
        return ret;
        
    }
    
 
    
    
}
