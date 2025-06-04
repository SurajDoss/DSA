package Heaps;

public class MaxHeap {
    public static void heapify( int[] array ){
        var lastParent = ((array.length / 2) - 1);
        for(var i = lastParent; i >= 0; i--){
            heapify(array, i);
        }
    }

    private static void heapify( int[] array, int index){
        var largerIndex = index;

        var leftIndex = index * 2 + 1;

        if( leftIndex < array.length && array[leftIndex] > array[largerIndex]  ){
            largerIndex = leftIndex;
        }

        var rightIndex = index * 2 +2;

        if( rightIndex < array.length && array[rightIndex] > array[largerIndex] ){
            largerIndex = rightIndex;
        }


        if(index == largerIndex){
            return;
        }
        swap(array, index, largerIndex);
        heapify(array, largerIndex);
    }

    private static void swap(int[] arrays, int first, int second){
        var temp = arrays[first];
        arrays[first] = arrays[second];
        arrays[second] =temp;
    }
}
