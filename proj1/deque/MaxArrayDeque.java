package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T> {

    Comparator c;
    public MaxArrayDeque(Comparator<T> c){
        super();
        this.c = c;
    }

    public T max(){
        int size = super.size();
        if(size == 0){
            return null;
        }
        T max = super.get(0);
        for(int i=1; i<size; i++){
           if(c.compare(super.get(i),max)>0){
               max = super.get(i);
           }
        }
        return max;
    }

    public T max(Comparator<T> cc){
        int size = super.size();
        if(size == 0){
            return null;
        }
        T max =super.get(0);
        for(int i=1; i<size; i++){
            if(cc.compare(super.get(i),max)>0){
                max = super.get(i);
            }
        }
        return max;
    }

}
