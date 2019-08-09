package cn.wishhust.jmm.reference;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.time.temporal.WeekFields;

public class ReferenceTest {

    public static void main(String[] args) {



        System.out.println("-----软引用------");
        // 软引用 (内存溢出之前进行回收)
        ReferenceQueue queue = new ReferenceQueue();
        User user = new User("xiaobai", 11);
        SoftReference sr = new SoftReference(user, queue);
        SoftReference sr2 = new SoftReference(user);
        System.out.println(sr.get());
        user = null;
        System.out.println(sr.get());
        System.out.println(queue.poll());

        System.out.println("-----弱引用------");
        // 弱引用 （下一次垃圾回收进行回收）
        ReferenceQueue queue2 = new ReferenceQueue();
        WeakReference<User> wr = new WeakReference<>(new User("xiaoming",10), queue2);
        WeakReference<User> wr2 = new WeakReference<>(new User("xiaoming",10));
        System.out.println(wr.get());
        System.gc();
        System.out.println(wr.get());
        System.out.println(queue2.poll());

        System.out.println("------虚引用-----");
        // 虚引用（）
        // 虚引用必须和引用队列一起使用，当垃圾回收一个对象时，发现它有虚引用，就会在垃圾回收前将其加入到关联到引用队列。
        ReferenceQueue queue3 = new ReferenceQueue();
        User user3 = new User("lisi",20);
        PhantomReference pr = new PhantomReference(user3,queue3);
        user3 = null;
        System.gc();
        System.out.println(pr.get());
        System.out.println(queue3.poll());
    }
}
