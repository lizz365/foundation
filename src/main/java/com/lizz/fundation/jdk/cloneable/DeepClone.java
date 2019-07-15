package com.lizz.fundation.jdk.cloneable;

/**
 * DeepClone
 * 深克隆
 * 在clone方法中实现对象成员的克隆
 * @author lizz365
 * @date 19/7/15
 */
public class DeepClone implements Cloneable {
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
        DeepClone deepClone = (DeepClone) super.clone();
        //克隆对象变量
        deepClone.setObj((Obj) deepClone.getObj().clone());
        return deepClone;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        DeepClone dc = new DeepClone();
        dc.setCode("lizz365");
        Obj obj = new Obj();
        obj.setId(365);
        obj.setValue("lizz");
        dc.setCode("lizz365");
        dc.setObj(obj);
        DeepClone dco = (DeepClone) dc.clone();
        obj.setValue("lizz000");

        System.out.println("shallowClone:" + dc.toString());
        System.out.println("shallowCloneObj:" + dco.toString());
        System.out.println("sc.getObj() == sco.getObj():" + (dc.getObj() == dco.getObj()));

        //输出:
//        shallowClone:ShallowClone{code='lizz365', obj=Obj{id=365, value='lizz000'}}
//        shallowCloneObj:ShallowClone{code='lizz365', obj=Obj{id=365, value='lizz'}}
//        sc.getObj() == sco.getObj():false
    }
}
