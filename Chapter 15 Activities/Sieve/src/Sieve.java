import java.util.Scanner;
import java.util.*;

/**
 * A program that implements the sieve of Eratosthenes.
*/
public class Sieve
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Compute primes up to which integer?");
        int n = in.nextInt();
        double x = (double)n;

        // Your work goes here
        //. . .

        Set<Integer> numSet = new HashSet<Integer>();
        //Iterator<Integer> iter = numSet.iterator();


        //add all possible numbers in a set
        for(int i = 2; i<n; i++)
        {
            numSet.add(i);
        }


       // remove multiples of numbers as it goes through all possible numbers
        for(int i = 2; i < Math.sqrt(x); i++)
        {
            if(numSet.contains(i))
            {
                for(int s = 2*i; s < n; s += i)
                {
                    numSet.remove(s);
                }
            }
        }

        System.out.println(numSet);




    }
}
