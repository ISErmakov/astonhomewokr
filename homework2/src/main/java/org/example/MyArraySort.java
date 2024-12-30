package org.example;

public class MyArraySort<T> {

    public static <T extends Comparable<T>> void sort(MyArrayList<T> array, int leftindex, int rightindex){
        if (array.size() == 0 || leftindex >=rightindex) return;

        T pivot = array.get((leftindex+rightindex)/2);

        int leftmarkerindex = leftindex;
        int rightmarkerindex = rightindex;

        while (leftmarkerindex <= rightmarkerindex){
            while (array.get(leftmarkerindex).compareTo(pivot) < 0) leftmarkerindex++;
            while (array.get(rightmarkerindex).compareTo(pivot) > 0) rightmarkerindex--;

            if (leftmarkerindex <= rightmarkerindex) {
                T swap = array.get(leftmarkerindex);
                array.set(array.get(rightmarkerindex),leftmarkerindex);
                array.set(swap,rightmarkerindex);

                leftmarkerindex++;
                rightmarkerindex--;
            }
        }
        if (leftindex < rightmarkerindex) sort(array,leftindex,rightmarkerindex);
        if (rightindex > leftmarkerindex) sort(array,leftmarkerindex,rightindex);
    }


    public static <T extends Comparable<T>> void sort(MyArrayList<T> array){
        sort(array, 0, array.size()-1);
    }
}
