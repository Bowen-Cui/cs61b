public class WordUtils {

    /**
     * 用 interface List61B 实现同时兼容AList和SLList： longest(List61B<String> lst)
     */
    public static String longest(List61B<String> lst){
        if(lst.size() == 0){
            return null;
        }
        String longest = lst.get(0);
        int index = 1;
        while(index<lst.size()){
            if(lst.get(index).length()>longest.length()){
                longest = lst.get(index);
            }
            index += 1;
        }
        return longest;
    }

    public static void main(String[] args) {
        SLList<String> lst = new SLList<>();
        AList<String> lst2 = new AList<>();
        lst.addLast("a");
        lst.addLast("ab");
        lst.addLast("abcd");
        lst.addLast("aw");
        System.out.println(longest(lst));
        System.out.println(longest(lst2));
    }

}
