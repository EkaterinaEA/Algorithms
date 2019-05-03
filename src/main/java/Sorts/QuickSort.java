package Sorts;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] array = new int[10];

        for (int i=0; i<array.length; i++){
            array[i] = (int) (Math.random()*10);
        }

        System.out.println("Array before sort: " + Arrays.toString(array));
        quickSort(array, 0, array.length-1);
        System.out.println("Array after sort: " + Arrays.toString(array));
    }


    public static void quickSort(int[] array, int leftBorder, int rightBorder){

        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker)/2];

        do {

            // Move the left marker from left to right until the element is smaller than the pivot
            while (array[leftMarker] < pivot){
                leftMarker++;
            }

            // Move the right marker while the element is larger than the pivot
            while (array[rightMarker] > pivot){
                rightMarker--;
            }

            // If L is before the pointer R
            if (leftMarker <= rightMarker){
                // and the element L is less than the element R
                if (leftMarker < rightMarker){
                    // then swap
                    int temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                // Move markers to get new borders
                leftMarker++;
                rightMarker--;
            }
            //when L is behind the right marker R, then the exchange is completed
        } while (leftMarker <= rightMarker);

        // Recursively for parts:

        // from the beginning of the sorted area to the right marker.
        if (leftMarker < rightBorder){
            quickSort(array, leftMarker, rightBorder);
        }

        //from the left marker to the end of the sorted area
        if (leftBorder < rightMarker){
            quickSort(array, leftBorder, rightMarker);
        }

    }
}
