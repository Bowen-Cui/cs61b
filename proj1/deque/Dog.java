package deque;

import java.util.Comparator;

public class Dog implements Comparable<Dog> {
    private String name;
    private int size;

    public Dog(String name, int size) {
        this.name = name;
        this.size = size;
    }

    public String getName() {
        return name;
    }
    public int getSize() {
        return size;
    }

    public int compareTo(Dog o) {
        return this.size - o.size;
    }

    private static class NameComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.name.compareTo(o2.name);
        }
    }

    private static class SizeComparator implements Comparator<Dog> {

        @Override
        public int compare(Dog o1, Dog o2) {
            return o1.size - o2.size;
        }
    }

    public static Comparator getNameComparator() {
        return new NameComparator();
    }
    public static Comparator getSizeComparator() {
        return new SizeComparator();
    }
}
