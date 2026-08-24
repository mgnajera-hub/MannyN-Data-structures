import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This program demonstrates the LinkedList class
 * and ListIterator class.
*/
public class ListDemo
{
    public static void main(String[] args)
    {
        //The addLast method can be used to populate a list
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Steve");
        staff.addLast("Wanda");
        staff.addLast("Dr.Strange");

        System.out.println(staff);
    }
}
