package TouTiao;

import java.util.HashMap;

/**
 * 设计一个LRU数据结构
 * Created by Yang on 2017/4/23.
 */
public class _8_ {

    public static class Node{
        public int key;
        public int val;
        public Node pre;
        public Node next;

        public Node(int key,int val){
            this.key = key;
            this.val = val;
        }
    }

    public static class LRUCache{
        //存储索引值和节点；
        HashMap<Integer,Node> map;
        //计数器和容量
        int count,capicity;
        //头结点和尾节点，不存储值，仅仅是用于指引
        Node head,tail;

        public LRUCache(int capicity){
            map = new HashMap<>();
            count = 0;
            this.capicity = capicity;
            head = new Node(0,0);
            tail = new Node(0,0);
            head.next = tail;
            head.pre = null;
            tail.pre = head;
            tail.next = null;
        }

        //删除双向链表中的元素
        public void deleteNode(Node node){
            node.pre.next = node.next.next;
            node.next.pre = node.pre;
        }

        //将节点加入到双向链表的头部
        public void addToHeader(Node node){
            node.next = head.next;
            node.next.pre = node;
            node.pre = head;
            head.next = node;
        }

        public int get(int key){
            //如果存在key值
            if(map.containsKey(key)){
                Node node = map.get(key);
                //将节点调整到头部，表示最近刚刚访问
                deleteNode(node);
                addToHeader(node);
                return node.val;
            }
            return -1;
        }


        public void set(int key,int val){
            if(map.containsKey(key)){
                //如果已经有节点了
                Node node = map.get(key);
                node.val = val;
                deleteNode(node);
                addToHeader(node);
            }else {
                //没有节点则创建一个节点
                Node node = new Node(key,val);
                map.put(key,node);
                if(count<capicity){
                    //未超过容量
                    count++;
                    //计数器加1，节点放入双向链表头部
                    addToHeader(node);
                }else {
                    //超过容量，删除尾指示节点之前的节点
                    map.remove(tail.pre.key);
                    deleteNode(tail.pre);
                    //将新节点加入头部
                    addToHeader(node);
                }
            }


        }
    }

}
