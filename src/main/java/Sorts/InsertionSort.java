package Sorts;

import java.util.Arrays;

public class InsertionSort {

    public static void main(String[] args) {
        int[] items = new int[10];

        for (int i=0; i<items.length; i++){
            items[i] = (int) (Math.random()*10);
        }

        System.out.println("Array before sort: " + Arrays.toString(items));
        sort(items);
        System.out.println("Array after sort: " + Arrays.toString(items));

    }

    static void sort(int[] array){
        for (int i = 1; i < array.length; ++i){
            int key = array[i];
            int j = i - 1;

            while (j>=0 && array[j] > key){
                array[j+1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
}
