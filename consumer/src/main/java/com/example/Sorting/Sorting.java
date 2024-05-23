package com.example.Sorting;

public class Sorting {


    public static void main(String[] args) {
        int []a ={41,12,51,63,43,75,14,88};


        bubbleSort(a);

    }


    //冒泡排序,将大的往后排,从前往后一个一个比较
    public static void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }

        for (int i = 0; i < arr.length-1; i++) {  //arr.length-1因为需要将元素与前面一个元素进行比较
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }


    //选择排序,将大的往后排,将当前元素与后面元素依次比较
}
