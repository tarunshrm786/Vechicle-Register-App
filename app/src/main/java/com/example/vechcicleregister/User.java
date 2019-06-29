package com.example.vechcicleregister;

public class User {

    public String reg_num;
    public String vec_num;
    public String vec_type;
    public String vec_color;

    public User(){

    }

    public User(String reg_num,String vec_num,String vec_type,String vec_color)
    {
        this.reg_num = reg_num;
        this.vec_num = vec_num;
        this.vec_type = vec_type;
        this.vec_color = vec_color;
    }
}