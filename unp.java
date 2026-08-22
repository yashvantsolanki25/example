import java.util.*;

class unp
{
    sealed interface Operation permits Add, Mult, Sub, Div {}

    record Add(int left, int right) implements Operation {
        public String toString() {
            return left + " + " + right;
        }
    }

    record Mult(int left, int right) implements Operation {
        public String toString() {
            return left + "*" + right;
        }
    }

    record Sub(int left, int right) implements Operation {
        public String toString() {
            return left + " - " + right;
        }
    }

    record Div(int left, int right) implements Operation {
        public String toString() {
            return left + "/" + right;
        }
    }

    public static boolean naturalNumber(Operation operation) {
        return switch (operation) {
            case Add _ -> true;
            case Mult _ -> true;
            case Sub(int left, int right) -> left > right;
            case Div(int left, int right) -> left % right == 0;
        };
    }

    public static int resolve(Operation operation) {
        return switch (operation) {
            case Add(int left, int right) -> left + right;
            case Mult(int left, int right) -> left * right;
            case Sub(int left, int right) -> left - right;
            case Div(int left, int right) -> left / right;
        };
    }

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
        /*
var strings = List.of("one", "two", "three", "four");
BiFunction<String, Integer, Integer> indexer = (_, i) -> i;
var result = IntStream.range(0, strings.size())
        .mapToObj(index -> indexer.apply(strings.get(index), index))
        .toList();
System.out.println("result = " + result);
*/
// Pattern Matching with Unnamed Pattern
var operations = List.of(
        new Add(1, 2),
        new Mult(4, 3),
        new Sub(0, 3), new Sub(4, 3),
        new Div(9, 4), new Div(1, 3), new Div(12, 4));
System.out.println("Are the following natural integers?");
operations.forEach(operation -> {
    System.out.println(operation + (
            naturalNumber(operation) ? " = " + resolve(operation): " -> result is not a natural integer"));
});


    }
}