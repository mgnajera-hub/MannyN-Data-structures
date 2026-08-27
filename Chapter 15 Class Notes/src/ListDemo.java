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
        // The addLast method can be used to populate a list
        LinkedList<String> staff = new LinkedList<>();
        staff.addLast("Tony");
        staff.addLast("Steve");
        staff.addLast("Wanda");
        staff.addLast("Dr. Strange");

        System.out.println(staff);

        // The list is currently TSWD
        /*
            The listIterator method creates a new list iterator
            that is positioned at the head of the list.
            The | is used to represent the iterator position.
         */
        ListIterator<String> iterator= staff.listIterator(); // |TSWD

        /* The next method advanced the iterator over the next element in the list. */
        iterator.next(); // T|SWD

        /* The next method also returns the element the iterator passes over. */
        String avenger = iterator.next(); // TS|WD
        System.out.println(avenger); // Should print Steve
    
        /* The iterator add method inserts an element at the iterator position.
            The iterator is then positioned AFTER the element that was added.
        */
        iterator.add("Natasha"); // TSN|WD
        iterator.add("Bruce"); // TSNB|WD

        System.out.println(staff);

        /*
            The remove method removes the element returned by 
            the last call to next or previous.
            The remove method can ONLY be called after calling next or previous.
            The remove method CANNOT be called after calling add.
        */
        iterator.next(); // TSNBW|D
        iterator.remove(); // Wanda is removed -> TSNB|D

        System.out.println(staff);

        /* The set method updates the element returned by the last call
            to next or previous.
         */
        iterator.previous(); // TSN|BD
        iterator.set("T'Challa"); // TSN|TD

        System.out.println(staff);

        /* The hasNext method is used to determine if there is a next node
            after the iterator. The hasNext method is often used in the 
            condition of a while loop.
         */
        iterator = staff.listIterator(); // |TSNTD
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Natasha")) { // TSN|TD
                iterator.remove(); // TS|TD
            }
        } // TSTD|

        System.out.println(staff);

        /*  Enhanced for loops work with linked lists
            The enhanced for loop AUTOMATICALLY creates an iterator.
        */
        for (String n: staff) {
            System.out.print(n + " ");
        }

        /*
            ConcurrentModificationException

            CANNOT modify a linked list while using an iterator
            UNLESS you use the iterator to do the modification
        */
        iterator = staff.listIterator(); // |TSTD
        while (iterator.hasNext()) {
            String n = iterator.next();
            if (n.equals("Tony")) {
                // staff.remove("Tony"); ConcurrentModificationException
            }
        }

        for (String n: staff) {
            if (n.equals("Tony")) {
                staff.add("Peter");
            }
        }






    }
}