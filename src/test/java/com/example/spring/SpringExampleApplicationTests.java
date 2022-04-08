package com.example.spring;

import com.example.java.bagic.EnumExample;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootTest
class SpringExampleApplicationTests {

    @Test
    public void contextLoads() throws Exception{

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

    @Test
    public void 스트림_사용해보기() throws Exception {

        String[] stringArray = {"shinhyocheol", "hyobang", "shin"};
        Set<String> set = Arrays.asList(stringArray)
                .stream()
                .filter(e -> e.startsWith("shin"))
                .collect(Collectors.toSet());

        set.forEach(System.out::println);


    }

}
