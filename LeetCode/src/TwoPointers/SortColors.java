package TwoPointers;

import java.util.Arrays;

public class SortColors {
    public static void sortColors(int[] nums) {
        //[2,0,2,1,1,0]
        int putRed = 0;
        int putBlue = nums.length - 1;
        for (int i = 0; i <= putBlue; i++) {
            if (nums[i] == 0) {
                swap(nums, i, putRed);
                putRed++;
            }
            if (nums[i] == 2) {
                swap(nums, i, putBlue);
                putBlue--;
                if (nums[i] != 1) --i;
            }
        }
    }

    public static void sortColors2(int[] nums) {
        int len = nums.length;
        // 0,0,1,1,2,2
        //  2 , 0 , 1
        //left,i ,right
        //[0,left)==0  [left,i)==1  (right,len-1]==2
        int left = 0;
        int i = 0;
        int right = len-1;
        while (left < right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                left++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {//nums[i] == 2
                swap(nums, i, right);
                right--;
            }
        }
    }


    private static void swap(int[] nums, int i, int put) {
        int temp = nums[put];
        nums[put] = nums[i];
        nums[i] = temp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,2,0,1,0};
        int[] nums2 = new int[]{2,1};
        sortColors2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
