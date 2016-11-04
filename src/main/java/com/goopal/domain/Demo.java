package com.goopal.domain;

import lombok.Data;

//@Entity//加入这个注解，Demo就会进行持久化了，在这里没有对@Table进行配置，请自行配置。
@Data
public class Demo {
    //@Id
    //@GeneratedValue//(strategy=GenerationType.IDENTITY)
    private long id;//主键.
    private String name;//测试名称.
}
