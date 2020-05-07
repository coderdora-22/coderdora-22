package Arrays;
@SuppressWarnings("exception")
public class Linkedlist <T> {
    private int size =0;
    private Node <T> head =null;
    private Node <T> tail = null;
    private class Node <T>{
        T data;
        Node<T> prev, next;
        public Node(T data,Node<T> prev,Node<T> next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", prev=" + prev.data +
                    ", next=" + next.data +
                    '}';
        }
    }

    //Methods
    //clear
    public void clear(){
        Node <T> temp = head;
        while(temp!=null){
            Node <T> next = temp.next;
            temp.prev = null;
            temp.next = null;
            temp.data = null;
            temp = next;
        }
        head = tail = temp = null;
        size=0;
    }

    //size
    public int size(){
        return size;
//        Node<T> temp = head;
//        int count=0;
//        while(temp!=null){
//            Node<T> next = temp.next;
//            count++;
//            temp=next;
//        }
//        return count;
    }



    //isEmpty
    public boolean isEmpty(){
        return size() ==0;
    }

    //add
    public void add(T elem){
        addLast(elem);
    }

    //addFirst
    public void addFirst(T e){
        if(head==null){
            Node <T> node = new Node(e,null,null);
            head =tail= node;
            size++;
            return;
        }
        Node <T> temp = new Node(e,null,null);
        Node <T> s = head;
        temp.next = s;
        head = temp;
        size++;
    }

    //addLast
    public void addLast(T e){
        if(head==null){
            Node <T> node = new Node(e,null,null);
            head =tail= node;
            size++;
            return;
        }
        Node<T> temp = head;
        while(temp.next!=null){
            temp = temp.next;
        }
        temp.next = new Node(e,null,null);
        tail = temp.next;
        size++;
    }

    public void printData(){
        Node<T> temp = head;
        int count=0;
        while(temp!=null){
            System.out.println("data at "+count+" is "+temp.data);
            temp= temp.next;
            count++;
        }
    }
    //peekFirst
    public T peekFirst(){
        return head.data;
    }

    //peek not sure
    public T peekLast(){
        return tail.data;
    }

    //peekLast

    //removeFirst
    public T removeFirst(){
        if(head==null){
            throw new IllegalArgumentException("no element");
        }
        if(head.next == null){
            T data = head.data;
            head =tail= null;
            size=0;
            return data;
        }
        T data = head.data;
        head = head.next;
        head.prev = null;
        size-=1;
        return data;
    }

    //removeLast
    public T removeLast(){
        if(head==null){
            throw new IllegalArgumentException("no element");
        }
        if(head.next == null){
            T data = head.data;
            head =tail= null;
            size=0;
            return data;
        }
        Node<T> temp = head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        T data = temp.next.data;
        temp.next=null;
        size-=1;
        temp=tail;
        return data;
    }

    //removeEle



}
