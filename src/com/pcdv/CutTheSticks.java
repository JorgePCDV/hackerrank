package com.pcdv;

import java.util.Arrays;
import java.util.Scanner;

public class CutTheSticks {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] array = new int[n];
        int min;
        int sticksLeft = 1;
        for(int i = 0; i < array.length; i++) {
            array[i] = in.nextInt();
        }

        while(sticksLeft > 0) {
            Arrays.sort(array);
            min = array[n-1];
            sticksLeft = 0;
            for(int j = 0; j < array.length; j++) {
                if (array[j] > 0 && array[j] < min) {
                    min = array[j];
                }
            }
            if (min <= 0) {
                System.exit(0);
            }
            for(int k = 0; k < array.length; k++) {
                array[k] = array[k] - min;
                if(array[k] >= 0) {
                    sticksLeft++;
                }
            }
            if(sticksLeft > 0) {
                System.out.println(sticksLeft);
            }
        }
    }
}
