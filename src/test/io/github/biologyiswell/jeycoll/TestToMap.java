package test.io.github.biologyiswell.jeycoll;

import java.util.Map;

import io.github.biologyiswell.jeycoll.Jeycoll;

/**
 * Test about {@link Jeycoll#toMap(Object...)}.
 * 
 * @author biologyiswell
 * @since 1.0
 */
public class TestToMap {

	public static void main(String[] args) {
		final Object[] array = { "a", 1, "b", 2, "c", 3, "d", 4, "e", 5 };
		final Map<String, Integer> mapFromArray = Jeycoll.toMap(array);
		final Map<String, Integer> mapFromVarArgs = Jeycoll.toMap("a", 1, "b", 2, "c", 3, "d", 4, "e", 5);
		
		System.out.println(mapFromArray); // Expect: {a=1, b=2, c=3, d=4, e=5}
		System.out.println(mapFromVarArgs); // Expect: {a=1, b=2, c=3, d=4, e=5}
	}
}
