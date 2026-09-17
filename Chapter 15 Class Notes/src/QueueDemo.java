import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * This program simulates a print queue. Note that documents are printed
 * in the same order as they are submitted.
*/
public class QueueDemo
{
    public static void main(String[] args)
    {
        // Create a print queue of strings (using a linked list)
        Queue<String> jobs = new LinkedList<>();
        // Add some print jobs
        jobs.add("Jason: Quarter 2 Expense Report");
        jobs.add("Evan: Recipe for Banana Bread");
        jobs.add("Emily: Top Secret Document");

        //Removes first in first out
        System.out.println("Printing: " + jobs.remove()); //Prints Jason's quarter report

        jobs.add("Noah: Grocery List");
        jobs.add("Emily: Really Top Secret Document");
        jobs.add("Emily: Can I Get Fired for This?");

        System.out.println("Printing: " + jobs.remove()); //Prints Evan's recipe
        System.out.println("Printing: " + jobs.remove()); //Prints out Emily's top secret document

        jobs.add("Boss: Emily's Termination Letter");

        while (!(jobs.isEmpty()))
        {
            System.out.println("Printing: " + jobs.remove());
        }





        // Create a to-do list
        //THe workOrder class has an int priority and a string description
        Queue<WorkOrder> toDo = new PriorityQueue<>();


        toDo.add(new WorkOrder(3,"Water plants"));
        toDo.add(new WorkOrder(2,"Eat dinner"));
        toDo.add(new WorkOrder(1,"Conquer world"));
        toDo.add(new WorkOrder(9,"Play Videogames"));

        //Objects are NOT stored in priority order
        System.out.println(toDo);

        //Objects will be removed in priority order
        while(toDo.size()>0)
        {
            System.out.println(toDo.remove());
        }
    }
}
