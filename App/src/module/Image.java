package module;

import module.validator.ImageValidator;
import module.validator.ValidatorException;

import java.util.Arrays;

public class Image {
    private int row;
    private int column;
    private final String[][] matrix;

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

    public Image() {
        this.row = 0;
        this.column = 0;
        this.matrix = new String[row][column];
    }

    public Image(int row, int column) {
        try{
        this.row = row;
        this.column = column;
        this.matrix = new String[row][column];
        new ImageValidator().validate(this);
        }
        catch (ValidatorException e)
        {
            throw new ValidatorException(e);
        }
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                matrix[i][j] = "O";
    }

    public void clear(Image image) {
        for (int i = 0; i < row; i++)
            for (int j = 0; j < column; j++)
                matrix[i][j] = "O";
    }

    public void colorByPixel(int row, int column, String color) {
        this.matrix[row - 1][column - 1] = color;
    }

    public void colorVertical(int row1, int row2, int column, String color) {
        if (row1 > row2) {
            int b = row1;
            row1 = row2;
            row2 = b;
        }

        while (row1 <= row2) {
            matrix[row1 - 1][column - 1] = color;
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
            matrix[row - 1][column1 - 1] = color;
            column1++;
        }
    }

    private boolean isSafe(int x, int y) {
        return (x >= 0 && y >= 0 && x < matrix.length && y < matrix.length);
    }

    private void printRegion(String[][] matrix) {
        for (String[] row : matrix)
            System.out.println(Arrays.toString(row));
    }

    public void fillRegion(int row, int column, String color) {
        if (!fillRegionUtil(row, column, color)) {
            System.out.println("something went wrong.");
            return;
        }
        printRegion(matrix);
    }

    public boolean fillRegionUtil(int row, int column, String color) {
        //Region starts with 1 element - el[row][column]
        /*
        idea -> start at (x,y) go as far as possible, come back and fill in then repeat for the rest
         */
        System.out.println("what is going on");
        return false;
    }

    public void write() {
        for (String[] row : matrix)
            System.out.println(Arrays.toString(row));
    }
}
