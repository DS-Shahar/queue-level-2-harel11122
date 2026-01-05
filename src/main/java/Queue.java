public class QueueAlgorithms {

    public static Queue<Integer> sequenceLengths(Queue<Character> q) {
        Queue<Integer> result = new Queue<>();
        if (q.isEmpty()) return result;

        char prev = q.remove();
        int count = 1;

        while (!q.isEmpty()) {
            char curr = q.remove();
            if (curr == prev) {
                count++;
            } else {
                result.insert(count);
                count = 1;
                prev = curr;
            }
        }
        result.insert(count);
        return result;
    }
    // Time: O(n) , Space: O(n)

    public static boolean hasDuplicates(Queue<String> q) {
        Queue<String> aux = new Queue<>();

        while (!q.isEmpty()) {
            String s = q.remove();
            if (isIn(s, aux)) return true;
            aux.insert(s);
        }
        return false;
    }
    // Time: O(n^2) , Space: O(n)

    public static void removeDuplicates(Queue<Integer> q) {
        Queue<Integer> aux = new Queue<>();

        while (!q.isEmpty()) {
            int x = q.remove();
            if (!isIn(x, aux)) {
                aux.insert(x);
            }
        }

        while (!aux.isEmpty()) {
            q.insert(aux.remove());
        }
    }
    // Time: O(n^2) , Space: O(n)

    public static void sortQueue(Queue<Integer> q) {
        Queue<Integer> sorted = new Queue<>();
        Queue<Integer> aux = new Queue<>();

        while (!q.isEmpty()) {
            int min = q.remove();
            aux.insert(min);

            while (!q.isEmpty()) {
                int x = q.remove();
                if (x < min) {
                    aux.insert(min);
                    min = x;
                } else {
                    aux.insert(x);
                }
            }

            sorted.insert(min);

            while (!aux.isEmpty()) {
                q.insert(aux.remove());
            }
        }

        while (!sorted.isEmpty()) {
            q.insert(sorted.remove());
        }
    }
    // Time: O(n^2) , Space: O(n)
}
public static int longestEvenSequenceSum(Queue<Integer> q){
    int maxLen = 0, maxSum = 0;
    int currentLen = 0, currentSum = 0;
    int size = q.size();

    for(int i = 0; i < size; i++){
        int x = q.remove();
        q.add(x);

        if(x % 2 == 0){
            currentLen++;
            currentSum += x;
            if(currentLen > maxLen){
                maxLen = currentLen;
                maxSum = currentSum;
            }
        } else {
            currentLen = 0;
            currentSum = 0;
        }
    }
    return maxSum;
}
// סיבוכיות זמן ריצה: O(n)
import java.util.*;
public class Main {	
	
	static Scanner reader=new Scanner(System.in);
	public static void main(String[] args) {
	    
		Queue<Integer> q = new Queue<Integer>();
		q.insert(7);
		q.insert(8787);
		q.insert(11);
		q.insert(5);
		System.out.println(sort(q));
	}
	
	/////////////////////////////////////////////

	public static Queue<Integer> ex(Queue<Integer> q) {
	    Queue<Integer> h = new Queue<Integer>();
	    Queue<Integer> p = new Queue<Integer>();
	     while (!q.isEmpty())
	     {
	         p.insert(q.head());
	         h.insert(q.remove());
	     }
	     while (!p.isEmpty())
	     {
	         q.insert(p.remove());
	     }
	     return h;
	}
	
	public static int max(Queue<Integer> p) 
	{
	    Queue<Integer> q = ex(p);
	    int max = q.remove();
	    int current;
	    while (!q.isEmpty())
	    {
	        current = q.remove();
	        
	        if (current>max)
	            max = current;
	    }
	    return max;
    }
    
    public static int dig(int num) 
    {
	    int digit = 0;
	    while (num!=0)
	    {
	        digit++;
	        num = num/10;
	    }
	    return digit;
    }
    
    public static int loc(int num,int x) 
    {
        if (dig(num)<x)
            return 0;
            
        int digit = 0;
            
	    while (x!=-1)
	    {
	        x--;
	        digit = num%10;
	        num = num/10;
	    }
	    return digit;
    }
    
    public static Queue<Integer> sort(Queue<Integer> q) 
    {
        Queue<Integer>[]a = new Queue [10];
        for (int i = 0; i< 10; i++){
            a[i] = new Queue<Integer>();
        }
            
        int x = dig(max(q));
        int num;
        
        for (int i = 0; i< x;i++)
        {
            while (!q.isEmpty())
	        {
	            num = q.remove();
	            a[loc(num,i)].insert(num);
	        }
	        
	        for (int j = 0; j< 10;j++)
            {
                while (!a[j].isEmpty())
	            {
	                q.insert(a[j].remove());
	            }
            }
        }
            
        return q;    
        
    }
	

	
