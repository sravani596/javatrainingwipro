package streamAPI;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo2 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        
        list.add("Apple");
        list.add("Banana");
        list.add("guava");
        list.add("dragonfruit");
        list.add("peech");
        
        // Stream to print all strings
        Stream<String> stream1 = list.stream();
        stream1.forEach( (String str) -> { 
            System.out.println(str);
        });
        
        // Stream to filter strings with length greater than 5 and print them in uppercase
        Stream<String> stream2 = list.stream();
        System.out.println("Filter and print in uppercase:");
        
        stream2.filter((String str) -> str.length() > 5)
               .map(String::toUpperCase)
               .forEach((String str) -> { 
                   System.out.println(str);
               });

        // Stream to print all strings in lowercase along with their lengths
        Stream<String> stream3 = list.stream();
        System.out.println("Print in lowercase with lengths:");

        stream3.map((String str) -> str.toLowerCase() + " (Length: " + str.length() + ")")
               .forEach((String str) -> { 
                   System.out.println(str);
               });
    }
}