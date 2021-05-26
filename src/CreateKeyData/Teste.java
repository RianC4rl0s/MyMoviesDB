package CreateKeyData;

import SortAlgorithms.ShellSort;
import br.com.MyMoviesDB.model.BO.AvaliacaoBO;
import br.com.MyMoviesDB.model.VO.AvaliacaoVO;
import structures.DoubleList;
import structures.ListInterface;

public class Teste {

	public static void main(String[] args) {
		ListInterface<Integer> lista = new DoubleList<Integer>(); 
	
		
		
		
		lista.addLast(5);
		lista.addLast(1);
		lista.addLast(8);
		lista.addLast(4);
		lista.addLast(2);
		lista.addLast(3);
		lista.addLast(8);
		lista.addLast(5);
		lista.addLast(23);
		lista.addLast(789);
		lista.addLast(23);
		lista.addLast(56);
		
		
		

		lista.show();
		
		ShellSort<Integer> ss = new ShellSort<Integer>();
		
		ss.shellSort(lista);
		System.out.println("Organizada");
		
		lista.show();
	}

}
