package com.example.shbae.tddexample;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by shbae on 2017-12-04.
 */

public class SortTest {
    @Test
    public void sortings() throws Exception {
        assertSorted(intList(), intList());
        assertSorted(intList(1), intList(1));
        assertSorted(intList(2, 1), intList(1, 2));
//        assertSorted(intList(1, 3, 2), intList(1, 2, 3));
//        assertSorted(intList(3, 2, 1), intList(1, 2, 3));
        assertSorted(intList(2, 1, 3), intList(1, 2, 3));
        assertSorted(intList(2, 3, 1), intList(1, 2, 3));
        assertSorted(intList(3, 1, 2), intList(1, 2, 3));
        assertSorted(intList(1, 3, 2), intList(1, 2, 3));
        assertSorted(intList(3, 1, 2, 2), intList(1, 2, 2, 3));
    }

    private void assertSorted(List<Integer> unsorted, List<Integer> sorted) {
        assertThat(sort(unsorted), is(sorted));
    }

    private List<Integer> intList(Integer... ints) {
        return Arrays.asList(ints);
    }

    private List<Integer> sort(List<Integer> list) {
        List<Integer> sorted = new ArrayList<>();
        if (list.size() == 0)
            return list;
        else {
            List<Integer> l = new ArrayList<>();
            int m = list.get(0);
            List<Integer> h = new ArrayList<>();
            for (int i: list.subList(1, list.size())) {
                if (i < m)
                    l.add(i);
                else
                    h.add(i);
            }
            if (l != null) sorted.addAll(sort(l));
            sorted.add(m);
            if (h != null) sorted.addAll(sort(h));
        }
        return sorted;

//        for (int size = list.size(); size > 0; size--)
//            for (int index = 0; index < list.size() - 1; index++)
//                if (outOfOrder(list, index))
//                    swap(list, index);
//        return list;
    }

    private void swap(List<Integer> list, int index) {
        int temp = list.get(index);
        list.set(index, list.get(index + 1));
        list.set(index + 1, temp);
    }

    private boolean outOfOrder(List<Integer> list, int index) {
        return list.get(index) > list.get(index + 1);
    }
}
