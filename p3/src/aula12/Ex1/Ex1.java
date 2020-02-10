package aula12.Ex1;

import static java.lang.System.out;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
//import java.lang.reflect.Type;
//import java.util.LinkedList;
//import java.util.List;
import java.util.Scanner;

public class Ex1 {
	
	public static final Scanner in = new Scanner(System.in);
	static int numConstructors = 0;

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		out.print("Nome da Class: ");
		//String className =  in.nextLine();
		String className = "aula11.Ex2.Circulo";
		Class<?> sc = Class.forName(className);
		caracteristicasClass(sc);

//		out.println("\na) Criar objeto");
//		
//		List<Object> objects = new LinkedList<>();
//		Constructor<?>[] cons = sc.getConstructors();
//		int c = -1;
//		
//		out.println("\tEscolha do construtor:");
//		printConstructors(sc);
//		while (c < 0 || c > cons.length) {
//			out.print("\tOpção: ");
//			c = in.nextInt();
//		}
//		Constructor<?> selectedConstructor = cons[c];
//		Type[] types = selectedConstructor.getGenericParameterTypes();
//		Object[] arguments = new Object[types.length];
//
//		in.skip("\n");
//		for (int i = 0; i < types.length; i++) {
//			out.print(types[i].getTypeName() + " -> ");
//			arguments[i] = primitiveToWrapper(types[i].getTypeName(), in.nextLine());
//		}
//
//		Object obj = null;
//
//		obj = selectedConstructor.newInstance(arguments);
//		objects.add(obj);
	}



//	private static Object primitiveToWrapper(String typeName, String nextLine) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private static void caracteristicasClass(Class<?> sc) throws ClassNotFoundException {
		
		
		out.println("\nCaracterísticas da Class: ");
		out.println("Name = " + sc.getName());
		out.println("SimpleName = " + sc.getSimpleName());
		out.println("CanonicalName = " + sc.getCanonicalName());
		
		out.println("\ninterfaces: ");
		for(Class<?> ic : sc.getInterfaces()) {
			out.println(ic.getClass().getName());
		}
		
		out.println("\nsuperclasses: ");
		out.println(sc.getSuperclass().getName());
		
		out.println("\nconstrutores: ");
		//printConstructors(sc);
		for(Constructor<?> c : sc.getConstructors()) {
			out.println(c);
		}
				
		out.println("\nmétodos: ");
		for(Method m : sc.getDeclaredMethods()) {
			out.println(m);
		}
		
		out.println("\natributos: ");
		for(Field f : sc.getDeclaredFields()) {
			out.println(f);
		}
	}

	@SuppressWarnings("unused")
	private static void printConstructors(Class<?> sc) {
		int i = 0; 
		for(Constructor<?> c : sc.getConstructors()) {
			i++;
			out.println("\t" + i + ": " + c);
		}
		numConstructors = i;
	}
	
	

}
