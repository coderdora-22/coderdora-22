package Arrays;

import java.util.LinkedList;
import java.util.Stack;

public class ValidParenthesis {
    class stk{
        int top=-1;
        char[] elements = new char[100];

        void push(char i){
            if(top == 99){
                System.out.println("Can't add stack overflow");
            }else{
//                System.out.println();
                top+=1;
                elements[top]=i;
            }
        }

        char pop(){
            if(top == -1){
                System.out.println("Can't add element");
                return ' ';
            }else{
                char ch = elements[top];
                top--;
                return ch;
            }
        }
         boolean isEmpty(){
            if(top == -1){
                return true;
            }else
                return false;
         }

    }


    public static void main(String[] args) {
        String st = "[]{}(){{{{{}}}}}";
        char[] sarr= st.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<sarr.length;i++){
            System.out.println(stack);
            if(sarr[i] == '[' || sarr[i] == '{'|| sarr[i] == '('){
                stack.push(sarr[i]);
            }else{
                char ch =stack.peek();
                System.out.println(stack+" "+ch+" "+sarr[i]);
                if(sarr[i] == '}' && ch == '{'){
                    stack.pop();
                    continue;
                }else if(sarr[i] == ')' && ch == '(')
                {
                    stack.pop();
                    continue;
                }else if(sarr[i] == ']' && ch == '['){
                    stack.pop();
                    continue;
                }else{
                    break;
                }
            }
        }
        if(stack.isEmpty()){
            System.out.println("valid");
        }else{
            System.out.println("invalid");
        }
    }
}
