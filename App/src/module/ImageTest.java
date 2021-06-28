package module;

import org.junit.jupiter.api.Test;

class ImageTest {

    private final Image obj = new Image(5, 6);

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
        obj.colorByPixel(5, 5, "J");
        obj.write();
        obj.clear();
        System.out.println();
        obj.write();
    }

    @org.junit.jupiter.api.Test
    void colorByPixel() {
        obj.colorByPixel(1, 1, "A");
        obj.write();
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
        obj.colorByPixel(3, 2, "A");
        obj.colorByPixel(2, 3, "A");
        obj.colorByPixel(3, 4, "A");
        obj.colorByPixel(4, 3, "A");
        obj.fillRegion(2,2,"J");
        obj.clear();
        System.out.println();
        obj.write();
        obj.colorByPixel(2, 1, "A");
        obj.colorByPixel(1, 2, "A");
        obj.colorByPixel(2, 3, "A");
        obj.colorByPixel(3, 2, "A");
        obj.fillRegion(2,2,"J");
        obj.clear();
        System.out.println();
        obj.colorVertical(1, 5, 3, "A");
        obj.fillRegion(2,2,"J");
        obj.clear();
        System.out.println();
        obj.colorHorizontal(3, 1, 6, "A");
        obj.fillRegion(2,2,"J");
    }
}