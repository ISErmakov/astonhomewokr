package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
        ArrayList<Integer> list= new ArrayList<>();
        MyArrayList<String> mylist = new MyArrayList<String>(10);
        Integer[] array = new Integer[1000000];
        for (int i = 0; i < 1000000; i++) {
            array[i] = i;
        }
        MyArrayList<Integer> myarray = new MyArrayList<>(List.of(array));
        System.out.println(myarray.size());
        // System.out.println(myarray);

        myarray.add(400);
        System.out.println(myarray.size());
        //System.out.println(myarray);

        myarray.add(200,50);
        System.out.println(myarray.size());
        //System.out.println(myarray);

        System.out.println(myarray.get(22));

        myarray.remove(22);
        System.out.println(myarray.size());
        //System.out.println(myarray);

        myarray.add(15,5);
        MyArraySort.sort(myarray);
        System.out.println(myarray.size());
        //System.out.println(myarray);


    }
}