package SubtypePolymorphism;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog("aaa", 5);
        Dog d2 = new Dog("bbb", 10);
        Dog d3 = new Dog("ccc", 15);
        Dog[] dogs = new Dog[]{d1,d2,d3};
        Dog d = (Dog) Maximizer.max(dogs);
        d.speak();

        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(3);
        int largest = Collections.max(arr);
        System.out.println(largest);
    }


}
