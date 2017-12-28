package com.tg.jnatest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Structure;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.util.Arrays;
import java.util.List;

/**
 * @CreadBy ：DramaScript
 * @date 2017/12/27
 */
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = (TextView) findViewById(R.id.tv);

//        tv.setText(JnaTest.INSTANCE.test(1,2));

//        IntBuffer retry = IntBuffer.allocate(1);
//        JnaTest.INSTANCE.getInt(retry);
//        tv.setText(retry.array()[0]+"");

//        byte [] bytename=new byte[50];
//        ByteBuffer call=ByteBuffer.wrap(bytename);
//        ByteBuffer name=ByteBuffer.wrap("我最牛逼！".getBytes());
//        JnaTest.INSTANCE.getChar(name, call);
//        tv.setText(new String(call.array()));

//        JnaTest.User person=new JnaTest.User();
//        JnaTest.INSTANCE.getStruct(person);
//        tv.setText("name="+new String(person.name)+"age="+person.age);

        String s = "dcba";
        byte[] arr = new byte[50];
        ByteBuffer call=ByteBuffer.wrap(arr);
        JnaTest.INSTANCE.getArray(call);
        tv.setText(new String(call.array()));
    }

    public interface JnaTest extends Library {

        // 第 一个参数是动态链接库dll/so的名称
        //第二个参数是本接口的Class类型。JNA通过这个Class类型，根据指定的.dll/.so文件，动态创建接口的实例。该实例由JNA通过反射自动生成。
        JnaTest INSTANCE = (JnaTest)Native.loadLibrary("jnitest", JnaTest.class);

        //继承Structure，用来与C里面的结构体进行交互
        class User extends Structure{

            public int age;
            public byte[] name = new byte[11];
            public byte[] type = new byte[20];

            public User() {
                super();
            }

            public User(int age, byte name[], byte type[]) {
                super();
                this.age = age;
                if ((name.length != this.name.length))
                    throw new IllegalArgumentException("Wrong array size !");
                this.name = name;
                if ((type.length != this.type.length))
                    throw new IllegalArgumentException("Wrong array size !");
                this.type = type;
            }

            @Override
            protected List<String> getFieldOrder() {
                return Arrays.asList("age", "name", "type");
            }
        }

        /**
         * 以下函数注意，名字和参数必须与test.h里面定义的函数一致。数据类型对应什么请查阅JNA数据类型对应表
         */

        // 测试 int类型
        int test(int a, int b);
        //测试 int*
        void getInt(IntBuffer a);
        //测试 String
        void getChar(ByteBuffer name,ByteBuffer s);
        //测试 结构体
        void getStruct(JnaTest.User user);
        // 测试 byte[] 数组
        void getArray(ByteBuffer arr);
    }

}