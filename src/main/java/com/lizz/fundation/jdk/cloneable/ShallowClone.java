package com.lizz.fundation.jdk.cloneable;

/**
 * ShallowClone
 * 浅克隆
 * 当克隆对象中存在非基本类型对象时,该对象为地址引用,被多个对象共享使用,突破private限制
 * @author lizz365
 * @date 19/7/15
 */
public class ShallowClone implements Cloneable {
    private String code;
    private Obj obj;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Obj getObj() {
        return obj;
    }

    public void setObj(Obj obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ShallowClone{" +
                "code='" + code + '\'' +
                ", obj=" + obj +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ShallowClone sc = new ShallowClone();
        sc.setCode("lizz365");
        Obj obj = new Obj();
        obj.setId(365);
        obj.setValue("lizz");
        sc.setCode("lizz365");
        sc.setObj(obj);
        ShallowClone sco = (ShallowClone) sc.clone();
        //修改子对象中的值
        obj.setValue("lizz000");

        System.out.println("sc:" + sc.toString());
        System.out.println("sco:" + sco.toString());
        //对象参数为同一个对象
        System.out.println("sc.getObj() == sco.getObj():" + (sc.getObj() == sco.getObj()));

//        输出:
//        sc:ShallowClone{code='lizz365', obj=Obj{id=365, value='lizz000'}}
//        sco:ShallowClone{code='lizz365', obj=Obj{id=365, value='lizz000'}}
//        sc.getObj() == sco.getObj():true



    }
}
