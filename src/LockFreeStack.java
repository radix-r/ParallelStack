//import org.w3c.dom.Node;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockFreeStack<T> {

    private Lock lock;
    private Node head;
    private AtomicInteger numOps;

    class Node<T>{
        public T val;
        public Node next;

        public Node(T val){
            this.val = val;

        }
    }

    public LockFreeStack(){
        this.lock = new ReentrantLock();
       this.head = null;
    }

    public boolean push(T p){
        lock.lock();
        Node n = new Node(p);
        n.next = head;
        head = n;
        numOps.getAndIncrement();
        lock.unlock();
        return true;
    }

    public T pop(){
        lock.lock();
        if (head == null){
            lock.unlock();
            return null;
        }
        Node n = head;
        head = n.next;
        numOps.getAndIncrement();
        lock.unlock();
        return (T)n.val;
    }

    public int getNumOps(){
        return numOps.get();
    }



}
