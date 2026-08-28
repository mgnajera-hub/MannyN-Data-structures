import java.util.LinkedList;
import java.util.ListIterator;

/**
 * This class supplies a utility method to reverse the entries in a linked list.
*/
public class ListUtil
{
    /**
     * Reverses the elements in a linked list
     *
     * @param strings the linked list to reverse
    */
    public static void reverse(LinkedList<String> strings)
    {
        int size = strings.size();
        ListIterator<String> iter = strings.listIterator();
        String temp;
        String[] names = new String[size];

        for (int i = 0; i < size; i++)
        {
            temp = iter.next();
            iter.remove();
            names[size-i-1] = temp;
        }

        for (int i = 0; i < size; i++)
        {
            strings.add(names[i]);
        }

    }
}