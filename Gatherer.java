import java.util.List;
class Gatherer
{
    public static void main(String[] args)
    {
        System.out.println("Hello, Gatherer!");
        // Filtering Gatherer
var strings = List.of("one", "two", "three", "four", "five");
java.util.stream.Gatherer<String, ?, String> filtering =
   java.util.stream.Gatherer.of(
      (_, element, downstream) -> {
         if (element.length() > 3) {
            return downstream.push(element);
         } else {
            return !downstream.isRejecting();
         }
      });
var result = strings.stream()
   .gather(filtering)
   .toList();
System.out.println("result = " + result);
    }
}