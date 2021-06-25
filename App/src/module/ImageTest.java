package module;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImageTest {

    private final Image obj = new Image(5, 5);

    @org.junit.jupiter.api.Test
    void validate() {
        Image testImage = new Image(251, 0);
    }

    @org.junit.jupiter.api.Test
    void getRow() {
        System.out.println(obj.getRow());
    }

    @org.junit.jupiter.api.Test
    void setRow() {
        System.out.println(obj.getRow());
        obj.setRow(6);
        System.out.println(obj.getRow());
    }

    @org.junit.jupiter.api.Test
    void getColumn() {
        System.out.println(obj.getColumn());
    }

    @org.junit.jupiter.api.Test
    void setColumn() {
        System.out.println(obj.getColumn());
        obj.setColumn(11);
        System.out.println(obj.getColumn());
    }

    @org.junit.jupiter.api.Test
    void clear() {
        obj.colorByPixel(5, 10, "J");
        obj.write();
        obj.clear(obj);
        System.out.println();
        obj.write();
    }

    @org.junit.jupiter.api.Test
    void colorByPixel() {
    }

    @Test
    void colorVertical() {
        obj.write();
        System.out.println();
        obj.colorVertical(3, 1, 1, "J");
        obj.write();
    }

    @Test
    void colorHorizontal() {
        obj.write();
        System.out.println();
        obj.colorHorizontal(1, 3, 1, "J");
        obj.write();
    }

    @Test
    void fillRegion() {
        obj.fillRegion(1,1,"J");
    }
}