package day1124;

import java.util.Arrays;

public class LearnThree {
    public static void main(String[] args) {
        int[] arr = {1,3,23,5,34,12,2};
        boom(arr);
    }
    static void boom(int[] arr){

        for (int i=0;i<arr.length-1;i++){
            for (int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
