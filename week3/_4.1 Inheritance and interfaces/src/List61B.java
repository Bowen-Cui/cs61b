public interface List61B<item> {

    /** Adds f to the front of the List*/
    public void addFirst(item f);
    /** Adds x to the end of the List*/
    public void addLast(item x);
    /** Returns the first letter in the list*/
    public item getFirst();
    /**delete the first item in the List*/
    public void deleteFirst();
    /**get the item at given index*/
    public item get(int index);
    /**Returns the size of the List*/
    public int size();
/**Implementation Inheritance*/
    default public void print() {
        for (int i = 0; i < size(); i += 1) {
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
