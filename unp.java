import java.util.List;
import java.util.function.Function;
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
List<String> strings = List.of("1", "11", "111");
Function<String, Integer> constantLength = _ -> 3;
var result = strings.stream()
        .map(constantLength)
        .toList();
System.out.println("result = " + result);

    }
}