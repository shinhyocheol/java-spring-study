package com.example.spring.solid.lsp;

public class Main {

    public void increaseHeight(final Rectangle rectangle) {

        if (rectangle.getHeight() <= rectangle.getWidth()) {
            rectangle.setHeight(rectangle.getWidth() + 1);
        }

    }

    public static void main(String[] args) {

        /**
         * Rectangle과 이를 상속하는 Squre의 객체를 생성하고
         * 해당 객체를 이용해 increaseHeight를 호출한다면??
         */

    }

}
