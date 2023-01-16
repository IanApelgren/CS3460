import java.math.BigInteger;
import java.util.Scanner;
public class Binom
{
    public static BigInteger[][] holder;
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        int a = kb.nextInt();
        int b = kb.nextInt();
        initilize();
        kb.close();
        if(a <= 1000 && a >= b)
        {
            BigInteger n = new BigInteger(Integer.toString(a));
            BigInteger k = new BigInteger(Integer.toString(b));
            System.out.println("B("+ n + ", " + k + ") = " + B(n,k));
        }
        else
        {
            System.out.println("please make sure n is bigger than k and less than 1000");
        }
    }
    public static void initilize()
    {
        holder = new BigInteger[1001][1000];
    }
    public static BigInteger B(BigInteger n,BigInteger k)
    {
        //B(n,0) = B(n,n) = 1
        if(k.compareTo(BigInteger.ZERO) == 0 ||  k.compareTo(n) == 0)
        {
            return BigInteger.ONE;
        }
        //B(n,k) = (B(n-1,k-1) + B(n-1,k)
        else
        {
            if (holder[n.intValue()][k.intValue()] == null)
            {
                BigInteger placer = new BigInteger("0");
                placer = B(n.subtract(BigInteger.ONE), k.subtract(BigInteger.ONE)).add(B(n.subtract(BigInteger.ONE),k));
                holder[n.intValue()][k.intValue()] = placer;
                return placer;
            }
            else
            {
                return holder[n.intValue()][k.intValue()];   
            }
        }
        
        
    }
}
