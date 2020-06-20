package com.example.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSortNaive implements Sorting {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Quick Sort Naive Implementation using JAVA");
        System.err.print("Enter Array that need to be sort (element, must, be, comma, separated): ");
        String i = scanner.nextLine();
        if (i != null) {
            QuickSortNaive quickSortNaive = new QuickSortNaive();
            quickSortNaive.sort(Arrays.stream(i.split(","))
                    .map(String::trim)
                    .filter(val -> !val.equals("")).map(Integer::parseInt).toArray());
        }
    }

    @Override
    public <T> void sort(T[] arr) {
        display(arr);
        int low = 0;
        int high = arr.length - 1;
        Integer[] a = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = (Integer) arr[i];
        }
        quickSort(low, high, a);
    }

    private void quickSort(int left, int right, Integer[] arr) {
        if (right - left <= 0) {
        } else {
            int pivot = arr[right];
            int partitionPoint = partition(left, right, pivot, arr);
            quickSort(left, partitionPoint - 1, arr);
            quickSort(partitionPoint + 1, right, arr);
        }
    }

    @Override
    public <T> void swap(int val1, int val2, T[] arr) {
        T temp = arr[val1];
        arr[val1] = arr[val2];
        arr[val2] = temp;
    }

    int partition(int left, int right, int pivot, Integer[] arr) {
        int leftPointer = left - 1;
        int rightPointer = right;

        while (true) {
            while (arr[++leftPointer] < pivot) {
                //do nothing
            }

            while (rightPointer > 0 && arr[--rightPointer] > pivot) {
                //do nothing
            }

            if (leftPointer >= rightPointer) {
                break;
            } else {
                display(Arrays.asList(arr[leftPointer], arr[right]).toArray(), "Item swapped");
                swap(leftPointer, rightPointer, arr);
            }
        }
        display(Arrays.asList(arr[leftPointer], arr[right]).toArray(), "Pivot swapped");
        swap(leftPointer, right, arr);
        display(arr, "Updated Array");
        return leftPointer;
    }


}