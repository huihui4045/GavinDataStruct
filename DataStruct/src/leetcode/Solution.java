package leetcode;

import java.util.Arrays;

/**
 * Created by gavin on 2017/12/27.
 */
public class Solution {

    public static int nums[] ={0,0, 1, 0, 3, 3,12};

    public static void main(String[] args) {




        //moveZeroes(nums);


        int k = removeElement(0, nums);

       // int k=removeDuplicates(nums);


        System.out.println("数组长度 = [" + k + "]");
        System.out.println("nums = [" +  Arrays.toString(nums) + "]");

    }

    /***
     * 数组03 - 从有序数组中删除重复元素 - 简单 - 26
       给定一个有序数组，原地删除重复元素使得数组中的元素只保留一个，并且返回新长度。
       禁止申请额外空间，确保空间复杂度为O(1)。
     * @param a
     * @return
     */
    public static int removeDuplicates(int [] a){


        Arrays.sort(a);

        int index=0;

        for (int i=1;i<a.length;i++){

            if (a[index]!=a[i]){

                a[++index]=a[i];
            }
        }

        int k=index+1;

        for (;k<a.length;k++){

            a[k]=0;
        }


        return index+1;

    }


    /****
     * 给定一个数组和一个值，原地移除数组中所有给定的值，并返回新数组的长度。
       不允许申请额外空间，确保空间复杂度为O(1)。
       数组中的元素可以被改变，不用考虑超出新长度之后的空间遗留。
       比如：
       给定nums = [3, 2, ,2 3]， val = 3，
       你的函数应该返回length = 2， nums = [2, 2]。
     * @param data
     * @param array
     */
    public static int  removeElement(int data,int [] array){


        int length=array.length;

        int i,k;

        for (i=0,k=0;i<length;i++){

            if (array[i]==data)
                continue;
                array[k++]=array[i];
        }

        int j=k;

        for(;j < nums.length; j++)
            nums[j] = 0;

        return  k;

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
