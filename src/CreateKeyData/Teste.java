package CreateKeyData;

import SortAlgorithms.ShellSort;
import structures.DoubleList;
import structures.ListInterface;

public class Teste {

	public static void main(String[] args) {
		ListInterface<Integer> lista = new DoubleList<Integer>(); 
		lista.addLast(1);
		lista.addLast(5);
		lista.addLast(1);
		lista.addLast(8);
		lista.addLast(7);
		lista.addLast(1);
		lista.addLast(56);
		
		
		

		lista.show();
		
		ShellSort<Integer> ss = new ShellSort<Integer>();
		
		ss.shellSort(lista);
		
		
		lista.show();
	}

}
