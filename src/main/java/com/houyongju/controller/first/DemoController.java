package com.houyongju.controller.first;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/demo")
@Slf4j
public class DemoController {
    private ThreadLocal<Integer> currentUser = ThreadLocal.withInitial(() -> null);
    @RequestMapping(value = "/test1", method = {RequestMethod.GET})
    public Map test1(){
        Map respMap = new HashMap();
        respMap.put("code","007");
        respMap.put("message","测试demo1");
        return  respMap;
    }

    @RequestMapping(value = "/testDemo1", method = {RequestMethod.GET})
    public Map wrongUserId(@RequestParam("userId") Integer userId) {
        try{
            //设置用户信息之前先查询一次ThreadLocal中的用户信息
            String before = Thread.currentThread().getName() + ":" + currentUser.get();
            //设置用户信息到ThreadLocal
            currentUser.set(userId);
            //设置用户信息之后再查询一次ThreadLocal中的用户信息
            String after = Thread.currentThread().getName() + ":" + currentUser.get();
            //汇总输出两次查询结果
            Map result = new HashMap(16);
            result.put("before", before);
            result.put("after", after);
            return result;
        }finally {
            currentUser.remove();
        }


    }

    public static void main(String[] args) {
        try{
            int[] arr = null;
            int length = arr.length;
        }catch (Exception e){
            System.out.println(e.getMessage());
            log.error(e.getMessage() ,e);
        }

    }
}
