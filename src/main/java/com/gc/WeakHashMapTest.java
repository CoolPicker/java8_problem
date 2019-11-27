package com.gc;

import java.util.WeakHashMap;

/**
 * 弱引用测试
 * 很少使用单个WeakReference来引用某个java对象，因为此时系统内存不会特别紧张。
 * 当程序有大量的Java对象需要使用弱引用来引用时，可以考虑使用WeakHashMap来保存
 *
 * WeakHashMap的功能类似HashMap，
 * 但一旦垃圾回收机制被执行，WeakHashMap中的所有key-value都会被清空，
 * 除非某些key还有强引用在引用它们
 */
public class WeakHashMapTest {

    public static void main(String[] args) throws InterruptedException {
        WeakHashMap<CrazyKey,String> map = new WeakHashMap<>();
        for (int i = 0 ; i < 10 ; i++) {
            map.put(new CrazyKey(i + 1 + ""),"value" + (i + 1));
        }
        System.out.println(map);
        System.out.println(map.get(new CrazyKey("2")));
        System.gc();
        Thread.sleep(50);
        System.out.println(map);
        System.out.println(map.get(new CrazyKey("2")));
    }

}

class CrazyKey {
    String name;
    public CrazyKey(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CrazyKey crazyKey = (CrazyKey) o;
        return name.equals(crazyKey.name);
    }

    @Override
    public String toString() {
        return "CrazyKey{" +
                "name='" + name + '\'' +
                '}';
    }
}
