package Backtracking;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class wordBreak2 {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> result=new LinkedList<String>();
        if(s==null || s.length()==0 ||wordDict==null || wordDict.size()==0) return result;
        HashSet<String> set=new HashSet<String>(wordDict);
        HashMap<String,List<String>> used=new HashMap<String,List<String>>();
        result=wordBreakHelper(s,set,used);
        return result;
    }

    /*
    * Input:
  s = "catsanddog"
wordDict = ["cat", "cats", "and", "sand", "dog"]
Output:
[
  "cats and dog",
  "cat sand dog"
]
    *
    * */
    private static List<String> wordBreakHelper(String s,HashSet<String> set, HashMap<String,List<String>> used){
        if(used.containsKey(s)){
            return used.get(s);
        }
        if(s.length()==0) return null;
        List<String> res=new LinkedList<String>();
        for(int i=1;i<=s.length();i++){
            String sub=s.substring(0,i);
            if(set.contains(sub)){
                List<String> partRes=wordBreakHelper(s.substring(i),set,used);
                if(partRes==null){
                    res.add(sub);
                }else{
                    for(String str:partRes){
                        res.add(sub+" "+str);
                    }
                }
            }
        }
        used.put(s,res);
        return res;
    }

    public static void main(String[] args) {
        String s="catsanddog";
        List<String> wordDict = new LinkedList<>();
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");
        List<String> res=wordBreak(s,wordDict);
        System.out.println(res);
    }
}
