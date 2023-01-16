
public class Node
{
    public String data;
    public String type;
    public Node prev;
    public Node A;
    public Node B;
    public Node C;
    
    //default constructor for creating the start
    public Node()
    {
        data = (String) null;
        type = (String) null;
        prev = null;
        A = null;
        B = null;
        C = null;
    }
    //normal constructor takes data and link
    public Node(String data, Node link)
    {
        this.data = data;
        this.prev = link;
    }
    //sets link of the node
    public void setPrev(Node newLink)
    {
        prev = newLink;
    }
    
    public void setA(Node newA)
    {
        A = newA;
        A.setType("A");
        
    }
    
    public void setB(Node newB)
    {
        B = newB;
        B.setType("B");
    }
    
    public void setC(Node newC)
    {
        C = newC;
        C.setType("C");
    }
    //sets data of the node
    public void setData(String newData)
    {
        data = newData;
    }
    //returns the link to next node or null
    public Node getPrev()
    {
        return prev;
    }
    
    public Node getA()
    {
        return A;
    }
    
    public Node getB()
    {
        return B;
    }
    
    public Node getC()
    {
        return C;
    }
    //returns the data in that node
    public String getData()
    {
        return data;
    }
    public boolean hasPrev()
    {
        if (prev == null)
        {
            return false;
        }
        else
        {
            return true;
        }
              
    }
    public String getType()
    {
        return type;
    }
    public void setType(String T)
    {
        type = T;
    }
}
