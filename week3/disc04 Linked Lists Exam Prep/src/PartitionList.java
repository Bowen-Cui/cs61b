public class PartitionList {

    private int first;
    private PartitionList rest;

    public PartitionList(int first, PartitionList partitionList) {
        this.first = first;
        this.rest = partitionList;
    }

    //5, 4, 3, 2, 1   [5,3,2] [4,1]
    public static PartitionList[] partition(PartitionList lst, int k) {
        PartitionList[] array = new PartitionList[k];
        int index = 0;
        PartitionList L = lst;
        while (L != null) {
            for (int i = 0; i < k; i++) {
                array[i] = new PartitionList(L.first, array[i]);
                L = L.rest;
                if(L==null) break;
            }
        }
        for (int i = 0; i<k; i++){
            array[i] = reverse(array[i]);
        }
        return array;
    }

    /**解法2
     *
     * public static IntList[] partition(IntList lst, int k) {
     *  IntList[] array = new IntList[k];
     *  int index = 0;
     *  IntList L = reverse(lst);  //先反过来，再从后向前写入，则最终顺序为正
     *  while (L != null) {
     *  IntList tempArray = array[index];
     *  array[index] = L;
     *  array[index].rest = tempArray;     //这三行在array[i]的first放入L的第一个数
     *  IntList next = L.rest;
     *  L = next;
     *  index = (index + 1) % k;  //这行让index在0，1，2...--0，1，2...--0，1，2...循环
     *  }
     *  return array;
     *  }
     */

    private static PartitionList reverse(PartitionList partitionList) {
        return partitionList;
    }

    public static void main(String[] args) {
            PartitionList lst = new PartitionList(5, null);
            lst.rest = new PartitionList(4,null);
            lst.rest.rest = new PartitionList(3,null);
            lst.rest.rest.rest = new PartitionList(2,null);
            lst.rest.rest.rest.rest = new PartitionList(1,null);

            PartitionList[] array = partition(lst, 2);


    }
}
