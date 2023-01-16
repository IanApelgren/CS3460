
public class Node
{
    public int data;
    public Node link;
    
    //default constructor for creating the start
    public Node()
    {
        data = (Integer) null;
        link = null;
    }
    //normal constructor takes data and link
    public Node(int data, Node link)
    {
        this.data = data;
        this.link = link;
    }
    //sets link of the node
    public void setLink(Node newLink)
    {
        link = newLink;
    }
    //sets data of the node
    public void setData(int newData)
    {
        data = newData;
    }
    //returns the link to next node or null
    public Node getLink()
    {
        return link;
    }
    //returns the data in that node
    public int getData()
    {
        return data;
    }
    
}
