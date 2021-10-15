package hot100;


import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class Lc208 {



    public class Trie {
        int path;
        int end;
        Map<Character, Trie> next;

        public Trie() {
            path = 0;
            end = 0;
            next = new HashMap<>();
        }
    }
    Trie root=new Trie();

    public void insert(String word){
        Trie node=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(!node.next.containsKey(c)){
                Trie newTrie=new Trie();
                node.next.put(c,newTrie);
                node.path++;
            }
            node=node.next.get(c);
        }
        node.end++;
    }
    public boolean search(String word){
        Trie node=root;
        for(int i=0;i<word.length();i++){
            char c=word.charAt(i);
            if(!node.next.containsKey(c)){
                return false;
            }
            node=node.next.get(c);
        }
        return node.end!=0;
    }
    public boolean startsWith(String prefix){
        Trie node=root;
        for(int i=0;i<prefix.length();i++){
            char c=prefix.charAt(i);
            if(!node.next.containsKey(c)){
                return false;
            }
            node=node.next.get(c);
        }
        return true;
    }
    @Test
    public void test(){
        insert("apple");
        System.err.println(false);
    }
}

