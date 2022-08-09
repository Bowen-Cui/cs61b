package SubtypePolymorphism;

public class Maximizer {
    public static Comparable max(Comparable[] items){
        if(items==null || items.length==0){
            return null;
        }
        int maxi=0;
        for(int i=0; i<items.length; i++){
            if(items[i].compareTo(items[maxi])>0){
                maxi=i;
            }
        }
        return items[maxi];
    }
}
