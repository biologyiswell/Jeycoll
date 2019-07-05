package test.io.github.biologyiswell.jeycoll;

import java.util.HashMap;
import java.util.Map;

import io.github.biologyiswell.jeycoll.Jeycoll;

/**
 * Test about {@link Jeycoll#spliceMap(Map, Object, Object)}.
 * 
 * @author biologyiswell
 * @since 1.0
 */
public class TestSpliceMap {
	
	public static void main(String[] args) {
		final Map<String, Integer> map = new HashMap<>();
		map.put("a", 1);
		map.put("b", 2);
		map.put("c", 3);
		map.put("d", 4);
		map.put("e", 5);
		map.put("f", 6);
		map.put("g", 7);
		map.put("h", 8);
		map.put("i", 9);
		map.put("j", 10);
		
		final Map<String, Integer> spliceMap = Jeycoll.spliceMap(map, "d", "g");
		
		System.out.println(spliceMap); // Expect: {d=4, e=5, f=6, g=7}
	}
}
