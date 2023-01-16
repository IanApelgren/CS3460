/*
 * Ian Apelgren 
 * HW 3 for CS 3460 you are given hash functions and must map them all to the same index
 */
import java.lang.Integer;

public class Prog {

	public static void main(String [] args) {
		
	    if (args.length != 2) {
            System.out.println("Please execute: java Prog <n> <p>");
            System.out.println("n is the input size, and p is the program number.");
            System.exit(0);
        }

        int n = Integer.parseInt(args[0]);
        int p = Integer.parseInt(args[1]);

		switch(p) {
			case 1: prog1(n);
							break;
			case 2: prog2(n);
							break;
			case 3: prog3(n);
							break;
			case 4: prog4(n);
							break;
			default: System.out.println("Invalid program number. Only 1-4.");
		}
	}

	private static void prog1(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash1.	
	    HashFunctions hash = new HashFunctions(n);
	    for (int i = 0; i < n; i++)
	    {
	        System.out.println(hash.hash1(i));
	    }
	}

	private static void prog2(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash2.	
	    HashFunctions hash = new HashFunctions(n);
	    int counter = 0;//this is how many times hash 4 had to be called to get out
	    int num = 0;// this is the desired number 0 to n
	    while (counter < n)
        {
	        if(hash.hash2(num) == hash.hash2(n))
	        {
	            System.out.println(num-n);
	            counter++;
	        }
	        num++;
        }
	    
	}

	private static void prog3(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash3.	
	    HashFunctions hash = new HashFunctions(n);
	    int counter = 0;//this is how many times hash 4 had to be called to get out
        int num = 0;// this is the desired number 0 to n
        while (counter < n)
        {
            if(hash.hash3(num) == hash.hash3(n))
            {
                System.out.println(num);
                //System.out.println(counter);
                counter++;
            }
            num++;
        }
	}

	private static void prog4(int n) {
		// TODO: Code to generate n keys that all get hashed to the same index using hash4.	
	    
	    
	    HashFunctions hash = new HashFunctions(n);
	    
	    int counter = 0; //this is how many times hash 4 had to be called to get out
	    int num = 0;// this is the desired number 0 to n
	    
	    while (num != n)
        {
	        if (hash.hash4(counter) == hash.hash4(n))
	        {
	            System.out.println(counter);
	            //System.out.println(num);
	            num++;
	            
	        }
	        counter++;
	        
        }
	    
	    
	}
}
