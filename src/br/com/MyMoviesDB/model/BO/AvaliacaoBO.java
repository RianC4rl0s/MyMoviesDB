package br.com.MyMoviesDB.model.BO;

import java.io.IOException;

import br.com.MyMoviesDB.model.DAO.AvaliacaoDAO;
import br.com.MyMoviesDB.model.DAO.BaseInterDAO;
import br.com.MyMoviesDB.model.VO.AvaliacaoVO;
import structures.DoubleList;
import structures.ListInterface;

public class AvaliacaoBO implements BaseInterBO<AvaliacaoVO> {
	BaseInterDAO<ListInterface<Object>> dao;
	ListInterface<Object> ratings;

	public AvaliacaoBO() {
		dao = new AvaliacaoDAO();

		try {
			ratings = dao.reader();
		} catch (ClassNotFoundException e) {
			ratings = new DoubleList<Object>();
			e.printStackTrace();
		} catch (IOException e) {
			ratings = new DoubleList<Object>();
			e.printStackTrace();

		}
	}

	public void create(AvaliacaoVO avaliacao) {
		if (avaliacao != null) {

			ratings.addLast(avaliacao);
			try {
				dao.writer(ratings);
				System.out.println("Nova critica adicionada com sucesso!!!");
			} catch (IOException e) {
				e.printStackTrace();

			}

		} else {
			System.out.println("Não foi possivel adicionar o objeto, pois o mesmo esta vazio.");
		}

	}

	public void update(AvaliacaoVO a, int id) {

		if (a != null) {
			if (ratings.search(id) != null) {
				ratings.updateData(a, id);
				try {
					dao.writer(ratings);
					System.out.println("Editado");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Critica não existe");
			}
		} else {
			System.out.println("A critica editada é invalida");
		}

	}

	public void read() {
		ratings.show();
	}

	public void delete(int id) {
		if (ratings.search(id) != null) {
			ratings.remove(id);

			try {
				dao.writer(ratings);
				System.out.println("Critica deletada");
			} catch (IOException e) {
				System.out.println("A critida indicada não existe");
			}
		}
	}

	public AvaliacaoVO search(int id) {
		AvaliacaoVO a = (AvaliacaoVO) ratings.search(id);
		if (a != null) {
			return a;
		} else {
			return null;
		}
	}
	
	public ListInterface<AvaliacaoVO> listaAvaliacoes(){
		ListInterface<AvaliacaoVO> temp = new DoubleList<AvaliacaoVO>();
		for(int i = 1; i < (int)ratings.getSize();i++) {
			temp.addLast((AvaliacaoVO)ratings.search(i));
		}
		
		
		return temp;
	}
	
	public void sort() {
		int size = (int) ratings.getSize();
		
		AvaliacaoVO vet[] = new AvaliacaoVO[size];
		
		for(int i = 1, j = 0; i <= size; i++, j++) {
			vet[j] = (AvaliacaoVO) ratings.search(i);
		}
		
		int h = 1;
		
		while(h < vet.length) {
			h = 3 * h + 1;
		}
		
		while(h > 1) {
			h /= 3;

			for(int i = h; i < vet.length; i++) {
				AvaliacaoVO chosen = vet[i];
				int j = i - h;
				
				while(j >= 0 && (chosen.compareTo(vet[j]) > 0)) {
					vet[j + h] = vet[j];
					j -= h;
				}
				
				vet[j + h] = chosen;
			}
		}
		
		for(int i = 0; i < size; i++) {
			ratings.removeLast();
		}
		
		for(int i = 0; i < size; i++) {
			ratings.addLast(vet[i]);
		}
		
		try {
			dao.writer(ratings);
			System.out.println("Lista ordenada!");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public ListInterface<Object> searchByMovie(String movie) {

		ListInterface<Object> list = new DoubleList<Object>();

		return list;
	}
	
	public boolean searchByMovie(int key) {
		AvaliacaoVO avO;

		for(int i = 1; i <= ratings.getSize(); i++) {
			avO = (AvaliacaoVO) ratings.search(i);
			
			if(avO.getMovie() == key) {
				return true;
			}
		}

		return false;
	}

}
