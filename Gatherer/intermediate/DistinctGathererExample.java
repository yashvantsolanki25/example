import java.util.HashSet;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

public class DistinctGathererExample {

    // Custom Distinct Gatherer
    static <T> Gatherer<T, ?, T> distinct() {
        return Gatherer.ofSequential(
            () -> new HashSet<T>(), // state supplier (HashSet to track seen elements)
            (set, element, downstream) -> {
                // Only push element downstream if it's not already in the set
                if (set.add(element)) {
                    return downstream.push(element);
                }
                return true; // continue processing
            }
        );
    }

    public static void main(String[] args) {
        // Input stream with duplicates
        var stream = Stream.of(1, 1, 2, 2, 2, 3, 4, 4, 4, 5);

        // Apply distinct gatherer
        var result = stream.gather(distinct()).toList();

        // Print result
        System.out.println("result = " + result);
    }
}
