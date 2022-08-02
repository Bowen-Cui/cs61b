public class EvenOddList {


    public int first;
    public EvenOddList rest;
    public EvenOddList(int f, EvenOddList r){
            this.first = f;
            this.rest = r;
        }

    public static void evenOdd(EvenOddList lst){
            if(lst==null || lst.rest==null || lst.rest.rest==null){
                return;
            }
            EvenOddList odd = new EvenOddList(lst.rest.first,null);
            lst.rest = lst.rest.rest;
            EvenOddList temp=lst.rest;//lst的指针---可以省去
            EvenOddList oddRest = odd;//odd的指针

            while(temp.rest!=null) {
                oddRest.rest=new EvenOddList(temp.rest.first,null);
                if(temp.rest.rest==null){
                    temp.rest.rest=odd;
                    break;
                }
                temp.rest=temp.rest.rest;
                temp=temp.rest;
                oddRest=oddRest.rest;
            }
            temp.rest=odd;
        }

        /**更优解*/
    /**
     * 不用把奇数位一个一个复制（odd），只要把偶偶相连，奇奇相连，变动指针即可
     * 最后把偶list末尾和奇list头相连
     * 以下解法中，偶list末尾为lst，奇list头地址保存在second
     * 值得注意的是，lst地址一直在向后移动，相当于temp，但因为是传参，不会影响原lst的地址。原lst通过改变其变量rest来更改其内容。
     */
    public static void evenOdd2(EvenOddList lst) {
         if (lst == null || lst.rest == null) {
             return;
             }
        EvenOddList oddList = lst.rest;
        EvenOddList second = lst.rest;
         while (lst.rest != null && oddList.rest != null) {
             lst.rest = lst.rest.rest;
             oddList.rest = oddList.rest.rest;
             lst = lst.rest;
             oddList = oddList.rest;
             }
         lst.rest = second;
         }


    public static void main(String[] args) {
        EvenOddList lst = new EvenOddList(0,null);
        lst.rest = new EvenOddList(1,null);
        lst.rest.rest = new EvenOddList(2,null);
        lst.rest.rest.rest = new EvenOddList(3, null);
        lst.rest.rest.rest.rest = new EvenOddList(4, null);
        lst.rest.rest.rest.rest.rest = new EvenOddList(5, null);

        evenOdd2(lst);
        EvenOddList temp=lst;
        while(temp!=null){
            System.out.print(temp.first+" ");
            temp=temp.rest;
        }
    }
}
