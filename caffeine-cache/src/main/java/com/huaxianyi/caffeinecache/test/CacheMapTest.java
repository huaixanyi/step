package com.huaxianyi.caffeinecache.test;

import com.mchange.v1.identicator.IdList;
import com.mchange.v1.identicator.Identicator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author yancheng
 * @version 1.0
 * @date 2020-12-17 14:42
 */
public class CacheMapTest {

    private static boolean lock = false;
    private volatile static long lockNum = 0;

    public static class ListE<E> extends ArrayList<E> {
        public ListE<E> addR(E e) {
            this.add(e);
            return this;
        }

        public ListE(E... e) {
            this.addAll(Arrays.asList(e));
        }
    }

    public static void main(String[] args) throws Exception {
//        Runnable runnable = () -> {
//            for (long i = 0; i < 10000000000L; i++) {
//                lockNum++;
//            }
//        };
//        Runnable runnable1 = () -> {
//            for (long i = 0; i < 10000000000L; i++) {
//                lockNum++;
//            }
//        };
        ListE<Thread> runnableListE = new ListE<Thread>()
                .addR(new Thread(() -> {
                    for (long i = 0; i < 10000L; i++) {
                        lockNum++;
                        if (lock) {
                            printLn(":" + lockNum + "th1");
                        }
                    }
                }))
                .addR(new Thread(() -> {
                    for (long i = 0; i < 100L; i++) {
                        lockNum++;
                        if (i == 1) {
                            lock = true;
                        }
                    }
                }));
        runnableListE.forEach(Thread::start);
        Thread.sleep(3000);
        printLn();

    }

    public static void printLn(String... str) {
        System.out.println(lockNum + (str.length > 0 ? str[0] : ""));
    }

}
