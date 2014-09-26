package com.day10;

abstract class SortInt {

    private int[] value;

    protected abstract void sorting();

    public void sort(int[] value) {
        this.value = value;
        sorting();
    }

    public int length() {
        if(value==null)
            return 0;
        return value.length;
    }

    protected int compare(int i, int j) {
        if(value[i]==value[j])
            return 0;
        else if(value[i]>value[j])
            return 1;
        else
            return -1;
    }

    protected final void swap(int i, int j) {
        int temp;
        temp = value[i];
        value[i] = value[j];
        value[j] = temp;
    }

    public void print() {
       if(value==null)
           return;
        for(int n : value)
            System.out.printf("%5d", n);
        System.out.println();
    }

}

class SortTest extends SortInt {

    @Override
    protected void sorting() {
        for(int i=0; i<length()-1; i++) {
            for(int j=i+1; j<length(); j++) {
                if(compare(i, j)>0)
                    swap(i, j);
            }
        }
    }

}

public class Test5 {

    public static void main(String[] args) {

        int[] data = {15, 2, 37, 422, 58, 6, 89 ,9 ,10};

        SortTest st = new SortTest();

        st.sort(data);
        st.print();

    }

}
