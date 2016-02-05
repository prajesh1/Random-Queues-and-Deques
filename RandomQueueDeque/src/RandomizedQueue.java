import java.util.Iterator;
import java.util.Random;


public class RandomizedQueue<Item> implements Iterable<Item> {
  private Item[] randomQueue;
  private int size = 0; //item inserted at size
  private Random random;
   public RandomizedQueue()                 // construct an empty randomized queue
   {
     random = new Random();
   }
   public boolean isEmpty()                 // is the queue empty?
   {
     if(size==0)
       return true;
     else return false;
   }
   public int size()                        // return the number of items on the queue
   {
     return this.size;
   }
   public void enqueue(Item item)           // add the item
   {
     if(size==0)
       randomQueue = (Item[])new Object[2];
     if(size+1==randomQueue.length)
       resizingArray(randomQueue.length*2);
     randomQueue[size++]=item;
   }
   private void resizingArray(int newSize)
   {
     Item[] tempQueue = (Item[])new Object[newSize];
     for(int i =0;i<size;i++)
       tempQueue[i] = randomQueue[i];
     randomQueue = tempQueue;
   }
   public Item dequeue()                    // remove and return a random item
   {
	   if(size()==0)
		   throw new java.util.NoSuchElementException();
     swap(random.nextInt(size),size-1);
     Item temp = randomQueue[size-1];
     randomQueue[size-1] = null; //to avoid loitering
     size = size -1;
     if(size<randomQueue.length/4)
       resizingArray(randomQueue.length/2);
     return temp;
   }
   private void swap(int i,int j)
   {
     Item temp = randomQueue[i];
     randomQueue[i] = randomQueue[j];
     randomQueue[j] = temp;
   }
   public Item sample()                     // return (but do not remove) a random item
   {
	   if(size()==0)
		   throw new java.util.NoSuchElementException();
     return randomQueue[random.nextInt(size)];
   }
   public Iterator<Item> iterator()         // return an independent iterator over items in random order
   {
     return new ListRandomQueue();
   }
   private class ListRandomQueue implements  Iterator<Item>
   {
     private int pointer=0;
     public ListRandomQueue()
     {
       for(int i=size-1;i>=0;i--) //Knuths shuffling algorithm
       {
         swap(i,random.nextInt(i+1));
       }
     }
    @Override
    public boolean hasNext()
    {
      if(pointer<=size-1&&size>0)
        return true;
      else
      return false;
    }

    @Override
    public Item next()
    {
    	if(pointer==size)
    		throw new java.util.NoSuchElementException();
      return randomQueue[pointer++];        
    }

    @Override
    public void remove()
    {
      throw new java.lang.UnsupportedOperationException();      
    }
     
   }
   public static void main(String[] args)   // unit testing
   {
	   RandomizedQueue<Integer> xx = new RandomizedQueue<Integer>();
	   for(Integer i =0;i<50;i++)
	   xx.enqueue(i);
	   for(Integer i =0;i<50;i++)
		   xx.dequeue();
	   xx.size();
   }
}