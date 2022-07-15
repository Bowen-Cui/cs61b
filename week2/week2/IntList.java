public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r){
        first=f;
        rest=r;
    }

    /**
     *return the size of the list using recursion!! better solution
     */
    public int size(){
        //int size=0;
        if(rest==null){
            return 1;
        }
        return 1+this.rest.size();
    }

    /**
     *return the size of the list using iteration!!
     */
    public int iterativeSize(){
        int size=0;
        IntList p=this;
        while(p!=null){
            p=p.rest;
            size+=1;
        }
        return size;
    }

    public void add(int n){
        this.rest=new IntList(this.first,this.rest);
        this.first=n;
        //this.rest=new IntList(n,this.rest);
    }
    /**
     *return the ith item of this List
     */

    public int get(int i){
        if(i==0){
            return this.first;
        }
        return this.rest.get(i-1);
    }
    public int iterativeGet(int i){
        int n=0;
        IntList p=this;
        if(i>=this.size()){
            System.out.println("不存在");
        }
        while(n<i){
            p=p.rest;
            n+=1;
        }
        return p.first;
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. */
    /**!!!创建指针变量 a pointer variable "temp" and have it iterates through the list to the end*/
    public static IntList incrList(IntList L, int x) {
        IntList temp = L;
        while (temp != null) {
            temp.first += x;
            temp = temp.rest;
        }
        return L;
        /*if(L==null){
            return null;
        }
        IntList Q=null;
        for(int i=L.size()-1; i>=0; i--){
            Q= new IntList(L.get(i)+x,Q);
        }
        return Q;*/

        /*IntList Q=new IntList(L.first+x,null);
        Q.rest=incrList(L.rest,x);
        return L */
    }

    /** Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed to use
     * the 'new' keyword. */
    public static IntList dincrList(IntList L, int x) {
        /* Your code here. */
        if(L==null){
           return null;
        }
        L.first+=x;
        dincrList(L.rest, x);
        return L;
    }
    /**Modify the Intlist class so that every time you add a value you “square” the IntList.
     For example, upon the insertion of 5, the below IntList would transform from:
     1 => 2 to 1 => 1 => 2 => 4 => 5
     and if 7 was added to the latter IntList, it would become
     1 => 1 => 1 => 1 => 2 => 4 => 4 => 16 => 5 => 25 => 7
     Additionally, you are provided the constraint that you can only access the
     size() function one time during the entire process of adding a node.
     */
    public void squareAdd(int x){
        if(this==null){
            return;
        }
        IntList temp=this;
        while(temp!=null){
            temp.rest=new IntList(temp.first*temp.first,temp.rest);
            if(temp.rest.rest==null){
                temp.rest.rest=new IntList(x,null);
                return;
            }
            temp=temp.rest.rest;
        }
    }

    public void printList(){
        /*for(int i=0; i<this.size(); i++){
            System.out.print(this.get(i)+" ");
        }*/
        System.out.print(this.first+" ");
        if(this.rest!=null){
            this.rest.printList();
        }
    }

    public static void main(String[] args) {
        IntList L=new IntList(20, null);
        //L= new IntList(10, L);
       // L= new IntList(5, L);
        L.add(15);
        L.add(10);
        L.add(5);
        L.printList();
        System.out.println();
        L.squareAdd(100);
        L.printList();
        System.out.println();

        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        System.out.println(L.iterativeGet(2));
        System.out.println(L.get(0));

        IntList S=new IntList(5, null);
        S.rest=new IntList(10,null);
        S.rest.rest= new IntList(15, null);
        S.printList();
        System.out.println();

        incrList(L,2).printList();
        System.out.println();
        dincrList(S,3).printList();

    }



}
