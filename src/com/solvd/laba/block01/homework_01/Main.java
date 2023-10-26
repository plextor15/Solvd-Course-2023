package com.solvd.laba.block01.homework_01;

import java.util.Random;

public class Main {public static void main(String[] args){
    // -- Print arguments --
    System.out.println("\nPassed arguments:");
    for (String argument : args) {
        System.out.println(argument);
    }

    // -- Sort Part --
    System.out.println("\n\nBubble Sort:");
    //int[] nums = {5, 2, 15, 4, 100, 0, 20}

    final int arrsize = 5;
    int[] nums = new int[arrsize];
    for (int i=0; i < arrsize; i++)
    {
        nums[i] = new Random().nextInt(99);
    }

    System.out.print("Not sorted: ");
    for (int num : nums) {
        System.out.print(num + ",");
    }

    bubbleSorting(nums);
    System.out.print("\nSorted: ");
    for (int num : nums) {
        System.out.print(num + ",");
    }
}

    public static void bubbleSorting(int[] numbers){
        int tmp;
        for (int i=0; i < numbers.length-1; i++){
            for (int j=0; j < numbers.length-1-i; j++){
                if (numbers[j+1] < numbers[j]){
                    tmp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1] = tmp;
                }
            }
        }
    }
}
