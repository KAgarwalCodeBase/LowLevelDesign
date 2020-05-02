import java.util.HashMap;
class Test {
	public static void main(String args[]){
		HashMap<Integer,Boolean> hash = new HashMap<Integer,Boolean>();
		hash.put(1,true);
		hash.put(2,false);
		hash.put(3,true);
		System.out.println(hash);
		if (hash.containsValue(1))
			System.out.println(hash.get(1));
		System.out.println(hash.containsValue(5));
	}
}