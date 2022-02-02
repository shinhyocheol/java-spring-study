package com.example.spring.oop.solid.lsp;

// 정사각형은 직사각형을 상속받았다.
public class Square extends Rectangle {

    @Override
    public void setWidth(final int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(final int height) {
        super.setHeight(height);
        super.setWidth(height);
    }

}
