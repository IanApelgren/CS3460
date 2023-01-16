import java.util.Scanner;

public class AreaUnderACurve {

	/**
		The function f(x) = x^2 + x + 1.
	*/
	private static double f(double x) {
		return x * x + x + 1; 
	}

	/**
		Returns an approximation for the area under the curve f(x) between x = a and x = b.
	*/
	private static double computeArea(double a, double b) {
		double error = 1e-08; // This is the comparison error. See document for description.

		// TODO: Please compute an approximation for the area under the curve here.
		//make new priority queue
		PriorityQueue queue = new PriorityQueue(100);
		//make an interval with the given dimentions
		Interval inter = new Interval(a,b);
	
		
		
		queue.insert(inter);
		
		//initally we only have the big area
		double area = (b - a) * f(b);
		//double start = inter.getStart();
		//double end = inter.getEnd();
		//double mid = (start + end)/f(2);
		
		double split = (a+b)/2; //the midpoint we split at
		
		double splitArea = area - ((b - a) * f(b)) + ((split - a)*f(split)) + ((b -  split) * f(b));
		
		//if difference is less return area
		if (Math.abs(splitArea - area) <= error)
		{
		    return area;
		}
		//otherwise keep working
		else
		{
		    //put in splits
		    Interval aSplit = new Interval(a, split);
		    Interval bSplit = new Interval(split, b);
		    queue.insert(aSplit);
		    queue.insert(bSplit);
		    area = splitArea;
		    //while our new area is better we start looping
		    while(Math.abs(splitArea - area) > error)
		    {
		        //make new area the current
		        //area = splitArea;
		        //get the max off queue
		        Interval currentMax = queue.remove_max();
		        //names make copying the formula easier
		        double b2 = currentMax.getEnd();
		        double a2 = currentMax.getStart();
		        //our new midpoint
		        split = (a2+b2)/2;
		        //our new new area
		        splitArea = area - ((b2 - a2) * f(b2)) + ((split - a2)*f(split)) + ((b2 -  split) * f(b2));
		        
		        //inserting them back into the stack
		        //we dont insert if conditions arent met
		        if(Math.abs(splitArea - area) > error)
		        {
		            Interval a2Split = new Interval(a2, split);
		            Interval b2Split = new Interval(split, b2);
		            queue.insert(a2Split);
		            queue.insert(b2Split);
		            area = splitArea;
		        }
		        
		        //replaceing area for next iteration
		        
		        
		       
		        
		        
		        
		    }
		}
		
		return area; // Remove this statement and return the computed area.
	}

	public static void main(String [] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("We have the function f(x) = x^2 + x + 1.");
		System.out.print("Please enter lower value a: ");
		double a = kb.nextDouble();
		System.out.print("Please enter upper value b: ");
		double b = kb.nextDouble();

		double area = computeArea(a, b);
		System.out.println("\nAn approximation for the area under the curve f(x) \nbetween a = " + a + " and b = " + b + " is " + area);
		kb.close();
	}
	
	public double newArea(double a)
	{
        return a;
	    
	}
}
