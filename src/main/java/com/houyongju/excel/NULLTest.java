package com.houyongju.excel;

import java.lang.reflect.Array;
import java.util.Map;

public class NULLTest {
    public static void main(String[] args) {
        try{
            Map map = null;
            map.size();
        }catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println(e);
        }
    }
}
