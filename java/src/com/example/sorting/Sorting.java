package com.example.sorting;

import java.util.Arrays;

public interface Sorting {
    <T> void sort(T[] arr);

    <T> void swap(int val1, int val2, T[] arr);

    default <T> void display(T[] arr, String extraMsg) {
        System.err.format("%s%s\n", extraMsg != null && !extraMsg.equals("") ? extraMsg + " : " : "", Arrays.toString(arr));
    }

    default <T> void display(T[] arr) {
        display(arr, "");
    }
}
