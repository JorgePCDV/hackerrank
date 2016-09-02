package com.pcdv;

import java.util.ArrayList;
import java.util.Scanner;

public class NonDivisibleSubset {
    int n;
    int k;
    boolean iterationFlag = true;
    ArrayList<Integer> arr = new ArrayList<Integer>();
    ArrayList<Integer> solutionArr = new ArrayList<Integer>();

    public void addValuesToArray(Scanner scan) {
        while(scan.hasNextInt()) {
            arr.add(scan.nextInt());
        }
    }

    public void createFirstArray() {
        for(int a = 0; a < arr.size(); a++) {
            for (int b = 1; b < arr.size(); b++) {
                if((arr.get(a) + arr.get(b)) % k == 0) {
                    solutionArr.add(arr.get(a));
                    solutionArr.add(arr.get(b));
                    arr.remove(a);
                    arr.remove(b);
                    return;
                }
            }
        }
    }

    public void calculateSolutionArray(int numberToCompare) {
        for(int solutionNumber : solutionArr) {
            if ((numberToCompare + solutionNumber) % k != 0) {
                return;
            }
        }
        solutionArr.add(numberToCompare);
        arr.remove(numberToCompare);
        iterationFlag = true;
    }

    public static void main(String[] args) {
        NonDivisibleSubset solution = new NonDivisibleSubset();

        Scanner scan = new Scanner(System.in);
        solution.n = scan.nextInt();
        solution.k = scan.nextInt();

        if(solution.k == 0) {
            System.out.println(0);
            System.exit(0);
        }

        solution.addValuesToArray(scan);
        solution.createFirstArray();

        while (solution.iterationFlag == true) {
            solution.iterationFlag = false;
            if (solution.arr.isEmpty()) {
                break;
            }
            for(int numberToCompare : solution.arr) {
                solution.calculateSolutionArray(numberToCompare);
            }
        }

        System.out.println(solution.solutionArr.size());
    }
}
