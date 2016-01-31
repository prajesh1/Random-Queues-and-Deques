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
    Node temp = head;
    node.next = head;
    head.previous = node;
    head = temp;
  }
  public void addLast(Item item)           // add the item to the end
  {
    if(item==null)
      throw new  java.lang.NullPointerException();
    Node node = new Node();
    node.item = item;
    Node temp = tail;
    tail.next = node;
    node.previous = tail;
    tail = temp;    
  }
  public Item removeFirst()                // remove and return the item from the front
  {
    if(isEmpty())
      throw new java.util.NoSuchElementException();
    Item first = head.item;
    head.next.previous = null;
    head = head.next;
    return first;
  }
  public Item removeLast()                 // remove and return the item from the end
  {
    if(isEmpty())
      throw new java.util.NoSuchElementException();
    Item last = tail.item;
    tail.previous.next = null;
    tail = tail.previous;
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
      if(item!=null&&item.next!=null)
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
    
  }
}