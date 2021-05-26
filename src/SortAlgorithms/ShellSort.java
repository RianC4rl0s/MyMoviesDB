package SortAlgorithms;

import structures.ListInterface;

public class ShellSort < T extends Comparable<? super T>>{
	
	public void shellSort(ListInterface<T> lista) {
	
		
		
		//TEM QUE TESTAR MAIS CASOS
		int tam =(int) lista.getSize();
		int h = 1;
		while (h  < tam) {
			h = 3 *h+1;
		}
		
		while(h > 1) {
			h = h/3;
		
			for(int i = h ;i <= tam;i++) {
				T temp = lista.search(i);
				
				 int j = i -h;
				 
				 while(j >= 1 && (temp.compareTo(lista.search(j))<0 )){
					 lista.updateData(lista.search(j),j+h);
					 j = j-h;
				 } 
				 
				 lista.updateData(temp, j+h);
				 
			}
	
		}
			
	}
}
