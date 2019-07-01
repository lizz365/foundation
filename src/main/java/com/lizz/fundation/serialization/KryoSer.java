package com.lizz.fundation.serialization;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.lizz.fundation.dto.UserDTO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * KryoSer
 *
 * @author lizz365
 * @date 19/7/1
 */
public class KryoSer {
    public static void main(String[] args) throws IOException {
        String src = System.getProperty("user.dir")+"/src/main/java/com/lizz/fundation/serialization/kryoSer.txt";
        //创建对象
        UserDTO obj = new UserDTO();
        obj.setName("张三");
        obj.setId(111);
        //写入
        Kryo kryo = new Kryo();
        Output output = new Output(new FileOutputStream(src));
        kryo.writeObject(output, obj);
        output.close();
        //读取
        FileInputStream in = new FileInputStream(src);
        System.out.println("size:"+in.available());
        Input input = new Input(in);
        UserDTO user = kryo.readObject(input, UserDTO.class);
        input.close();

        System.out.println(user.getName());
        System.out.println(user.getId());

    }
}
