package module;

public class Pixel {
    private int x;
    private int y;
    private String color;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Pixel(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }

    public Pixel()
    {
        this.x = 0;
        this.y = 0;
        this.color = "";
    }
}
