package Sorts;

import java.util.Arrays;

public class ShellSort {

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

        int h = 1;
        while(h*3 < array.length){
            h = h*3 + 1;
        }

        while(h >= 1){
            hSort(array, h);
            h = h/3;
        }
    }

    private static void hSort(int[] array, int h){
        for(int i = h; i < array.length; i++){
            for (int j = i; j >= h; j = j -h){
                if (array[j] < array[j-h]){
                    int temp = array[j];
                    array[j] = array[j-h];
                    array[j-h] = temp;
                } else break;
            }
        }
    }
}

