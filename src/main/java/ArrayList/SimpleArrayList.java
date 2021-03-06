package ArrayList;

import java.util.Iterator;

public class SimpleArrayList <E> implements Simple<E>{

    public static void main(String[] args) {
        Simple <String> strings = new SimpleArrayList<String>();

        strings.add("1111");
        strings.add("2222");
        strings.add("3333");
        strings.add("4444");

        System.out.println(strings.get(0));
        System.out.println(strings.size());
        strings.update(0, "55555");
        System.out.println(strings.get(2));

        for (int i=0; i<strings.size(); i++){
            System.out.println(strings.get(i));
        }

        strings.delete(2);
        System.out.println(strings.get(2));

    }

    private E[] values;

    public SimpleArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex){
            ex.printStackTrace();
        } return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            int amountElemAfterIndex = temp.length - index - 1;
            System.arraycopy(temp, 0, values, 0, index);
            System.arraycopy(temp, index + 1, values, index, amountElemAfterIndex);
        } catch (ClassCastException e){
            e.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayIterator<E>(values);
    }
}
