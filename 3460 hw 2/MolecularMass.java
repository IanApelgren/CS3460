import java.util.Scanner;

public class MolecularMass
{

    public IntStack massStack;
    MolecularMass()
    {
        IntStack massStack = new IntStack();
        Scanner kb = new Scanner(System.in);  // Create a Scanner object
        System.out.println("Enter Composition");
        String input = kb.nextLine();
        int p = Calc(input);
        System.out.println("Molecular mass = " + p);
        kb.close();
       
        

    }
    
    public int findNum(char l)
    {
        int ret;
        if( l == 'C' || l == 'c')
        {
            ret = 12;
        }
        else if(l == 'O' || l == 'o')
        {
            ret = 16;
        }
        else if( l == 'H' || l == 'h')
        {
            ret = 1;
        }
        else if (l == '(')
        {
            ret = -2;
        }
        else if (l == ')' )
        {
            ret = 0;
        }
        else 
        {
            ret = (l - '0');    
        }
        return ret;
        
    }
    
    public int Calc(String m)
    {
        int total = 0;
        int x;
        int mult;
        int temp;
        int pTotal;
        for(int i = 0; i < m.length(); i++ )
        {
          x = findNum(m.charAt(i));
          // we found a ')'
          if (x == 0)
          {
              pTotal = 0;
              while(x != -2)
              {
                  x = massStack.pop();
                  pTotal += x;
              }
              //making up for the negative 2
              pTotal += 2;
              massStack.push(pTotal);
          }
          // we have a num so multiply
          else if (x >= 2 && x <= 9)
          {
              mult = x;
              temp = massStack.pop();
              temp = temp * mult;
              massStack.push(temp);
          }
          else
          {
              massStack.push(x);
          }
        }
        for(int j = 0; j < massStack.getCounter(); j++)
        {
            total += massStack.pop();
                
        }
        return total;
    }

}
