import java.util.NoSuchElementException;

/**
 * A linked list is a sequence of nodes with efficient
 * element insertion and removal. This class
 * contains a subset of the methods of the standard
 * java.util.LinkedList class.
*/
public class LinkedList
{

    // first refers to the head (first Node)
    //If the list is empty, first will be null
    private Node first;

    /**
        Constructs an empty linked list.
    */

        public LinkedList()
        {
            this.first = null;
        }

        



    /**
        Returns the first element in the linked list.
        @return the first element in the linked list
    */




    /**
        Removes the first element in the linked list.
        @return the removed element
    */
        public Object removeFirst()
        {
            if (this.first == null)
            {
                throw new NoSuchElementException();
            }

            Object element = this.first.data;
            this.first = this.first.next; //just change the first node, in essence removing it
            return element;
        }




    /**
        Adds an element to the front of the linked list.
        @param element the element to add
    */
        public void addFirst(Object element)
        {
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = first;
            this.first = newNode; //don't have to put this.first

        }




    /**
        Returns an iterator for iterating through this list.
        @return an iterator for iterating through this list
    */





    //Class Node
    // Node is static because it does NOT need to access anything in LinkedList
    // The Node object will store information, not interact
    static class Node 
    {
        public Object data;
        public Node next;


    }


    class LinkedListIterator implements ListIterator
    {
      //private data
        private Node position;
        private Node previous;
        private boolean isAfterNext;

        /**
            Constructs an iterator that points to the front
            of the linked list.
        */

            public LinkedListIterator()
            {
                this.position = null;
                this.previous = null;
                this.isAfterNext = null;
            }


        /**
            Moves the iterator past the next element.
            @return the traversed element
        */

            public Object next()
            {
                if (!hasNext())
                {
                    throw new NoSuchElementException();
                }


                if (position == null)
                {
                    position = first; //have access to 'first' because this class is inside the other class
                }
                else{

                    previous = position;
                    position = position.next; //sets to the node 

                }


                isAfterNext = true;

                return position.data; //return the data

            }




        /**
            Tests if there is an element after the iterator position.
            @return true if there is an element after the iterator position
        */

            public boolean hasNext()
            {
                // Check if the list is empty if the iterator hasn't moved
                if (position == null)
                {
                    return first != null; //return false if list is empty
                }
                // The iterator has moved, so check the next node
                return position.next != null;
            }

        /**
            Adds an element before the iterator position
            and moves the iterator past the inserted element.
            @param element the element to add
        */
            public void add(Object element)
            {
                //Check if the iterator is at the beginning
                if (position == null)
                {
                    addFirst(element);
                    position = first;
                }

                else{
                    Node newNode = new Node();
                    newNode.data = element;
                    newNode.next = position.next;

                    //Set the next element of the CURRENT position to point to our new node
                    position.next = newNode; // next of the PREVIOUS node points to the node the method just made
                    position = newNode;
                }

                isAfterNext = false;
            }





        /**
            Removes the last traversed element. This method may
            only be called after a call to the next() method.
        */
            public void remove()
            {
                if(!isAfterNext)
                {
                    throw new IllegalStateException();
                }

                //Check if the iterator is at the beginning
                if (position == first)
                {
                    removeFirst();
                    position = null;
                }
                else{
                    previous.next = position.next; // effectively cuts off the element we want to remove
                    position = previous;
                }

                isAfterNext = false;
            }






        /**
            Sets the last traversed element to a different value.
            @param element the element to set
        */




    }//LinkedListIterator
}//LinkedList
