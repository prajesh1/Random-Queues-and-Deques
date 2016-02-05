import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> 
{
  private Node head, tail;
  private int size;
  private class Node
  {
    Item item;
    Node next, previous;
  }
  public Deque()                           // construct an empty deque
  {
     
  }
  public boolean isEmpty()                 // is the deque empty?
  {
    if(head==null&&tail==null)
      return true;
    else
      return false;
  }
  public int size()                        // return the number of items on the deque
  {
    return this.size;
  }
  public void addFirst(Item item)          // add the item to the front
  {
    if(item==null)
      throw new  java.lang.NullPointerException();
    Node node = new Node();
    node.item = item;
    if(size()==0)
    {
    	head = node;
    	tail = node;
    }
    else
    {
    
    node.next = head;
    head.previous = node;
    head = node;
    }
    size = size + 1;
  }
  public void addLast(Item item)           // add the item to the end
  {
    if(item==null)
      throw new  java.lang.NullPointerException();
    Node node = new Node();
    node.item = item;
    if(size()==0)
    {
    	head = node;
    	tail = node;
    }
    else
    {    
    tail.next = node;
    node.previous = tail;
    tail = node;    
    }
    size = size + 1;
  }
  public Item removeFirst()                // remove and return the item from the front
  {
    if(isEmpty())
      throw new java.util.NoSuchElementException();
    Item first = head.item;
    if(head.next!=null)
    	{
    	head.next.previous = null;
    	head = head.next;
    	}
    else{head=tail=null;} //last item
    
    size = size -1;
    return first;
  }
  public Item removeLast()                 // remove and return the item from the end
  {
    if(isEmpty())
      throw new java.util.NoSuchElementException();
    Item last = tail.item;
    if(tail.previous!=null)
    	{
    	tail.previous.next = null;
    	tail = tail.previous;
    	}
    else{
    	head=tail=null;
    	}
    
    size = size -1;
    return last;
  }
  public Iterator<Item> iterator() // return an iterator over items in order from front to end
  {
    return new DequeIterator();
  }
  private class DequeIterator implements Iterator<Item>
  {
    Node item = head;
    public boolean hasNext()
    {
      if(item!=null)
        return true;
      else
        return false;
    }
    public Item next()
    {
      if(!hasNext())
        throw new java.util.NoSuchElementException();
      Item item = this.item.item;
      this.item = this.item.next;
      return item;
    }
    public void remove()
    {
      throw new java.lang.UnsupportedOperationException();
    }
  }
  public static void main(String[] args)   // unit testing
  {
    Deque<Integer> rq = new Deque<Integer>();
    for(Integer i=0;i<100;i++)
      rq.addFirst(i);
    System.out.println("hi");
    for(Integer s:rq)
    	System.out.print(s+" ");
    System.out.println("hi");
   for(int i=0;i<100;i++)
     System.out.print(rq.removeFirst()+" ");
  }
}