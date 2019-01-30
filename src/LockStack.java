//import org.w3c.dom.Node;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockStack {

    Lock lock;
    Node head;
    int numOps;

    class Node<T>{
        public T val;
        public Node next;

        public Node(T val){
            this.val = val;

        }
    }

    public LockStack(){
        lock = new ReentrantLock();
        head = null;
    }



}
