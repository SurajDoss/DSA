package Heaps;

public class Heap {
    private int[] items = new int[10];
    private int size;

    public void insert(int value){
        if( isFull() ){
            throw new IllegalStateException();
        }

        items[size++] = value;
        bubbleUp();
    }

    private boolean isFull(){
       return size == items.length;
    }

    private void bubbleUp() {
        var index = size-1;
        //bubbling up operations
        while( index > 0 &&  items[index] > items[ parent( index ) ] ){
            swap(index, parent( index ));
            index = parent( index );
        }
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private void swap( int first, int second ){
        var temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public void remove(){

    }
}
