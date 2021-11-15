package com.example.spring.oop.solid.lsp;

public class Main {

    public void increaseHeight(Rectangle rectangle) {

        if (rectangle.getHeight() <= rectangle.getWidth()) {
            rectangle.setHeight(rectangle.getWidth() + 1);
        }

    }

    public static void main(String[] args) {

        Rectangle rectangle = new Rectangle();  // 직사각형
        Square square = new Square();           // 직사각형을 상속받는 정사각형

        Main main = new Main();

        main.increaseHeight(rectangle);
        main.increaseHeight(square);
        /**
         * Rectangle과 이를 상속하는 Square의 객체를 생성하고
         * 해당 객체를 이용해 increaseHeight를 호출한다면??
         * Rectangle의 객체는 정상적으로 동작할 것이다.
         * 세로의 길이가 가로의 길이보다 작거나 같다면 세로의 길이를 가로 길이 + 1만큼의 값으로
         * 변경하면 된다.
         * 그러나 Square 가져다 준다면??
         * 세로와 가로의 길이는 항상 같아야 정사각형이다. 그런데 같은경우 해당 조건이 성립되면서
         * 세로의 길이와 가로의 길이가 각각 +1이 된다.
         *
         * increaseHeight 메소드는 직사각형의 길이는 가로보다 세로가 길어야 한다 라는 가정을 세우고
         * 만든 메소드인데 이 가정이 깨져버린다. 그렇다면 메소드에 예외처리를 추가하면 어떨까??
         * 이는 개방 폐쇄 원칙에 어긋나는 코드라고 한다. 왜냐면 해당 메소드는 확장에 열려있지 않기때문이다.
         * 따라서 Square 클래스는 Rectangle 클래스를 상속받는 순간 리스코프 치환 원칙에 부합하지 않게된다.
         * 정사각형은 직사각형에 포함되지만 해당 메소드는 정사각형에 맞지 않는 메소드이기때문이다.
         * 따라서 상속받지 않는다.
         *
         * 상위타입에서 정한 명세를 하위타엡에서도 그대로 지킬 수 있을 때 상속을 해야한다.
         * (혹여나 위처럼 상속을 받고자 한다면 위 메소드를 정의하지 않았어야 한다.)
         *
         * @@ 리스코프 치환 원칙
         *  "상위 타입의 객체를 하위 타입의 객체로 치환해도 상위 타입을 사용하는 프로그램은 정상적으로 동작해야한다"
         *  특정 메소드가 상위 타입을 인자로 사용한다고 할 때, 그 타입의 하위 타입도 문제 없이 정상적으로 작동해야 한다
         */

    }

}
