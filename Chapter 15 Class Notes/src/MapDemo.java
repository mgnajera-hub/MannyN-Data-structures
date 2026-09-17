import java.awt.Color;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

/**
    This program demonstrates a map that maps names to colors.
*/
public class MapDemo
{
    public static void main(String[] args)
    {
        /*
            Map interface is generic
         */
        Map<String, Color> favColors = new HashMap<>();

        //Add elements to the hashmap
        favColors.put("Manny",Color.YELLOW);
        favColors.put("Emily",Color.RED);
        favColors.put("Evan",Color.GREEN);




        //Two different elements that have the same value but different key
        favColors.put("Emily",Color.GREEN);
        //Duplicate keys will change the value of the original key
        favColors.put("Emily",Color.ORANGE);

        //Create a set of the keys in the map
        Set<String> keys = favColors.keySet();
        for (String key: keys)
        {
            // [name] ([hashCode] : [color])
            System.out.println("["+key+"]"+"(["+key.hashCode()+"] : ["+favColors.get(key)+"])");
        }
    }
}
