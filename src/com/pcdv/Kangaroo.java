package com.pcdv;

import java.util.Scanner;

public class Kangaroo {
    public static int willTheyMeet(int x1, int v1, int x2, int v2) {
        if(v2 >= v1) {
            System.out.println("NO");
            System.exit(0);
        }
        int distanceDifference = x2 - x1;
        int jumpDifference = v1 - v2;

        int modulo = distanceDifference % jumpDifference;
        return modulo;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x1 = in.nextInt();
        int v1 = in.nextInt();
        int x2 = in.nextInt();
        int v2 = in.nextInt();

        int meetingResult = willTheyMeet(x1, v1, x2, v2);

        if(meetingResult == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
