package Arrays;

@SuppressWarnings("unchecked")
public class DyArray <T> {
    private T []arr;
    private int len; //user thinks array is
    private int capacity; //actual capacity

    DyArray(){
        this(10);
    }
    DyArray(int capacity){
      if(capacity<0) throw new IllegalArgumentException("capacity can't be negavite");
      this.capacity = capacity;
      this.arr = (T[]) new Object[capacity];
    }
    //size
    public int size(){
        return len;
    }
    //isEmpty
    public boolean isEmpty(){
        return size() == 0;
    }

    //get
    public T get(int index){
        return arr[index];
    }
    //set
    public void set(int index,T a){
        arr[index] =a;
    }

    //add
    public void add(T elem){
        if(len+1 >= capacity){
            if(capacity == 0 ) capacity=len+1;
            else capacity*=2;
            T new_arr[] = (T[])new Object[capacity];
            for(int i=0;i<arr.length;i++){
                new_arr[i]=arr[i];
            }
            arr = new_arr;
        }
        arr[len++]=elem;
    }

    //removeAt
    public T removeAt(int index){
        if(len<=index || index<0) throw new IndexOutOfBoundsException("invalid index");
        T data = arr[index];
        for(int i=0,j=0;j<arr.length;i++,j++){
            if(j == index)
                j++;
            arr[i]=arr[j];
        }
        capacity=--len;
        return data;
    }

    //remove
    public boolean remove(Object obj){
        for(int i=0;i<arr.length;i++){
            if(obj.equals(arr[i])){
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    //indexOf
    public int indexOf(Object obj){
        for(int i=0;i<arr.length;i++){
            if(obj.equals(arr[i])){
                return i;
            }
        }
        throw new IllegalArgumentException("not found");
    }


}
