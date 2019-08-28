import java.util.Arrays;

public class Practice {
    //插入排序 需要循环 (n - 1)次  第一个数是有序的哦
    //有序数组：[0,i];
    //无序数组：[i + 1,array.length)
    //选出i+1 下表的元素和之前有序数组比较，找到需要插入的下表
    //然后移动有序数组，插入需要插入的数字
    public static void insertSort(int[] array){
        for(int i = 0;i < array.length - 1;i ++){
            int key = array[i + 1];
            int j;
            for(j = i;j >= 0;j -- ){
                if(array[j] <=  key){
                    break;
                }
            }
            //移动过程
            for(int k = i;k > j;k --){
                array[k + 1] = array[k];
            }
            array[j + 1] = key;
        }
    }
    //思路：
    //首先判断需要判断 n-1 次
    //找到第一个无序区间的元素需要插入的下表
    //进行插入操作
    public static void insertSort2(int[] array){
        //有序区间：[0,i]
        //无序区间：[i + 1,array.length)
        for(int i = 0;i < array.length - 1;i ++){
            int key = array[i + 1];
            //找到要插入的下表，并且插入
            int j;
            for(j = i;j >= 0 && key < array[j];j --){
                array[j + 1] = array[j];
            }
            array[j + 1] = key;
        }
    }


    private static void insertSortShell(int[] array,int gap){
        for(int i = 0;i < array.length - gap;i ++){
            int key = array[i + gap];
            int j;
            for(j = i;j >= 0 && key < array[j];j = j - gap){
                array[j + gap] = array[j];
            }
            array[j + gap] = key;
        }
    }
    //希尔排序
    //思想：每隔gap个的元素进行插入排序，知道 gap = 1（也需进行）
    public static void shellSort(int[] array){
        int gap = array.length;
        while(true) {
            gap = gap / 3 + 1;
            insertSortShell(array,gap);
            if(gap == 1){
                break;
            }
        }
    }


    //直接排序：
    //思路：首先需要进行 n - 1 次比较
    //有序区间：[array.length - i,array.length)
    //无序区间：[0,array.length)
    //找出无序区间的最大数 与 无序区间 最后一个数字进行交换
    public static void selectSort(int[] array){
        for(int i = 0;i < array.length - 1;i ++){
            //找出无序区间最大的数，和无序区间最后一个交换
            int max = 0;
            for(int j = 0;j < array.length - i;j ++){
                if(array[j] > array[max]){
                    max = j;
                }
                swap(array,max,array.length - i - 1);
            }
        }
    }

    //堆排序
    public static void heapSort(int[] array){
        creatHeap(array,array.length);
        for(int i = 0; i < array.length - 1;i ++){
            swap(array,0,array.length - i - 1);
            heapity(array,array.length - i - 1,0);
        }
    }

    private static void heapity(int[] array, int size, int index) {
        while(true) {
            int left = index * 2 + 1;
            if (left >= size) {
                return;
            }
            int max = left;
            if (left + 1 < size && array[left + 1] > array[left]) {
                max = left + 1;
            }
            if (array[max] > array[index]) {
                swap(array, max, index);
            }
            index = max;
        }
    }

    private static void creatHeap(int[] array,int size) {
        int parent = (size - 2) / 2;
        for(int i = parent;i >= 0;i --){
            heapity(array,size,i);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void main(String[] args) {
        int[] array = new int[]{9,8,7,6,5,4,3,2};
//        insertSort(array);
//        shellSort(array);
//        System.out.println(Arrays.toString(array));
//        insertSort(array);
//        System.out.println(Arrays.toString(array));
//        selectSort(array);
//        System.out.println(Arrays.toString(array));
        long b = System.nanoTime();
        heapSort(array);
        long e = System.nanoTime();
        System.out.println(e - b);
        System.out.println(Arrays.toString(array));

    }

}
