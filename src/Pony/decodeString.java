package Pony;

import java.util.*;

public class decodeString {
    public String decodeString(String s) {
        Deque<Integer> intStack=new ArrayDeque<>();
        Deque<StringBuilder> strStack=new ArrayDeque<>();
        int num=0;
        StringBuilder curStr=new StringBuilder();
        for(char c:s.toCharArray()){
            if(Character.isDigit(c)){
                num=num*10+(c-'0');
            }else if(c=='['){
                intStack.push(num);
                strStack.push(curStr);
                num=0;
                curStr=new StringBuilder();
            }else if(c==']'){
                StringBuilder decodedStr=strStack.poll();
                for(int k=intStack.poll();k>0;k--){
                    decodedStr.append(curStr);
                }
                curStr=decodedStr;
            }else{
                curStr.append(c);
            }
        }
        return curStr.toString();
    }
}
