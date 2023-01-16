/*
 * This class maintains a set of ints. 
 */
public class IntSet {    
    
    private int size = 0;       // The number of elements currently stored in the set.
    //the start tail is empty for now
    private Node head;
    private Node current;
    private Node back;
    
    
    public IntSet() {
        size = 0;
        head = null;
        
    }
    
    /* Find if a key is present in the set. Returns true if the key is present, otehrwise false.*/
    public boolean find(int key) {
        Node finderNode = head;
        while (finderNode.getLink() != null)
        {
            if (finderNode.getData() == key) return true; 
            finderNode = finderNode.getLink();
        }
        return false;
    }
    
    /* Insert a key into the set. */
    //this is also responcible for the sorting
    public void insert(int key) {
        // Make sure that the key is not present.
        assert (!find(key));
        //if the size of the list is 0 then just make the head hold it
        Node newNode = new Node(key, null);
        if (size == 0)
        {
            
            head = newNode;
        }
        else if (size == 1)
        {
            if (key < head.getData())
            {
                Node temp = head;
                newNode.setLink(temp);
                head = newNode;
            }
            else 
            {
                head.setLink(newNode);
            }
        }
        else if (head.getData() > key)
        {
            Node temp = head;
            newNode.setLink(temp);
            head = newNode;
        }
        
            
   
        else
        {
            back = head;
            current = back.getLink();
            for (int i = 0; i < size; i++)
            {
                //if it goes through everything and newNode hasnt found a home it puts it at the back
                if (current.getLink() == null && newNode.getLink() == null)
                {
                    current.setLink(newNode); 
                }
                //if the key fits in between the two then put it there
                else if (back.getData() < key && current.getData() > key)
                {
                    newNode.setLink(current);
                    back.setLink(newNode); 
                }
               
                back = current;
                current = current.getLink();
            }
            
            
            
        }
        
        size += 1; 
       
        
           
    }
    
    /* Remove a key from the set. */
    public void remove(int key) {
        // Make sure that the key is present.
        assert (find(key));
        back = head;
        if (back.getLink() != null)
        {
            current = back.getLink();
        }
        else if(head.getData() == key)
        {
            head = head.getLink();
        }
        
        else
        {
            for(int i = 0; i < size; i++)
            {
                if (current.getData() == key)
                {
                    back.setLink(current.getLink());
                }
                back = current;
                current = current.getLink();
            
            }
        }
        size -=1;
        
    }
    
    /* Print the contents of the set in sorted order. */
    public void print() {
        current = head;
        for (int i = 0; i < size; i++)
        {
            System.out.print(current.getData() + " ");
            current = current.getLink();
        }
        System.out.println();
    }
}

