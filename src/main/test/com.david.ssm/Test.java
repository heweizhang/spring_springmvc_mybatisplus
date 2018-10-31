package com.david.ssm;

import org.springframework.beans.factory.annotation.Autowired;

public class Test {
    @Autowired
    HelloWorld helloWorld;

    @org.junit.Test
    public void myTest() {
        helloWorld.getMessage();
    }
}
