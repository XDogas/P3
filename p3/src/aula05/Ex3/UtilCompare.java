package aula05.Ex3;

//import java.util.Arrays;

public class UtilCompare {
	
	@SuppressWarnings("unchecked")
	public static <T> Comparable<T> findMax(Comparable<T>[] a) {
		int maxIndex = 0;
		for (int i=1; i<a.length; i++)
			if (a[i] != null && a[i].compareTo((T) a[maxIndex]) > 0)
				maxIndex = i;
		return a[maxIndex];
		}
	
	@SuppressWarnings("unchecked")
	public static <T> void sortArray(Comparable<T>[] a) {
//		Arrays.sort(a);		// nesta alternativa não é necessário @SuppressWarnings("unchecked")
//OU\\
		Comparable<T> tmp;
		for(int i=0; i<a.length-1; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i].compareTo((T) a[j]) > 0) {
					tmp = a[j];
					a[j]=a[i];
					a[i]=tmp;
				}
			}
		}
	}
	
}
