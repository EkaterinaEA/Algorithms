package Sorts;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] items = new int[10];

        for (int i=0; i<items.length; i++){
            items[i] = (int) (Math.random()*10);
        }

        System.out.println("Array before sort: " + Arrays.toString(items));
        sort(items);
        System.out.println("Array after sort: " + Arrays.toString(items));

    }

    public static void sort(int[] items){
        for (int i = 0; i< items.length - 1; i++){
            int min = i;
            for (int j = i+1; j < items.length; j++){
                if (items[j] < items[min]){
                    min = j;
                }
            }
            if (min != i){
                int temp = items[min];
                items[min] = items[i];
                items[i] = temp;
            }
        }
    }
}
