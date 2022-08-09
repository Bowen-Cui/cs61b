package SubtypePolymorphism;

import java.util.Collection;

public class Dog implements Comparable<Dog> {

      String name;
    private  int size;

    public Dog(String name, int size){
        this.size = size;
        this.name = name;
    }
    public void speak(){
        System.out.println(name+": bark!");
    }

    public static Dog maxDog(Dog[] dogs) {
        if (dogs == null || dogs.length == 0) {
            return null;
        }
        Dog maxDog = dogs[0];
        for (Dog d : dogs) {
            if (d.size > maxDog.size) {
                maxDog = d;
            }
        }
        return maxDog;
    }

    @Override
    public int compareTo(Dog o) {
       /* if(this.size > ((Dog)o).size){
            return 1;
        }else if(this.size < ((Dog)o).size){
            return -1;
        }
        return 0;*/
        return this.size - o.size;
    }
}
