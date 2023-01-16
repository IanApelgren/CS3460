
public class PriorityQueue {
	private Interval [] heap; // An array that encodes a max-heap data structure.
	private int size;	// The size of allocated buffer for the heap.
	private int numElements;	// The number of elements currently stored. 

	/**
		Constructor: s is the initial size of the heap.
	*/
	public PriorityQueue(int s) 
	{
		size = s;
		heap = new Interval[size + 1];	// 1 extra element allows us to use 1-based indexing. The max heap stores intervals keyed on their lengths.
		numElements = 1;
	}

	/**
		Inserts a new Interval k into the heap. Automatically expands the heap if the buffer allocated is full.
	TODO: Please complete this method.
	*/
	public void insert(Interval k) 
	{
		if (numElements == size) 
		{
			// Expand the buffer allocated for the heap to another buffer that is twice as big.
		    size = (this.size * 2) +1;
		    Interval[] newHeap = new Interval[size];
		    for (int i = 1; i < numElements; i++)
		    {
		        newHeap[i] = heap[i];
		    }
		    heap = newHeap;
		    
		}
		// Insert without buffer expansion here.
		//increment numelements so now its where k should go then shift it up
		
		heap[numElements] = k;
		siftUp(numElements);
		numElements++;
	}

	/**
		Returns the maximum Interval from the heap (usually the one with the largest length. See the compareTo function of Interval for more details on the comparison.
	TODO: Please complete this method.
	*/
	public Interval remove_max() {
		if (numElements == 1) return null; // Retuns null if heap is empty.
		// Remove_max code here.
		Interval maxStore = heap[1];//as long as we sift up this should ALWAYS be the largest element
		numElements--;//simulating removal
		heap[1] = heap[numElements];
		heap[numElements] = maxStore;
		
		siftDown(1);
		
		return maxStore; // Replace this statement with returning the max element (root) in the heap.
	}

	/**
		This function prints the contents of the array that encodes a heap.
	*/
	public void print() {
		System.out.println("Printing heap:");
		for (int i = 1; i < numElements; ++i)
			System.out.println(heap[i]);
	}
	/**
	 * Sift down is responcible for switching the given interval with its children while it doesnt satisfy the heap property
	 * at position i
	 */
	public void siftDown(int i)
	{
	    double right = getRight(i);
	    double left = getLeft(i);
	    double smallest;
	    boolean hasRight = true;
	    boolean hasLeft = true;
	    //checking if we have right and left
	    if (right > numElements)
	    {
	        hasRight = false;
	    }
	    if (left > numElements)
	    {
	        hasLeft = false;
	    }
	    //if we have both
	    if (hasRight == true && hasLeft == true)
	    {
	        //find the smallest between left and right
	        if(heap[(int) left].compareTo(heap[(int) right]) < 0)
	        {
	            smallest = left;
	            
	        }
	        else 
	        {
	            smallest = right;
	           
	        }
	        //if the smallest leaf is bigger than the current swap
	        if (heap[i].compareTo(heap[(int) smallest]) < 0)
	        {
	            Interval swap = heap[i];
                heap[i] = heap[(int) smallest];
                heap[(int) smallest] = swap;
                siftDown((int) smallest);
	        }
	    }
	    //if we only have right
	    else if(hasRight == true)
	    {
	        //if i - right less than 0 then rights bigger and should switch
	        if (heap[i].compareTo(heap[(int) right]) < 0)
	        {
	            Interval swap = heap[i];
	            heap[i] = heap[(int) right];
	            heap[(int) right] = swap;
	            siftDown((int) right);
	        }
	    }
	    //if we only have left
	    else if(hasLeft == true)
	    {
	        if (heap[i].compareTo(heap[(int) left]) < 0)
            {
                Interval swap = heap[i];
                heap[i] = heap[(int) left];
                heap[(int) left] = swap;
                siftDown((int) left);
            }
	    }
	    //if none are true
	    else 
	    {
	        return;
	    }
	}
	
	/**
     * Sift up is responcible for switching the given interval with its parent while it doesnt satisfy the heap property
     * at position i
     */
	public void siftUp(int i)
	{
	    double parent = getParent(i);
	    //if were at the top of the "tree" get out
	    if (parent <= 0)
	    {
	        return;
	    }
	    //otherwose we keep going up and replacing if the parent is smaller
	    else
	    {
	        if (heap[i].compareTo(heap[(int) parent]) > 0)
	        {
	            Interval swap = heap[i];
                heap[i] = heap[(int) parent];
                heap[(int) parent] = swap;
                siftUp((int) parent);
	        }
	    }
	    
	}
	/**
	 * simple math for getting the parent node
	 * @param i
	 * @return where the parrent will be
	 */
	public double getParent(int i)
	{
	    if(i == 1)
	    {
	        return 1;
	    }
	    double parent = i/2;
        return parent;
	    
	}
	/**
	 * getting the right child
	 * @param i
	 * @return where the right node will be
	 */
	public double getRight(int i)
	{
	    double right  = i*2 + 1;    
	    return right;
	   
       
	    
	}
	/**
	 * getting the left child
	 * @param i index of the node
	 * @return where the left node will be
	 */
	public double getLeft(int i)
	{
	    double left = i *2;
	    return left;
	    
	    
	}
}
