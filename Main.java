import java.util.Scanner;

class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Geben sie die gewuenschte Array-Groesse n ein: ");
        int n = sc.nextInt();
		/* 
        Aufgabe: Erstelle hier ein Array mit dem Namen SuchArray und der Größe n.
        Weise dann dem Array an der i-ten Stelle einen Wert k zu, der linear zu i ist (bspw. k=i, k=3i oder k=i+2).
		Das Ergebnis soll ein sortiertes Array sein, bei welchem die Zahlen in aufsteigender Folge sind.
        Beobachte nun wie sich die durchschnittliche Laufzeit des jeweiligen Algorithmus in Abhängigkeit von der Arraygröße n verändert.
        */
        System.out.println ("Durchschnittliche Suchzeit Lineare Suche: " + avgTimeOfSearchNs('l', SuchArray) + " ns");
        System.out.println ("Durchschnittliche Suchzeit Binaere Suche: " + avgTimeOfSearchNs('b', SuchArray) + " ns");
        sc.close();
	}
	
// return: long durchschnittliche Suchzeit in ns
// input: 1. char Suchalgorithmus: 'l' - Lineare Suche; 'b' - Binäre Suche
//        2. int[] Array, in welchem gesucht werden soll.
    public static long avgTimeOfSearchNs(char chosenMode, int [] Array){
        long before, after, x;
        if (chosenMode=='l'){
            before = System.nanoTime();
            for (int i: Array){
            	x = linearSearch(Array,i);
            }
            after = System.nanoTime();
        }else if (chosenMode=='b'){
            before = System.nanoTime();
            for(int i: Array){
                x = binarySearch(Array, i);
            }
            after = System.nanoTime();
        }else{
            System.out.println("Modus nicht vorhanden");
            return 0;
        }
      return (after-before)/Array.length;
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
