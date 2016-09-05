package edu.feicui.app.entity;

/**
 * Created by Administrator on 2016/9/1 0001.
 */
public class TimeBuyInfo {
    public String name;
    public double price;
    public double s_price;
    public int state;
    public String remark;
    public  String img_path;
    public  String max_path;

    public TimeBuyInfo(String name, double price, double s_price, int state, String remark, String img_path, String max_path) {
        this.name = name;
        this.price = price;
        this.s_price = s_price;
        this.state = state;
        this.remark = remark;
        this.img_path = img_path;
        this.max_path = max_path;
    }


}
