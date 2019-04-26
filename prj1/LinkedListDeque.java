public class LinkedListDeque<myType> {
    private IntNode sentinel;
    private int size;

    public class IntNode{
        public myType item;
        public IntNode prev;
        public IntNode next;

        public IntNode(IntNode pre, myType i, IntNode nex){
            prev = pre;
            next = nex;
            item = i;
        }
    }

    public LinkedListDeque(){
        sentinel = new IntNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public LinkedListDeque(myType x){
        sentinel = new IntNode(null, null, null);
        sentinel.next = new IntNode(sentinel, x, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public void addFirst(myType core){
        sentinel.next = new IntNode(sentinel, core, sentinel.next);
        sentinel.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(myType core){
        sentinel.prev = new IntNode(sentinel.prev, core, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
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
        IntNode po = this.sentinel.next;
        for (int i = 0; i < length; i++){
            System.out.print(po.item +" ");
            po = po.next;
        }
        System.out.println();
    }

    public myType removeFirst(){
        if (size == 0){
            return null;
        }
        myType result = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size -= 1;
        return result;
    }

    public myType removeLast(){
        if (size == 0){
            return null;
        }
        myType result = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel.prev;
        size -= 1;
        return result;
    }

    public myType get(int index){
        if (size - 1 < index){
            return null;
        }
        IntNode po = this.sentinel.next;
        for (int i = 0; i < index;i++){
            po = po.next;
        }
        return po.item;
    }

}
