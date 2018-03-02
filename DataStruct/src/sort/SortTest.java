package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by gavin on 2018/1/29.
 */
public class SortTest {

    public static void main(String[] args) {


        int [] array={7,9,1,8,2,11,4,6,3,9,0,13};

        //displayArray(array);

       // bubbleSort(array);

       // selectSort(array);

        //displayArray(array);

       // fun(2);

        quickSort(array,0,array.length-1);

        displayArray(array);
    }


    public static void fun(int n){

        System.out.println("n1 = [" + n + "]");

        if (n<0)

            return;

        else {

            fun(n-1);

            System.out.println("n = [" + n + "]");
        }

    }

    public static void displayArray(int[] array) {
        for (int i : array) {

            System.out.print(i+"  ");
        }

        System.out.println();
    }

    /****
     *  冒泡排序
     * @param array
     */
    public static void bubbleSort(int [] array){


        for (int i=0;i<array.length-1;i++){

            boolean  flag=true;

            for (int j=0;j<array.length-1-i;j++){

                if (array[j]>array[j+1]){

                    int temp=array[j+1];

                    array[j+1]=array[j];

                    array[j]=temp;

                    flag=false;

                }
            }

            if (flag){

                break;
            }
        }
    }


    /***
     * 选择排序
     * @param array
     */
    public static void selectSort(int [] array){

        int index=0;

        for (int i=0;i<array.length-1;i++){

            index=i;

            for (int j=i+1;j<array.length;j++){

                if (array[j]<array[index]){

                    index=j;
                }
            }

            if (index!=i){

                int temp=array[i];

                array[i]=array[index];

                array[index]=temp;
            }
        }

    }

    /****
     * 6  1  2   7   9  3  4  5  10   8
     * 快速排序
     * @param array
     * @param beginIndex
     * @param toIndex
     */
    public static void quickSort(int [] array,int beginIndex,int toIndex){

        if (beginIndex>toIndex)return;

        int i=beginIndex;
        int j=toIndex;

        int temp=array[beginIndex];//存储基准数

        while (i<j){


            //先从右边往左边找
            while (array[j]>=temp&&i<j)
                j--;

            //从左边往右找。
            while (array[i]<=temp&& i<j)
                i++;

            if (i<j){

                int t=array[i];
                array[i]=array[j];
                array[j]=t;
            }

        }

        //最终将基数归为
        array[beginIndex]=array[i];

        array[i]=temp;



        quickSort(array,beginIndex,i-1);

        quickSort(array,i+1,toIndex);

    }


    @Test
    public void testmergeSort(){
        int []arr = {9,8,7,6,5,4,3,2,1};

        int [] temp=new int[arr.length];

        mergeSort(arr,0,arr.length-1,temp);

        System.out.println(Arrays.toString(arr));

    }


    /****
     * 归并排序
     * @param arr
     * @param left
     * @param right
     * @param temp   在排序前，先建好一个长度等于原数组长度的临时数组，避免递归中频繁开辟空间
     */
    public static void mergeSort(int[] arr,int left,int right,int []temp){

        if (left<right){

            int mid=(left+right)>>>1;
            mergeSort(arr,left,mid,temp);//
            mergeSort(arr,mid+1,right,temp);//
            merge(arr,left,mid,right,temp);
        }

    }

    /***
     * 将两个有序子数组合并操作
     * @param arr
     * @param left
     * @param mid
     * @param right
     * @param temp
     */
    private static void merge(int[] arr,int left,int mid,int right,int[] temp){

        int i=left;//左序列指针

        int j=mid+1;//右序列指针


        int t=0;//临时数组指针

        while (i<=mid&&j<=right){

            if (arr[i]<=arr[j]){

                temp[t++]=arr[i++];
            }else {

                temp[t++]=arr[j++];
            }
        }

        while (i<=mid){//将左边剩余元素填充进temp中

            temp[t++]=arr[i++];
        }

        while (j<=right){//将右序列剩余元素填充进temp中

            temp[t++]=arr[j++];
        }

        t=0;

        //将temp中的元素全部拷贝到原数组中

        while (left<=right){

            arr[left++]=temp[t++];
        }


    }
}
