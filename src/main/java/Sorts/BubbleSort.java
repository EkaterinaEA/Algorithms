package Sorts;

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {

        int[] array = new int[10];

        for (int i=0; i<array.length; i++){
            array[i] = (int) (Math.random()*10);
        }

        System.out.println("Array before sort: " + Arrays.toString(array));
        sort(array);
        System.out.println("Array after sort: " + Arrays.toString(array));
    }

    public static void sort(int[] array){
        boolean isSorted = false;
        while (!isSorted){
            isSorted = true;
            for (int i = 0; i < array.length-1; i++){
                if (array[i] > array[i+1]){
                    isSorted = false;
                    swap(array, i, i+1);
                }
            }
        }
    }

    public static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
