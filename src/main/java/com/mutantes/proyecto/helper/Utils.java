package com.mutantes.proyecto.helper;

public class Utils {
    
    public static char[][] convertStringToChar(String[] dna){
        char[][] matrix = null;
        try {
            int row     = 0,
            column  = 0;

            row = dna.length;
            column = dna[0].length();
        
            matrix = new char[row][column];

            for (int i = 0; i < row; i++) {
                String data = dna[i].toUpperCase();
                for (int j = 0; j < column; j++) {
                    matrix[i][j] = data.charAt(j);
                }
            }
        } catch (Exception e) {
            return null;
        }
        
        return matrix;
    }

    public static void previewMatrix(char[][] matrix) {
        for (char[] row : matrix) {
           for (char ch : row) {
               System.out.print(ch + " ");
           }

           System.out.println();
       }

       System.out.println();
    }

    public static boolean search(String word, char[][] matrix) {
        //int[] sitio = new int[]{-1, -1, -1};
        boolean found = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int column = 0; column < matrix[row].length; column++) {
    
                // busca derecha
                if (column + (word.length() - 1) < matrix[row].length) {
                    boolean isFound = true;
    
                    for (int letters = 0; letters < word.length(); letters++) {
                        if (word.charAt(letters) != matrix[row][column + letters]) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
                        // sitio[0] = row;
                        // sitio[1] = column;
                        // sitio[2] = 2;
                        found = true;
                    }
                }
    
                // busca izquierda
                if (column - (word.length() - 1) >= 0) {
                    boolean isFound = true;
    
                    for (int letters = 0; letters < word.length(); letters++) {
                        if (word.charAt(letters) != matrix[row][column - letters]) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
                        // sitio[0] = row;
                        // sitio[1] = column;
                        // sitio[2] = 6;
                        found = true;
                    }
                }
    
                // busca abajo
                if (row + (word.length() - 1) < matrix.length) {
                    boolean isFound = true;
    
                    for (int letters = 0; letters < word.length(); letters++) {
                        if (word.charAt(letters) != matrix[row + letters][column]) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
                        // sitio[0] = row;
                        // sitio[1] = column;
                        // sitio[2] = 4;
                        found = true;
                    }
                }
    
                // busca arriba
                if (row - (word.length() - 1) >= 0) {
                    boolean isFound = true;
    
                    for (int letters = 0; letters < word.length(); letters++) {
                        if (word.charAt(letters) != matrix[row - letters][column]) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
                        // sitio[0] = row;
                        // sitio[1] = column;
                        // sitio[2] = 0;
                        found = true;
                    }
                }
    
                // diagonal arriba derecha
                if ((row - (word.length() - 1) >= 0) && (column + (word.length() - 1) < matrix[row].length)) {
                    boolean isFound = true;
    
                    for (int letters = 0; letters < word.length(); letters++) {
                        if (word.charAt(letters) != matrix[row - letters][column + letters]) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
                        // sitio[0] = row;
                        // sitio[1] = column;
                        // sitio[2] = 1;
                        found = true;
                    }
                }
                //
    
                // diagonal arriba izquierda
                if ((row - (word.length() - 1) >= 0) && (column - (word.length() - 1) >= 0)) {
                    boolean isFound = true;
    
                    for (int letters = 0; letters < word.length(); letters++) {
                        if (word.charAt(letters) != matrix[row - letters][column - letters]) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
                        // sitio[0] = row;
                        // sitio[1] = column;
                        // sitio[2] = 7;
                        found = true;
                    }
                }
    
                // diagonal abajo derecha
                if ((row + (word.length() - 1) < matrix.length) && (column + (word.length() - 1) <= matrix[row].length)) {
                    boolean isFound = true;
    
                    for (int letters = 0; letters < word.length(); letters++) {
                        if (word.charAt(letters) != matrix[row + letters][column + letters]) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
                        // sitio[0] = row;
                        // sitio[1] = column;
                        // sitio[2] = 3;
                        found = true;
                    }
                }
    
                // diagonal abajo izquierda
                if ((row + (word.length() - 1) < matrix.length) && (column - (word.length() - 1) >= 0)) {
                    boolean isFound = true;
    
                    for (int letters = 0; letters < word.length(); letters++) {
                        if (word.charAt(letters) != matrix[row + letters][column - letters]) {
                            isFound = false;
                            break;
                        }
                    }
                    if (isFound) {
                        // sitio[0] = row;
                        // sitio[1] = column;
                        // sitio[2] = 5;
                        found = true;
                    }
                }
    
            }
        }
    
        return found;
    }
}
