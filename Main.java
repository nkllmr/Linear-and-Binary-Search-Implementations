class Main {
	public static void main(String[] args) {
		int [] Array = {0,2,4,10,20,22,23,24,25,26,27,28,30,55,501,503,670,5000,6767};
		System.out.println(linearSearch (Array,4));
		System.out.println(linearSearch (Array,5));
		System.out.println(binarySearch (Array,4));
		System.out.println(binarySearch (Array,5));

		int [] UnorderedArray = {45,2,67,13,67,13};
		System.out.println(linearSearch(UnorderedArray,2));
		System.out.println(linearSearch(UnorderedArray,13));
	
	}
	public static int linearSearch (int [] Array, int ziel){
		for (int i = 0; i < Array.length; i++){
			if (Array[i] == ziel){
				return i;
			}
		}
		return -1;
	}
	public static int binarySearch (int [] Array, int ziel){
		int left = 0;
		int right = Array.length - 1;
		int mid = (left + right) / 2;
		while (left != right){
			if (Array[mid] == ziel ){
				return mid;
			} 
			if (Array[mid] > ziel){
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			mid = (left + right) / 2;
		}
		if (Array[mid] != ziel) {
			return -1;
		} else{
			return mid;
		}
	}
}
