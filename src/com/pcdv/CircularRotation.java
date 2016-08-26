package com.pcdv;

import java.io.*;
import java.util.*;

public class CircularRotation {
    public static int[] rotateArray(int[] array, int rotations) {
        // int[] rotatedArray = new int[array.length];
        // rotatedArray = System.arraycopy(array, 0, rotatedArray, 0, array.length);
        for(int i = 0; i < rotations; i++) {
            int last = array[array.length - 1];
            for(int j = array.length-2; j >=0 ; j--) {
                array[j+1] = array[j];
            }
            array[0] = last;
        }
        return array;
    }

    public static void findItem(int[] array, int query) {
        System.out.println(array[query]);
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        int nArraySize;
        int kRotations;
        int qQueries;

        Scanner scanner = new Scanner(System.in);
        nArraySize = scanner.nextInt();
        kRotations = scanner.nextInt();
        qQueries = scanner.nextInt();

        int[] array = new int[nArraySize];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }

        int[] rotatedArray;
        array = rotateArray(array, kRotations);

        for(int i = 0; i < qQueries; i++) {
            findItem(array, scanner.nextInt());
        }
    }
}
