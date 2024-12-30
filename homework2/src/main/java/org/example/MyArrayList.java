package org.example;

import java.util.*;

public class MyArrayList<E> {
    //размер MyArrayList
    private int size;
    //максимальный размер MyArrayList
    private int capacity = 15;
    //собственно массив элементов
    private E[] elementData;

    //массив с нулевым количеством элементов
    private static final Object[] EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_SIZE = 10;

    public int size() {
        return this.size;
    }
    //конструктор с начальным размером
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.size = initialCapacity;
            this.capacity = initialCapacity;
            this.elementData = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = (E[]) EMPTY_ELEMENTDATA;
            this.size = 0;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    //конструктор пустого
    public MyArrayList() {
        this.size = 0;
        new MyArrayList(size);
    }

    public MyArrayList(Collection<? extends E> c) {
        Object[] a = c.toArray();
        if ((size = a.length) != 0) {
            elementData = (E[]) Arrays.copyOf(a, size, Object[].class);
            capacity = size;
        } else {
            // replace with empty array.
            elementData = (E[]) EMPTY_ELEMENTDATA;
        }

    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (elementData[i] != null){
                sb.append(elementData[i].toString());
                sb.append(" ");
            }
            else sb.append("null ");
        }
        return sb.toString();
    }



    //Возврат элемента по индексу
    public E get(int index) {
        if ((index >= size) || (index < 0)) throw new ArrayIndexOutOfBoundsException();
        return elementData[index];
    }

    // расширение динимического массива
    private void changeCapacity() {
        E[] newElementData = (E[]) new Object[capacity * 3 / 2];
        for (int i = 0; i < capacity; i++) {
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
        capacity = capacity * 3 / 2;
    }

    // удаление элемента по индексу
    public E remove(int index) {
        E retormElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i+1];
        }
        size--;
        return retormElement;
    }

    //добавление элемента по  индексу
    public void add (E element, int index){
        if (index == capacity) {
            changeCapacity();
        }
        for (int i = size; i > index ; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = element;
        size++;
        }

    //добавление элемента по  индексу
    public void set (E element, int index){
        elementData[index] = element;
    }

    public void clear(){
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    //Добавление элемента в конец списка
    public void add(E element) {
        add(element, size);
    }

}
