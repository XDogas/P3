package aula06.Ex2;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public interface ListsProcess {

	public static <T> List<T> filter(List<T> lista, Predicate<T> tester) {
		List<T> tmp = new LinkedList<T>();
		for(T t : lista)
			if(tester.test(t)) tmp.add(t);
		return tmp;
	}
	

}
