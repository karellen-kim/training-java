package collections;

import utils.Tuple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static utils.Tuple.tuple;


/**
 * https://docs.oracle.com/javase/6/docs/technotes/guides/collections/overview.html
 */
public class ArraysApp {
    /**
     * 초기화
     */
    public static void initial() {

        List<Integer> toArrays = Arrays.asList(1, 10, 5);
        ArrayList<Integer> toMutableList = new ArrayList<>(toArrays);
        toMutableList.add(6);
        System.out.println(toMutableList);

        int[] list = {1, 10, 5};
        List<Integer> toList = Arrays.stream(list).boxed().collect(Collectors.toList());
        toList.add(20);
        System.out.println(toList);
    }

    /**
     * 변환
     */
    public static void convert() {
        int[] list = { 1, 2, 3 };
        List<Integer> toList = Arrays.stream(list).boxed().collect(Collectors.toList());
        Integer[] toWrapperArray = toList.toArray(new Integer[]{});
        int[] toPrimitiveArray = toList.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * ZipWithIndex
     */
    public static void zipWithIndex() {
        List<Character> list = Arrays.asList('a', 'b', 'c');

        List<Tuple<Integer, Character>> listWithIndex = IntStream.range(0, list.size())
                .mapToObj((idx) -> tuple(idx, list.get(idx)))
                .collect(Collectors.toList());

        System.out.println(listWithIndex);
    }

    /**
     * join
     */
    public static void join() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        List<String> convertedList = list.stream().map(Object::toString).collect(Collectors.toList());
        String string_join = String.join("\n", convertedList);
        System.out.println(string_join);

        String collectors_joining = list.stream().map(Object::toString).collect(Collectors.joining("\n"));
        System.out.println(collectors_joining);

        String collectors_joining_with_prefix = list.stream().map(Object::toString).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collectors_joining_with_prefix);
    }

    public static void main(String[] args) {
        initial();
        convert();
        zipWithIndex();
        join();
    }
}
