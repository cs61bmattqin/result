public class ArrayDeque<myType> {
    private myType[] items;
    private int size;

    public ArrayDeque(){
        items = (myType[]) new Object[8];
        size = 0;
    }

    private void resize(int capacity){
        myType[] a = (myType[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public void addFirst(myType x){
        if (size == items.length){
            resize(size * 2);
        }
        myType[] a = (myType[]) new Object[items.length];
        a[0] = x;
        System.arraycopy(items, 0, a, 1, size);
        items = a;
        size += 1;
    }

    public void addLast(myType x){
        if (size == items.length){
            resize(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    public boolean isEmpty(){
        if (size == 0){
            return true;
        }
        return false;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        int length = size;
        for (int i = 0; i < length; i++){
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }

    public myType removeFirst(){
        if (size == 0){
            return null;
        }
        myType result = items[0];
        System.arraycopy(items, 1, items, 0, size - 1);
        size -= 1;
        return result;
    }

    public myType removeLast(){
        if (size == 0){
            return null;
        }
        myType result = items[size - 1];
        items[size - 1] = null;
        size -= 1;
        return result;
    }

    public myType get(int index){
        if (index > size - 1){
            return null;
        }
        return items[index];
    }
}
