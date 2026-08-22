import java.util.List;
import java.util.function.Consumer;

class unp
{
    public static void main(String[] args)
    {
        // Consumer with Unnamed Pattern
List<String> strings = List.of("one", "two", "three");
Consumer<String> notInterested = _ -> System.out.println("I'm not interested in this argument");
strings.forEach(notInterested);
    }
}