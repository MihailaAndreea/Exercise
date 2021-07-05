package module;

import module.validator.ImageValidator;
import module.validator.ValidatorException;

import java.util.Arrays;

public class Image {
    private int row;
    private int column;
    private final Pixel[][] matrix;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Pixel[][] getMatrix() {
        return matrix;
    }

    public Image() {
        this.row = 0;
        this.column = 0;
        this.matrix = new Pixel[row][column];
    }

    public Image(int row, int column) {
        try{
            this.row = row;
            this.column = column;
            this.matrix = new Pixel[row][column];
            new ImageValidator().validate(this);
        }
        catch (ValidatorException e)
        {
            throw new ValidatorException(e);
        }
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                Pixel pixel = new Pixel(i, j, "O");
                matrix[i][j] = pixel;
            }
        }
    }

    public void clear() {
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                matrix[i][j].setColor("O");
    }

    public void colorByPixel(int row, int column, String color) {
        this.matrix[row - 1][column - 1].setColor(color);
    }

    public void colorVertical(int row1, int row2, int column, String color) {
        if (row1 > row2) {
            int b = row1;
            row1 = row2;
            row2 = b;
        }

        while (row1 <= row2) {
            matrix[row1 - 1][column - 1].setColor(color);
            row1++;
        }
    }

    public void colorHorizontal(int row, int column1, int column2, String color) {
        if (column1 > column2) {
            int b = column1;
            column1 = column2;
            column2 = b;
        }

        while (column1 <= column2) {
            matrix[row - 1][column1 - 1].setColor(color);
            column1++;
        }
    }

    private boolean isSafe(int x, int y) {
        return (x >= 0 && y >= 0 && x < row && y < column);
    }
    private boolean isR(int x, int y, String color){return  matrix[x][y].getColor().equals(color);}

    private void printRegion(Pixel[][] matrix) {
        for (Pixel[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    public void fillRegion(int row, int column, String color) {
        row = row - 1;
        column = column - 1;
        String initialColor = matrix[row][column].getColor();
        fillRegionUtil(row, column, color, initialColor);
        printRegion(matrix);
    }

    public boolean fillRegionUtil(int row, int column, String color, String initialColor) {
        /*
        idea -> start at (x,y) go down as far as possible, go to the right as far as possible,
        repeat, then go fill the rest (left side)
         */
//        printRegion(matrix);
//        System.out.println();
        boolean filled = false;
        if(isSafe(row, column))
        {
            if(isR(row, column, initialColor))
            {
                matrix[row][column].setColor(color);
                filled = fillRegionUtil(row + 1, column, color, initialColor)
                        ||fillRegionUtil(row, column + 1, color, initialColor)
                        ||fillRegionUtil(row, column - 1, color, initialColor)
                        ||fillRegionUtil(row - 1, column, color, initialColor);}

        }
        return filled;
    }

    public void write() {
        for (Pixel[] row : matrix)
            System.out.println(Arrays.toString(row));
        System.out.println();
    }
}
