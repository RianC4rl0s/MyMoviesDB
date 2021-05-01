package br.com.MyMoviesDB.model.BO;

import java.io.IOException;

import br.com.MyMoviesDB.model.DAO.BaseInterDAO;
import br.com.MyMoviesDB.model.DAO.ListaFilmesDAO;
import br.com.MyMoviesDB.model.VO.FilmeVO;
import br.com.MyMoviesDB.model.VO.ListaFilmesVO;
import structures.DoubleList;
import structures.ListInterface;
import structures.QueueInterface;

public class ListaFilmesBO implements BaseInterBO<ListaFilmesVO>{
	BaseInterDAO<ListInterface<Object>> dao;
	ListInterface<Object> movieList;
	public ListaFilmesBO() {
		dao = new ListaFilmesDAO();
		
		
		try {
			movieList = dao.reader();
		}catch(ClassNotFoundException e) {
			movieList = new DoubleList<Object>();
			e.printStackTrace();
		}catch(IOException e){
			movieList = new DoubleList<Object>();
			e.printStackTrace();
		}
	}
	
	public void create(ListaFilmesVO lm) {
		System.out.println("ENtrou na criação de nova lista");
		if (lm != null) {
			if (lm.getName() != null) {
				if (movieList.peekFirst() == null) {
					lm.setKey(1);
				} else {
					FilmeVO last = (FilmeVO) movieList.peekLast(); // Pegando o último para incrementar a chave
					lm.setKey(last.getKey() + 1);
				}
				System.out.println("ADD na lista");
				movieList.addLast(lm);
				try {
					System.out.println("Pronto para escrever no arquivo");
					movieList.show();
					dao.writer(movieList);
					System.out.println("Lista Cadastrada");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("ERR: Nome inválido");
			}
		} else {
			System.out.println("ERR: Objeto inválido");
		}

	}
	
	public void update(ListaFilmesVO lm, int id) {
		if(lm != null) {
			if(lm.getName()!= null) {
				if(movieList.search(id)!= null) {
					movieList.updateData(lm, id);
					try {
						dao.writer(movieList);
						System.out.println("Editado");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				} else {
					System.out.println("ERR: Nome inválido");
				}
			} else {
				System.out.println("ERR: Objeto não exite");
			}
		} else {
			System.out.println("ERR: Objeto inválido");
		}

	}
	public void read() {
		movieList.show();
	}
	
	public void delete(int id) {
		if(movieList.search(id)!= null) {
			movieList.remove(id);
			try {
				dao.writer(movieList);
				System.out.println("Lista deletada");
			} catch (IOException e) {
				System.out.println("A lista nao existe!!!");
			}
		}else {
			System.out.println("ERR: Objeto não existe");
		}

	}
	public ListaFilmesVO search(int id) {
		ListaFilmesVO lm = (ListaFilmesVO) movieList.search(id);
		if(lm != null){
			return lm;
		}else {
			return null;
		}
	}
	//ACHO Q TA ERRADO
	public void addMovieToList(long lsID,int movieID) {
		if(movieList.search((int)lsID)!= null){
			if(new FilmeBO().search(movieID) != null) {
			
				ListaFilmesVO temp =(ListaFilmesVO)movieList.search((int)lsID);
				QueueInterface<Integer> l =  temp.getMovieList();
				
				l.add(movieID);
				
				temp.setMovieList(l);
				
				movieList.updateData(temp, (int)lsID);
				System.out.println("Filme adiciona a lista!!");
			}else {
				System.out.println("Não foi póssivel encontrar o filme");
			}
		}else {
			System.out.println("Lista não encontrada");
		}
		
		
	}
	public void removeMovieFromList(long lsID)  {
		if(movieList.search((int)lsID)!= null){
			
				ListaFilmesVO temp =(ListaFilmesVO)movieList.search((int)lsID);
				QueueInterface<Integer> l =  temp.getMovieList();
				
				l.remove();
				
				temp.setMovieList(l);
				
				movieList.updateData(temp, (int)lsID);
				System.out.println("Filme removido da lista!!");
		}else {
			System.out.println("Lista não encontrada");
		}
		
		
	}
	public ListaFilmesVO searchByKey(long key) {
		int lastId = movieList.peekLastId();

		if (lastId > 0) {
			for (int i = 1; i <= lastId; i++) {
				ListaFilmesVO obj = (ListaFilmesVO) movieList.search(i);
				if (obj != null) {
					if (obj.getKey() == key) {
						return obj;
					}
				}
			}
		} else {
			System.out.println("ERR: Lista Vazia");
			return null;
		}

		return null;
	}
	public int searchId(int key) {
		int lastId = movieList.peekLastId();

		if (lastId > 0) {
			for (int i = 1; i <= lastId; i++) {
				ListaFilmesVO obj = (ListaFilmesVO) movieList.search(i);
				if (obj != null) {
					if (obj.getKey() == key) {
						return i;
					} else {
						return -1;
					}
				}
			}
		} else {
			System.out.println("ERR: Lista Vazia");
			return -1;
		}

		return -1;
	}

}
