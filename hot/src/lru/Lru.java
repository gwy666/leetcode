package lru;

import java.util.HashMap;
import java.util.Map;

public class Lru {
    public class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(){

        }
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Map<Integer,Node> map;
    Node head;
    Node tail;
    int capacity;
    public Lru(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        head=new Node();
        tail=new Node();
        head.next=tail;
        tail.pre=head;
    }

    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            moveToHead(node);
        }
        else{
            Node node= new Node(key,value);
            map.put(key,node);
            addToHead(node);
            if(map.size()>capacity){
                Node deleteNode=removeTail();
                map.remove(deleteNode.key);
            }
        }
    }


    public void addToHead(Node node){
        node.pre=head;
        node.next=head.next;
        head.next.pre=node;
        head.next=node;
    }
    public void remove(Node node){
        node.pre.next=node.next;
        node.next.pre=node.pre;
    }
    public void moveToHead(Node node){
        remove(node);
        addToHead(node);
    }
    public Node removeTail(){
        Node node=tail.pre;
        remove(node);
        return node;
    }

}
