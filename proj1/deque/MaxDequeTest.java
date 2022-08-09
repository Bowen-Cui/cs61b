package deque;

import com.google.common.hash.HashingOutputStream;

import java.util.Comparator;

public class MaxDequeTest {
    public static void main(String[] args) {
        Dog a = new Dog("a", 4);
        Dog b = new Dog("b", 3);
        Dog c = new Dog("c", 2);
        Dog d = new Dog("d", 1);

        Comparator<Dog> nc = Dog.getNameComparator();
        System.out.println(nc.compare(a,b));

        MaxArrayDeque<Dog> mad = new MaxArrayDeque<>(Dog.getNameComparator());
        mad.addFirst(a);
        mad.addFirst(b);
        mad.addFirst(c);
        System.out.println(mad.max().getName());
        mad.addFirst(d);
        System.out.println(mad.max(Dog.getSizeComparator()).getName());

        MaxArrayDeque<Integer> mad2 = new MaxArrayDeque<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        mad2.addLast(1);
        mad2.addLast(2);
        mad2.addLast(5);
        mad2.addLast(3);
        System.out.println(mad2.max());

    }

}
