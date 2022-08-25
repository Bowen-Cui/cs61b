package TwoPointers;

import java.util.Arrays;

//删除排序数组中的重复项
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        //0,1,2
        // 0,0,1,1,1,2,2,3,3,4
        int k = 0;
        for(int num : nums){
            if (num > nums[k]) {
                k++;
                nums[k] = num;
            }
        }
        return k + 1;
    }


    public static int removeDuplicates2(int[] nums) {
        int k = 0;
        for (int num : nums) {
            if ( k < 2 || num > nums[k - 2]) {
                nums[k] = num;
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        int[] nums2 = new int[]{1,2};
        System.out.println(removeDuplicates2(nums2));
        System.out.println(Arrays.toString(nums2));
    }

}
