package javaTraining;

public class HMapMy<K, V> {

	private static class HMapEntry<K, V> {
		private K key;
		private V value;
		private HMapEntry<K, V> next;
		
		public HMapEntry(K key, V value) {
			this.setKey(key);
			this.setValue(value);
		}

		public K getKey() {
			return key;
		}

		public void setKey(K key) {
			this.key = key;
		}

		public V getValue() {
			return value;
		}

		public void setValue(V value) {
			this.value = value;
		}

		public HMapEntry<K, V> getNext() {
			return next;
		}

		public void setNext(HMapEntry<K, V> next) {
			this.next = next;
		}
		
	}
	
	
	HMapEntry[] table;
	float loadFactor = 0.75f;
	int elementsCounter;
	int DEFAULT_CAPACITY = 16;
	int capacity = DEFAULT_CAPACITY;
	
	public HMapMy() {
		table = new HMapEntry[capacity];
		elementsCounter = 0;
	}
	
	static int hash(int hashCode) {
		hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
		return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
	}
	
	public void put(K key, V value) {
		int index = hash(key.hashCode()) % capacity;
		if (capacity * loadFactor < elementsCounter) {
			resize();
		}
		
		HMapEntry<K, V> insertion = new HMapEntry<K, V>(key, value);
		
		if (table[index] == null) {
			table[index] = insertion;
		} else {
			HMapEntry<K, V> entry = table[index];
			while (true) {
				if (entry.getKey().equals(key)) {
					entry.setValue(value);
					break;
				}
				if (entry.next == null)
					break;
				entry = entry.next;
			}
			entry.next = insertion;
		}
	}
	
	public V get(K key) {
		int index = hash(key.hashCode()) % capacity;
		
		if (table[index] == null) {
			return null;
		} else {
			HMapEntry<K, V> entry = table[index];
			while (true) {
				if (entry.getKey().equals(key)) {
					return entry.getValue();
				}
				if (entry.next == null)
					return null;
				entry = entry.next;
			}
		}
		
	}
	
	private void resize() {
		int newSize = (int) (1.5f * capacity);
		HMapEntry[] newTable = new HMapEntry[newSize];
		System.arraycopy(table, 0, newTable, 0, capacity);
		table = newTable;
	}
	
	
	
	
	public static void main(String[] args) {

		HMapMy<Integer, Integer> map = new HMapMy<Integer, Integer>();
		map.put(0, 2);
		map.put(1, 4);
		map.put(1, 2);
		Integer x = map.get(1);
		System.out.println(x);
		
	}

}
