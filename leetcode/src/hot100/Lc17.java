package hot100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lc17 {

    Map<Integer,String> map=new HashMap<>();
    List<String> res=new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        init();
        backtrack(digits,0,new StringBuffer());
        return res;
    }
    public void backtrack(String digits,int idx,StringBuffer sb){
        if(idx==digits.length()){
            res.add(new String(sb));
            return ;
        }
        char c=digits.charAt(idx);
        String s=map.get(c-'0');
        char arr[]=s.toCharArray();
        for(char ch:arr){
            sb.append(ch);
            backtrack(digits,idx+1,sb);
            sb.deleteCharAt(sb.length()-1);
        }

    }
    public void init(){
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
    }

}
