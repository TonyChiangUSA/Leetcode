package Pony;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {
    public int calculate(String s){
        int num=0;
        char sign='+';
        int res=0;
        Deque<Integer> stack=new ArrayDeque<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }
            if(c=='('){
                num=calculate(s.substring(i+1));
            }
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(sign=='+'){
                    stack.push(num);
                }else if(sign == '-'){
                    stack.push(-num);
                }else if(sign == '*'){
                    stack.push(stack.pop()*num);
                }else if(sign == '/'){
                    stack.push(stack.pop()/num);
                }
                sign=c;
                num=0;
            }

            if(c==')') break;
        }

        while(!stack.isEmpty()){
            res+=stack.poll();
        }
        return res;
    }
}
