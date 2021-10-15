package first200;

import org.junit.Test;

import java.util.Deque;
import java.util.LinkedList;

public class Lc71 {
    public String simplifyPath(String path) {
//        String strs[]=path.split("/");
//        Deque<String> deque=new LinkedList<>();
//        for(String str:strs){
//            if(str.equals("")||str.equals(".")){
//                continue;
//            }
//            if(str.equals("..")){
//                if(!deque.isEmpty())deque.pollLast();
//                continue;
//            }
//            deque.addLast(str);
//        }
//        StringBuilder sb=new StringBuilder();
//        sb.append("/");
//        while(!deque.isEmpty()){
//            sb.append(deque.pollFirst());
//            if(!deque.isEmpty()){
//                sb.append("/");
//            }
//        }
//        return sb.toString();
        Deque<String> queue = new LinkedList<>();
        // 分割字符
        String[] ss = path.split("/");
        for(String s : ss){
            if(s.equals("") || s.equals(".")){
                continue;
            }else if(s.equals("..")){
                queue.pollLast();
            }else{
                queue.offer(s);
            }
        }
        // 拼接
        StringBuilder sb = new StringBuilder("/");
        while(!queue.isEmpty()){
            sb.append(queue.poll());
            if(!queue.isEmpty()){
                sb.append("/");
            }
        }
        // 判空
        return sb.toString().equals("") ? "/" : sb.toString();

    }

    @Test
    public void test(){
       String path="/../";
        System.out.println(simplifyPath(path));

    }
}
