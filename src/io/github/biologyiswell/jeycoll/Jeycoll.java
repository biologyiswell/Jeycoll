package io.github.biologyiswell.jeycoll;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Predicate;

/**
 * Jeycoll,
 * A library that implements an utils
 * relative to Java Collection.
 * 
 * @author biologyiswell
 * @since 1.0
 */
public final class Jeycoll {
	
	private Jeycoll() { // prevent instantiation.
		throw new RuntimeException("Can\'t instantiate Jeycoll.");
	}
	
	// Experimental
	// ...
	
	/**
	 * Splice map relative to start key and an end key.
	 * 
	 * @param <K> the key type of map.
	 * @param <V> the value type of map.
	 * @param map the map.
	 * @param startKey the start key.
	 * @param endKey the end key.
	 * @return the splice map.
	 * 
	 * @since 1.0
	 */
	@Experimental public static <K, V> Map<K, V> spliceMap(final Map<K, V> map, final K startKey, final K endKey) {
		if (!map.containsKey(startKey)) throw new IllegalStateException("Start key not found");
		if (!map.containsKey(endKey)) throw new IllegalStateException("End key not found");
		final Map<K, V> newMap = new HashMap<>();
		boolean push = false;
		for (final Entry<K, V> entry : map.entrySet()) {
			// Avoid a scheme of if-condition that is
			// if (entry.getKey() == startKey || entry.getKey() == endKey) push = !push;
			// This will cause the non push about the end key.
			if (entry.getKey() == startKey) push = true;
			if (push) newMap.put(entry.getKey(), entry.getValue());
			if (entry.getKey() == endKey) push = false;
		}
		return newMap;
	}
	
	/**
	 * Translate an object array to a map, this object array
	 * must have an even length to can complete the key-pairs.
	 * 
	 * @param <K> the key type.
	 * @param <V> the value type.
	 * @param array the array.
	 * @return the translated map.
	 * 
	 * @since 1.0
	 */
	@SuppressWarnings("unchecked")
	@Experimental public static <K, V> Map<K, V> toMap(final Object... array) {
		if (array.length % 2 != 0) throw new IllegalStateException("Array must contains all of your key-pairs");
		final Map<K, V> map = new HashMap<>();
		final int size = array.length;
		for (int i = 0; i < size; i += 2) {
			map.put((K) array[i], (V) array[i + 1]);
		}
		return map;
	}
	
	// Fill
	// ...
	
	/**
	 * Fill all indexes of list with an one value.
	 * 
	 * @param <T> the type of list.
	 * @param src the source list.
	 * @param value the value of will fill list.
	 * 
	 * @since 1.0
	 */
	public static <T> void fill(final List<T> src, final T value) {
		final int size = src.size();
		for (int i = 0; i < size; i++) {
			src.set(i, value);
		}
	}
	
	/**
	 * Fill all keys of map with an one value.
	 * 
	 * @param <K> the key type of map.
	 * @param <V> the value type of map.
	 * @param src the map.
	 * @param value the value that will fill.
	 */
	public static <K, V> void fill(final Map<K, V> src, final V value) {
		for (final Entry<K, V> entry : src.entrySet()) {
			entry.setValue(value);
		}
	}
	
	/**
	 * Fill all indexes of list with an one value
	 * in indexes that pass by the filter.
	 * 
	 * @param <T> the type of the list.
	 * @param src the source list.
	 * @param value the value of will fill list.
	 * @param indexFilter the index filter.
	 * 
	 * @since 1.0
	 */
	public static <T> void fill(final List<T> src, final T value, final Predicate<Integer> indexFilter) {
		final int size = src.size();
		for (int i = 0; i < size; i++) {
			if (indexFilter.test(i)) {
				src.set(i, value);
			}
		}
	}
	
	/**
	 * Fill all indexes of list with an one value
	 * in values that pass by the filter.
	 * 
	 * @param <T> the type of the list.
	 * @param src the source list.
	 * @param value the value of will fill list.
	 * @param valueFilter the value filter.
	 * 
	 * @since 1.0
	 */
	public static <T> void fillByValue(final List<T> src, final T value, final Predicate<T> valueFilter) {
		final int size = src.size();
		for (int i = 0; i < size; i++) {
			if (valueFilter.test(src.get(i))) {
				src.set(i, value);
			}
		}
	}
	
	/**
	 * Fill all keys of map with an one value
	 * in current values that pass by the filter.
	 * 
	 * @param <K> the key type of map.
	 * @param <V> the value type of map.
	 * @param map the map.
	 * @param value the value that will fill the map.
	 * @param valueFilter the value filter.
	 */
	public static <K, V> void fillByValue(final Map<K, V> src, final V value, final Predicate<V> valueFilter) {
		for (final Entry<K, V> entry : src.entrySet()) {
			if (valueFilter.test(entry.getValue())) {
				entry.setValue(value);
			}
		}
	}
	
	/**
	 * Fill all indexes of list with an one value
	 * in next values that pass by the filter. The
	 * next value represents the values represented
	 * by the next index from the current value.
	 * 
	 * @param <T> the type of list.
	 * @param src the source list.
	 * @param value the value of will fill list.
	 * @param valueFilter the value filter.
	 * 
	 * @since 1.0
	 */
	public static <T> void fillByNextValue(final List<T> src, final T value, final Predicate<T> valueFilter) {
		final int size = src.size();
		int index = 0;
		while (index < size - 1) {
			final T nextValue = src.get(index + 1);
			if (valueFilter.test(nextValue)) {
				src.set(index, value);
			}
			index++;
		}
	}
}
