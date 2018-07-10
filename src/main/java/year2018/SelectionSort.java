package year2018;

/**
 * 选择排序
 * 选择排序和冒泡排序的区别:
 * 冒泡排序每次循环会把最大或最小值放到最边上
 * 而选择排序是找到最小值然后和比较的那个交换位置
 * @package year2018
 * @Author: kun.li
 * @Date: 2018/7/10
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {3, 4,2, 45, 65, 33, 12,15};
        System.out.println("交换之前：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        //选择排序的优化
        for (int i = 0; i < arr.length - 1; i++) {// 做第i趟排序
            int k = i;
            for (int j = k + 1; j < arr.length; j++) {// 选最小的记录
                if (arr[j] < arr[k]) {
                    k = j; //记下目前找到的最小值所在的位置
                }
            }
            //在内层循环结束，也就是找到本轮循环的最小的数以后，再进行交换
            if (i != k) {  //交换a[i]和a[k]
                int temp = arr[i];
                arr[i] = arr[k];
                arr[k] = temp;
            }
        }
        System.out.println();
        System.out.println("交换后：");
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }

}
