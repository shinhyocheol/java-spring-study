package com.example.spring;

import com.example.java.bagic.enums.EnumExample;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringExampleApplicationTests {

    @Test
    void contextLoads() {

        List<EnumExample> list = EnumExample.CODES;
        int count = 0;
        EnumExample key = list.get(count);
        count++;

        if (count == list.size()) {
            count = 0;
        }

        System.out.println(key.getName());
        System.out.println(key.getValue());

    }

}
