package cn.itcast.reflect;

public class Teacher {
    private String name;
    private int uid;
    private int age;
    private String address;

    public Teacher() {
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
    public void teach(){
        System.out.println("我是老师，我要好好教学！");

    }
    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", uid=" + uid +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
