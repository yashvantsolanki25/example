
import java.util.stream.Gatherer;
import java.util.stream.Stream;

class Lmit
{

   static <T> Gatherer<T, ?, T> limit(long limit) {
   return Gatherer.ofSequential(
      () -> new Object() {
         long counter = 0L;
      },
      (counter, element, downstream) -> {
         if (counter.counter >= limit) {
            return false;
         } else {
            counter.counter++;
            return downstream.push(element);
         }
      }
   );
}
    public static void main(String[] args){
        // Limit Gatherer

var stream = Stream.of(1, 2, 3, 4, 5);
var result = stream.gather(limit(3L)).toList();
System.out.println("result = " + result);

    }
}