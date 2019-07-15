package com.lizz.fundation.jdk.cloneable;


/**
 * Obj
 * 克隆对象
 * 1.实现Cloneable接口
 * 2.重写对象的clone方法
 * 调用对象的clone方法进行克隆
 * @author lizz365
 * @date 19/7/15
 */
public class Obj implements Cloneable {
    private int id;
    private String value;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Obj{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Obj obj = new Obj();
        obj.setId(365);
        obj.setValue("lizz");
        Obj objClone = (Obj) obj.clone();
        obj.setValue("lizz365");

        System.out.println("obj:" + obj.toString());
        System.out.println("objClone:" + objClone.toString());
        System.out.println("obj == objClone:" + (obj == objClone));
        System.out.println("obj.getClass() == objClone.getClass():" + (obj.getClass() == objClone.getClass()));
        System.out.println("obj.equals(objClone):" + obj.equals(objClone));
//        输出:
//        obj:Obj{id=365, value='lizz365'}
//        objClone:Obj{id=365, value='lizz'}
//        obj == objClone:false
//        obj.getClass() == objClone.getClass():true
//        obj.equals(objClone):false

    }
}
