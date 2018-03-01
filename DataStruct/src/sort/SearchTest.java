package sort;

import org.junit.Test;

/**
 * Created by gavin on 2018/3/1.
 *
 * 查找
 */
public class SearchTest {


    @Test
    public void testbinarySearch(){

        int [] a={11,3,5,3,9,6,11,13,34,23};

        SortTest.quickSort(a,0,a.length-1);

       SortTest.displayArray(a);

        int index = binarySearch(a, 5,0,a.length-1);

        System.out.println("key: index="+index+" "+a[index]);
    }

    /****
     * 递归实现二分查找
     * @param a
     * @param key
     * @param fromIndex 下标
     * @param toIndex  下标
     * @return
     */
    public int  binarySearch(int [] a,int key,int fromIndex,int toIndex){

        int mid=(fromIndex+toIndex)>>>1;
        if (a[mid]==key) return mid;

        if (fromIndex<toIndex){

            if (key>a[mid]){

                return binarySearch(a,key,mid+1,toIndex);
            }else {

                return binarySearch(a,key,fromIndex,mid-1);
            }
        }


        return -1;
    }

    /****
     *  二分法查找法  分治法
     * @param a
     * @param key
     * @return
     */
    public int binarySearch(int [] a,int key){

        int low=0;
        int high=a.length-1;

        while (low<=high){

            int mid = (low + high) >>> 1;
            int minValue=a[mid];

            if (key>minValue){

                low=mid+1;
            }else if (key<minValue){

                high=mid-1;
            }else {

                return mid;
            }
        }


        return -1;
    }
}
