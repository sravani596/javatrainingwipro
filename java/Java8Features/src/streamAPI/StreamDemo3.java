package streamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamDemo3 {
public static void main(String[] args) {
	List<String> list = new ArrayList<String>();
	 list.add("apple");
     list.add("Banana");
     list.add("papaya");
     list.add("guava");
     list.add("Dragonfruit");
     Stream<String> stream1=list.stream();
     stream1.forEach( (String str)->{System.out.println(str);});
}
}