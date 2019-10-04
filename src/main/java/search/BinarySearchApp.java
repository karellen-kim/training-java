package search;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static utils.DebugUtils.print;

public class BinarySearchApp {
    public static void main(String[] args) {
        List<Integer> list = Arrays.<Integer>asList(1, 10, 5);
        Collections.sort(list);
        print(list); // [1, 5, 10]

        print(Collections.binarySearch(list, 5)); // 1
        print(Collections.binarySearch(list, 2)); // -2 : -((insert_position) + 1)
        print(Collections.binarySearch(list, 15)); // -4
    }
}
