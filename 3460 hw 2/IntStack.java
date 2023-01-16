public class IntStack {
	// May create private data here.
    private int arr[];
    private int head;
    private int counter;

	public IntStack() {
		// TODO: Code to initialize your stack.
	    arr = new int[100];
	    head = -1;
	    counter = 0;
	    
	}

	public void push(int x) {
		// TODO: Code to push an item x onto the stack. The stack wlil never contain more than 100 elements.
	    arr[++head] = x;
	    counter++;
	    
	}

	public int pop() {
		// TODO: Code to pop and retrun an item from the top of the stack. If the stack is empty, return -1.
	    int x;
	    
	    if(counter == 0)
	    {
	        x = -1;
	    }
	    else
	    {
	        x = arr[--head];
	        counter--;
	    }
	    return x;
	    
	}
	public int getCounter()
	{
	    return counter;
	}
}
