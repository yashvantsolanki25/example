import java.util.*;
import java.util.function.*;
import java.util.stream.IntStream;
class unp
{
    public static void main(String[] args)
    {
        // Consumer with Unnamed Pattern
/* List<String> strings = List.of("one", "two", "three");
Consumer<String> notInterested = _ -> System.out.println("I'm not interested in this argument");
strings.forEach(notInterested);
*/
     // Function with Unnamed Pattern
     /*
List<String> strings = List.of("1", "11", "111");
Function<String, Integer> constantLength = _ -> 3;
var result = strings.stream()
        .map(constantLength)
        .toList();
System.out.println("result = " + result); */
        // BiFunction with Unnamed Pattern
var strings = List.of("one", "two", "three", "four");
BiFunction<String, Integer, Integer> indexer = (_, i) -> i;
var result = IntStream.range(0, strings.size())
        .mapToObj(index -> indexer.apply(strings.get(index), index))
        .toList();
System.out.println("result = " + result);

    }
}