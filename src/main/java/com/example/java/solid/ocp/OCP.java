package com.example.java.solid.ocp;

import java.util.ArrayList;
import java.util.List;

public class OCP {

    /**
     * OCP(Open Close Principle) : 개방폐쇄의 원칙
     *  시간이 지나도 유지 보수와 확장이 쉬운 시스템을 만들고자 로버트 마틴이 명명한 객체지향설계 5대 원칙 SOLID 중 하나이다.
     *  OCP는 소프트웨어 구성 요소(컴포넌트, 클래스, 모듈, 함수)는 확장에 대해서는 개방(OPEN)되어야 하지만 변경에 대해서는 폐쇄(CLOSE) 되어야 한다는 의미이다.
     *  즉, 기존의 코드를 변경하지 않으면서 기능을 추가할 수 있도록 설계가 되어야 한다는 뜻이다.
     */

    public List<Integer> generate(int shuffle) {
        List<Integer> numbers = new ArrayList<>();

//        return numbers.subList(0, Lott)
        return numbers;
    }

}
