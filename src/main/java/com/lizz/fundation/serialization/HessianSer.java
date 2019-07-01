package com.lizz.fundation.serialization;

import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import com.lizz.fundation.dto.UserDTO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * HessianSer
 *
 * @author lizz365
 * @date 19/7/1
 */
public class HessianSer {
    public static void main(String[] args) throws IOException {
        //创建对象
        UserDTO obj = new UserDTO();
        obj.setName("张三");
        obj.setId(111);
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //Hessian的序列化输出
        HessianOutput ho = new HessianOutput(os);
        ho.writeObject(obj);
        byte[] userByte = os.toByteArray();
        ByteArrayInputStream is = new ByteArrayInputStream(userByte);
        System.out.println("size:" + is.available());
        //Hessian的反序列化读取对象
        HessianInput hi = new HessianInput(is);
        UserDTO user = (UserDTO) hi.readObject();
        System.out.println(user.getName());
        System.out.println(user.getId());
    }
}
