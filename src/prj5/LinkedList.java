package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.List;

/**
 * Implementation of a LinkedList
 * @author Callie Louderback (Calliel), Collin Miller (collinm2)
 * @version 2019.11.17
 * @param <E> The type of object that the class will store
 */
public class LinkedList<E> {
    
    /**
     * Size of the LinkedList
     */
    private int size;
    
    /**
     * Starting node of the LinkedList
     */
    private Node<E> head;
    
    /**
     * Creates a new LinkedList object
     */
    public LinkedList()
    {
        head = null;
        size = 0;
    }
    
    /**
     * Returns the size of the LinkedList
     * @return Size of the LinkedList
     */
    public int size()
    {
        return size;
    }
    
    /**
     * Adds a new Node to the LinkedList
     * @param element Element to be stored in the node
     * @return true if successful
     * @throws IllegalArgumentException if the element is null
     */
    public boolean add(E element)
    {
        if (element == null)
        {
            throw new IllegalArgumentException("Element is null");
        }
        Node<E> current = head;
        if (this.isEmpty())
        {
            head = new Node<E>(element);
        }
        else
        {
            while (current.next != null)
            {
                current = current.next;
            }
            current.setNext(new Node<E>(element));
        }
        size++;
        return true;
    }
    
    /**
     * Inserts element at specified index
     */
    public void add(int index, E element)
    {
        Node<E> newNode = new Node<E>(element);
        if (index < 0 || index > size)
        {
            throw new IndexOutOfBoundsException();
        }
        size++;
        
        if (index == 0)
        {
            newNode.next = head;
            head = newNode;
            return;
        }
        
        Node<E> place = head;
        for (int i = 0; i < index - 1; i++)
        {
            place = place.next;
        }

        if (index != size - 1)
        {
            newNode.next = place.next;
        }
        
        place.next = newNode;
    }
    
    /**
     * Determines if the LinkedList is empty or not
     * @return True if the LinkedList is empty, false otherwise
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    /**
     * Removes the node at the specified index
     * @param index Index to remove the node at
     * @return The removed node's data
     * @throws IndexOutOfBoundsException if the given
     * index is out of bounds
     */
    public E remove(int index)
    {
        if (index < 0 || head == null)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        else
        {
            Node<E> current = head;
            int currentIndex = 0;
            if (currentIndex == index)
            {
                E item = this.get(index);
                current.setNext(null);
                size--;
                return item;
            }
            while (current.next != null)
            {
                if ((currentIndex + 1) ==  index)
                {
                    E item = this.get(index);
                    Node<E> newNext = current.next.next;
                    current.setNext(newNext);
                    current.setNext(null);
                    size--;
                    return item;
                }
                current = current.next;
                currentIndex++;
            }
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
    }
    
    /**
     * Returns the node data at the specified index
     * @param index Index to retrieve the data at
     * @return The node's data\
     * @throws IndexOutOfBoundsException if the index
     * is out of bounds
     */
    public E get(int index)
    {
        Node<E> current = head;
        int currentIndex = 0;
        E data = null;
        while (current != null)
        {
            if (currentIndex == index)
            {
                data = current.data;
            }
            currentIndex++;
            current = current.next;
        }
        
        if (data == null)
        {
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }
        return data;
    }
    
    /**
     * Determines if the LinkedList contains the specified element
     * @param element Element to search for
     * @return True if the LinkedList contains the element
     * false otherwise
     */
    public boolean contains (E element)
    {
        Node<E> current = head;
        while (current != null)
        {
            if (element.equals(current.data))
            {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Clears the LinkedList
     */
    public void clear()
    {
        if (head != null)
        {
            head.setNext(null);
            head = null;
        }
        size = 0;
    }
    
    /**
     * Returns the last time the given element is in the LinkedList
     * @param element Element to search for
     * @return The last position of the element in the list. If it
     * is not in the list, -1
     */
    public int lastIndexOf(E element)
    {
        int lastIndex = -1;
        Node<E> current = head;
        int currentIndex = 0;
        while (current != null)
        {
            if (element.equals(current.data))
            {
                lastIndex = currentIndex;
            }
            currentIndex++;
            current = current.next;
        }
        return lastIndex;
    }
    
    /**
     * Returns a String representation of the LinkedList surrounded
     * by brackets and items separated by commas
     * @return a string representing the LinkedList
     */
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append('{');
        if (!this.isEmpty())
        {
            Node<E> current = head;
            while (current != null)
            {
                E element = current.getData();
                s.append(element.toString());
                if (current.next() != null)
                {
                    s.append(", ");
                }
                current = current.next;
            }
        }
        s.append('}');
        return s.toString();
        
    }
    
    /**
     * Represents a node stored in a LinkedList
     * @author Callie Louderback (Calliel)
     * @version 2019.11.17
     * @param <D> The type of object that the class will store
     */
    private class Node<D>
    {
        /**
         * Data element stored in the node
         */
        private E data;
        /**
         * Next node in the sequence
         */
        private Node<D> next;
        
        /**
         * Creates a new node with the given data
         * @param data Data to be stored in the node
         */
        @SuppressWarnings("unchecked")
        private Node(D data)
        {
            this.data = (E)data;
        }
        
        /**
         * Returns the data stored in the node
         * @return Data in the node
         */
        public E getData()
        {
            return data;
        }
        
        /**
         * Gets the next node
         * @return the next node
         */
        public Node<D> next()
        {
            return next;
        }
        
        /**
         * Sets the node after this node
         * @param n The node after this one 
         */
        public void setNext(Node<D> n)
        {
            next = n;
        }
        
    }
    
    /**
     * Creates an Iterator object
     * @return new Iterator Object
     */
    public Iterator<E> iterator()
    {
        return new LinkedListIterator<E>();
    }
    
    /**
     * Iterates through the linkedList
     * @author Callie Louderback (calliel)
     * @version 2019.11.17
     * @param <A> The type of object this class will store
     */
    private class LinkedListIterator<A> implements Iterator<E>
    {
        /**
         * The next node
         */
        private Node<E> nextNode;
        
        /**
         * Creates a new LinkedListIterator
         */
        public LinkedListIterator()
        {
            nextNode = head;
            size = LinkedList.this.size;
        }
        
        /**
         * Sees if the LinkedList has a next node
         * @return true if the nextNode is not null
         * false otherwise
         */
        public boolean hasNext()
        {
            return nextNode != null;
        }
        
        /**
         * Returns the next node's data
         * @return The next node's data
         */
        public E next()
        {
            if (!this.hasNext())
            {
                throw new NoSuchElementException("There is no next object");
            }
            Node<E> returnNode = nextNode;
            nextNode = nextNode.next;
            return returnNode.getData();
        }
        
        /**
         * Removes an object
         */
        public void remove()
        {
            throw new UnsupportedOperationException("Remove is not supported");
        }
    }

}
