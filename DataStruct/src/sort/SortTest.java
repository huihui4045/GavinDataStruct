package sort;

/**
 * Created by gavin on 2018/1/29.
 */
public class SortTest {

    public static void main(String[] args) {


        int [] array={1,8,2,11,4,6,3,9};

        //displayArray(array);

       // bubbleSort(array);

       // selectSort(array);

        //displayArray(array);

        fun(2);
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

    private static void displayArray(int[] array) {
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
}
