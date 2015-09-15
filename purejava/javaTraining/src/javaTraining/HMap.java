package javaTraining;

public class HMap<K, V> {
	private double loadFactor = 0.75;

	private Entry<K, V>[] table;

	private int elemCount;

	public static class Entry<K, V> {
		K key;
		V value;
		Entry<K, V> next;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
			next = null;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		// contructors, getters and setters below
	}

	
	public HMap() {
		table = new Entry[16];
	}
	
	/**
	 * Insert your super-mega-hash-function below :)
	 */
	static int hash(int h) {
		h ^= (h >>> 20) ^ (h >>> 12);
		return h ^ (h >>> 7) ^ (h >>> 4);
	}

	public void put(K key, V value) {
		if (elemCount > table.length * loadFactor)
			resize();
		int index = hash(key.hashCode()) % table.length;
		if (table[index] == null)
			table[index] = new Entry(key, value);
		else {
			Entry cur = table[index];
			while (true) {
				if (cur.getKey().equals(key)) {
					cur.setValue(value);
					break;
				}
				if (cur.next == null)
					break;
				cur = cur.next;
			}
			cur.next = new Entry(key, value);
		}
	}

	public V get(K key) {
		int index = hash(key.hashCode()) % table.length;
		if (table[index] == null)
			return null;
		else {
			Entry cur = table[index];
			while (true) {
				if (cur.getKey().equals(key)) {
					return (V) cur.getValue();
				}
				if (cur.next == null)
					break;
				cur = cur.next;
			}
			return null;
		}
	}

	public void resize() {
		int newSize = (int) (table.length * 1.5);
		Entry[] newTable = new Entry[newSize];
		for (int i = 0; i < table.length; i++)
			newTable[i] = table[i];
		table = newTable;
	}


	public static void main(String[] args) {
		HMap<Integer, Integer> map = new HMap<Integer, Integer>();
		map.put(0, 2);
		map.put(1, 4);
		map.put(1, 2);
		Integer x = map.get(1);
		System.out.println(x);
	}
	
	
}
