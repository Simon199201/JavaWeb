package cn.itcast.reflect;

public class Student {
    private String name;
    private int uid;
    private int age;
    private String address;

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public void learn(){
        System.out.println("我是学生，我要好好学习！");
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", uid=" + uid +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
