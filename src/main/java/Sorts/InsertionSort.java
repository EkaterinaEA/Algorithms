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

    public static void sort(int[] items){
        int sortedRangeEndIndex = 1;
        while (sortedRangeEndIndex < items.length){
            if (items[sortedRangeEndIndex - 1] > items[sortedRangeEndIndex]){
                int insertIndex = findInsertionIndex(items, items[sortedRangeEndIndex]);
                insert(items, insertIndex, sortedRangeEndIndex);
            }
            sortedRangeEndIndex++;
        }
    }

    private static int findInsertionIndex(int[] items, int valueToInsert){
        for (int i = 0; i < items.length; i++){
            if (items[i] > items[valueToInsert]){
                return i;
            }
        }
        return 0;
    }

    private static void insert(int[] items, int indexInsertingAt, int indexInsertingFrom){
        int temp = items[indexInsertingAt];
        items[indexInsertingAt] = items[indexInsertingFrom];

        for (int i = indexInsertingFrom; i > indexInsertingAt; i--){
            items[i] = items[i-1];
        }
        items[indexInsertingAt+1] = temp;
    }
}
