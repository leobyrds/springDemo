package com.goopal.service;

/**
 * Created by leon on 2016/11/8.
 */
public interface HelloService {
    public default  String getName(){
        return"hello";
    }
}
