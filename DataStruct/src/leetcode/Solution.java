package leetcode;

import java.util.Arrays;

/**
 * Created by gavin on 2017/12/27.
 */
public class Solution {

    public static int nums[] ={0, 1, 0, 3, 12};

    public static void main(String[] args) {




        moveZeroes(nums);



        System.out.println("nums = [" +  Arrays.toString(nums) + "]");

    }


    /****
     * 给定一个数组nums，写一个函数，将数组内的0移动到数组末尾，并保持其他非零元素在原数组中的相对位置不变。
       比如，给定nums = [0, 1, 0, 3, 12]，调用你的函数之后，nums应该变成[1, 3, 12, 0, 0]。
       注意：
       请直接在传入的数组对象上修改，而不是另外创建一份拷贝（术语叫做 in-place，也有中译为“原地”）。
        尽量减少操作指令代码的行数。
     * @param nums
     */
    public static void moveZeroes(int[] nums) {


        if(nums.length < 2) return;
        int k = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[k++] = nums[i];
            }
        }
        for(;k < nums.length; k++)
            nums[k] = 0;

       /* int fast=0,slow=0;
        int length=nums.length;

        while (fast<length){

            if (nums[fast]!=0){

                nums[slow]=nums[fast];

                slow++;
            }

            fast++;
        }

        for (int i=slow;i<length;i++){

            nums[i]=0;
        }*/
    }
}
