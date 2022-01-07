package com.example.demo.designPattern.singleton;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SingleTonTest {

    @Autowired
    private SingleModel singleModel1;

    @Autowired
    private SingleModel singleModel2;

    @GetMapping("/test1")
    public String singletonTest1() {
        return " singletonTest1 : " + singleModel1.plus() + "different : "
            + ++SingleModel.staticNum;
    }

    @GetMapping("/test2")
    public String singletonTest2() {
        return " singletonTest2 : " + singleModel2.plus() + "different : "
            + ++SingleModel.staticNum;
    }

}
