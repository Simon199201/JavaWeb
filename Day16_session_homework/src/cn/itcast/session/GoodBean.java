package cn.itcast.session;

public class GoodBean {
    private int pid;
    private String pname;
    private String pdesc;

    public GoodBean() {
    }

    public GoodBean(int pid, String pname, String pdesc, double price, int num) {
        this.pid = pid;
        this.pname = pname;
        this.pdesc = pdesc;
        this.price = price;
        this.num = num;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPdesc() {
        return pdesc;
    }

    public void setPdesc(String pdesc) {
        this.pdesc = pdesc;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    private double price;
    private int num;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "GoodBean{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", pdesc='" + pdesc + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }
}
