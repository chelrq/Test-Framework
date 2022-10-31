package test;

import java.util.ArrayList;


class MinPriorityQueue
{
    ArrayList<PriQueueNode> items;

    /**
     * Creates an empty priority queue
     */
    public MinPriorityQueue()
    {
       items = new ArrayList<PriQueueNode>();
    }
 
    /**
     * @return the item with the minimum priority
     */
    public Object peek()
    {
       return items.get(0).data;
    }
    
    /**
     * Removes and returns the item with the minimum priority
     * @return the item associated with the minimum priority
     */
    public Object dequeue()
    {
        if((items.size()-1) == 0){
            PriQueueNode a = items.remove(0);
            return a.data;
        }
        PriQueueNode current = items.get(items.size()-1);
        items.remove(items.size()-1);
        Object item = items.get(0).data;
        items.set(0, current);
        bubbleDown(0);
        return item; // In order to compile.  Please remove.
    }

    /**
     * Moves an item at the given index down the tree
     * As long as at least one of it's children is smaller
     * or we reach a leaf position.
     * @param idx the index of the item to move
     */
    protected void bubbleDown(int idx)
    {
       int leftChild = 2 * idx +1;
       int rightChild = 2 * idx +2;
       if(leftChild < items.size()-1){
            int smallChild = leftChild;
            if(items.get(rightChild) != null && items.get(rightChild).priority < items.get(leftChild).priority){
                smallChild = rightChild;
            }
            if(items.get(idx).priority > items.get(smallChild).priority){
                PriQueueNode smaller = items.get(smallChild);
                PriQueueNode curr = items.get(idx);
                items.set(smallChild, curr);
                items.set(idx, smaller);
            }
            bubbleDown(smallChild);
       }
    }
     
    /**
     * Inserts an item into the queue with the given priority
     * @param item the item to insert
     * @param priority the item's priority value
     */
    public void enqueue(Object val, double priority)
    {
        //The last thing in the list, is the last thing in the bottom layer
        PriQueueNode newItem = new PriQueueNode(val,priority);
        items.add(newItem);
        bubbleUp(items.size() - 1);
    }
 
    /**
     * Moves the item at the given index "up" the "tree" until its parent is smaller
     * @param idx the index of the item to move
     */
    protected void bubbleUp(int idx)
    {
        int parentIDX = (idx-1)/2; //if idx == 0, parent == 0, so priorities are the same!
        double parentPriority = items.get(parentIDX).priority;
        double currentPriority = items.get(idx).priority;
        if(currentPriority < parentPriority) {
            
            //Swap items
            PriQueueNode parent = items.get(parentIDX);
            PriQueueNode current = items.get(idx);
            items.set(parentIDX, current);
            items.set(idx, parent);
 
            bubbleUp(parentIDX); // Recursive implementation
        }
    }
 
    /**
     * @return a string representation of the heap
     */
    public String toString()
    {
        return items.toString();
    }
}

class PriQueueNode{

    public Object data;
    public double priority;

    public PriQueueNode(Object newVal,double pri){
        priority = pri;
        data = newVal;
    }

    public String toString(){
        return "(" + data + " {pri: " + priority + "})";
    }
}
