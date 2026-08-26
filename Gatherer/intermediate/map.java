import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

class map
{
   static <T, R> Gatherer<T, ?, R> mapFilter(
         Function<? super T, ? extends R> mapper,
         Predicate<? super R> filter) {

      return Gatherer.of(
            (_, element, downstream) -> {
               R mappedElement = mapper.apply(element);
               if (filter.test(mappedElement)) {
                  return downstream.push(mappedElement);
               }
               return true;
            });
   }

   public static void main(String[] args) {
      // Map Filter Gatherer
      var stream = Stream.of("one", "two", "three", "four", "five");
      var result = stream
            .gather(mapFilter(String::length, length -> length > 3))
            .toList();
      System.out.println("result = " + result);

    }
}