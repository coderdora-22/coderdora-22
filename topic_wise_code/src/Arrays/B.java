package Arrays;

abstract class A{
    int a =10;

    abstract void print();
    public void helloPrint(){ //concrete
        System.out.println("hello print");
    }
    public void printB(){
        System.out.println("ab");
    }
}
interface C{
    int a = 30;

    public void print();

    public default void printB(){
        System.out.println("print deafult B interface");
    }
    public static void printk(){
        System.out.println("static print B interface");
//        return 0;
    }
    default void InterfacePrint(){
        System.out.println("interface");
    }
}

public class B extends A implements C{
    int a=20;

    public void print(){
        System.out.println("class B print");
    }

    public void InterfacePrint(){
        System.out.println("interface");
    }

    public void helloPrint(){
        System.out.println("hello print B");
    }

    public static void main(String[] args) {
        B b = new B();//run time
        A a1 = new B();
        C c = new B();//
        System.out.println(c.a); // 30 //compile time -> 30 c
        System.out.println(a1.a); //10
        System.out.println(b.a); // 20
        c.InterfacePrint();

     DyArray<Integer> d = new DyArray<Integer>();
     d.add(2);
     d.add(3);
     d.add(6);
     System.out.println(d.get(0));
     d.add(8);
     System.out.println("   "+d.get(3));
        for(int i=0;i<d.size();i++){
            System.out.println(d.get(i));
        }
     d.remove(3);
     for(int i=0;i<d.size();i++){
         System.out.println(d.get(i));
     }
        System.out.println(d.indexOf(2));
     Linkedlist<Integer> ls = new Linkedlist<>();
     ls.add(1);
     ls.add(2);
     ls.printData();
     ls.addLast(3);
     ls.addFirst(0);
     ls.printData();
     System.out.println(ls.size());
//     System.out.println(ls.toString());
//ls.clear();
        System.out.println(ls.size());
        ls.printData();
        System.out.println(ls.removeLast());
        ls.printData();
        System.out.println(ls.removeFirst());
        ls.printData();
        System.out.println(ls.peekFirst());
        ls.add(5);
        ls.add(6);
        ls.add(9);
        System.out.println(ls.peekLast());
        ls.printData();
    }
}

