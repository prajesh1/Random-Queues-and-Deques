public class Subset {
   public static void main(String[] args){
     RandomizedQueue<String> rq = new RandomizedQueue<String>();
     int k = Integer.parseInt(args[0]);
     for(int i=1;i<args.length;i++)
       rq.enqueue(args[i]);
     for(int i=0;i<k;i++)
       System.out.println(rq.dequeue());
   }
}