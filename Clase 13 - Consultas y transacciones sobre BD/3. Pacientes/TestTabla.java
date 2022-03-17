package com.example.tx;

public class TestTabla {
    public static void main(String[] args) {

        String[][] table = new String[5][];
        table[0] = new String[] { "Apple", "Banana", "Papaya" };
        table[1] = new String[] { "Chicken", "Mutton", "Fish" };
        table[2] = new String[] { "Carrots", "Beans", "Cabbage" };
        table[3] = new String[] { "Candy", "Cake", "Bread" };
        table[4] = new String[] { "Candy", "Cake", "Bread" };

        for (String[] row : table) {
            System.out.format("%15s %15s %15s %n", row);
        }


    }
}
