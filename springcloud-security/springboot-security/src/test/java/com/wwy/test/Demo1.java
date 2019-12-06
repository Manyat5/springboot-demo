package com.wwy.test;

import org.junit.Test;

/**
 * @author wwy
 */
public class Demo1 {
    @Test
    public void test1(){
        int one_million = 1_000_000;
        System.out.println(one_million);
    }
    @Test
    public void test2(){

    }
}
class IncTest{
    public static void main(String[] args) {
        IncTest incTest = new IncTest();
        int i=0;
        incTest.add(i);
        i=i++;
        System.out.println(i);
    }
    void add(int i){
        i++;
    }
}
