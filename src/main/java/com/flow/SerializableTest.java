package com.flow;

import java.io.*;
import java.util.Objects;

/**
 * @Description 构造器
 * @Author nya
 * @Date 2019/11/12 上午10:28
 **/
public class SerializableTest {

    public static void main(String[] args) throws Exception {
        Wolf wolf = new Wolf("小灰灰");
        System.out.println(" ---- ");
        Wolf single = null;
        // 创建对象输出流
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("a.bin"));
        // 创建对象输入流
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("a.bin"));
        // 序列化输出Java对象
        oos.writeObject(wolf);
        oos.flush();
        // 反序列化恢复Java对象
        single = (Wolf) ois.readObject();
        System.out.println(wolf.equals(single));
        System.out.println(wolf == single);
    }

}

class Wolf implements Serializable {

    private String name;

    public Wolf(String name) {
        this.name = name;
        System.out.println("调用有参数的构造器");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Wolf wolf = (Wolf) o;
        return Objects.equals(name, wolf.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "name='" + name + '\'' +
                '}';
    }
}
