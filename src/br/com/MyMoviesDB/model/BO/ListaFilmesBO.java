package br.com.MyMoviesDB.model.BO;

import java.io.IOException;

import br.com.MyMoviesDB.model.DAO.ListaFilmesDAO;
import br.com.MyMoviesDB.model.VO.FilmeVO;
import br.com.MyMoviesDB.model.VO.ListaFilmesVO;
import structures.DoubleList;
import structures.ListInterface;
import structures.QueueInterface;

public class ListaFilmesBO implements BaseInterBO<ListaFilmesVO>{
	ListaFilmesDAO dao;
	ListInterface<String> lists; // Mantendo o nome das listas de filmes
	ListInterface<Object> movieList = new DoubleList<Object>(); // Mantendo a lista das listas de filmes
	FilmeBO filmeBO = new FilmeBO();
	
	public ListaFilmesBO() {
		dao = new ListaFilmesDAO();		
		
		try {
			lists = dao.reader(); // Lendo o arquivo com os nomes das listas
			
			// Percorrendo o array com o nome das listas para ler no arquivo
			// de cada uma e recuperar cada fila.
			int lastId = lists.peekLastId();

			if (lastId > 0) {
				for (int i = 1; i <= lastId; i++) {
					String name = lists.search(i);
					if (name != null) {
						movieList.addLast(dao.reader(name));
					}
				}
			}			
		}catch(ClassNotFoundException e) {
			lists = new DoubleList<String>();
			e.printStackTrace();
		}catch(IOException e){
			lists = new DoubleList<String>();
			e.printStackTrace();
		}
	}
	
	public void create(ListaFilmesVO lm) {
		if (lm != null) {
			if (lm.getName() != null) {
				System.out.println(lm.getName());
				if (movieList.peekFirst() == null) {
					lm.setKey(1);
					
				} else {
					//System.out.println(movieList.peekLast());
					ListaFilmesVO last = (ListaFilmesVO) movieList.peekLast(); // Pegando o último para incrementar a chave
					
					System.out.println(last);
					
					lm.setKey(last.getKey() + 1);
				}
				
				movieList.addLast(lm);
				
				try {					
					// Adicionando o nome da nova lista no array das listas
					lists.addLast(lm.getName());
					
					dao.writer(lists); // Escrevendo arquivos com nome das listas
					dao.writer(lm);		// Escrevendo a lista em um arquivo com seu nome
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
						dao.writer(lm);
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
		ListaFilmesVO list = (ListaFilmesVO) movieList.search(id);
		
		if(list != null) {
			try {
				// Removendo das listas de filmes
				movieList.remove(id);
				
				
				// Removendo o nome da lista de filmes da lista dos nomes
				int lastId = lists.peekLastId();

				// Abaixo estou percorrendo o array da lista de nomes
				if (lastId > 0) {
					for (int i = 1; i <= lastId; i++) {
						String name = lists.search(i);
						if (name != null && name.equals(list.getName())) {
							lists.remove(i);
						}
					}
				}			
				
				// Escrevendo arquivo de nomes
				dao.writer(lists);
				
				// Deletando arquivo da lista de filmes
				dao.delete(list.getName());
				
				System.out.println("Lista deletada");
			} catch (IOException e) {
				System.out.println("A lista nao existe!!!");
			}
		}else {
			System.out.println("ERR: Objeto não existe");
		}

	}
	
	public void show() {
		
		// Nesse método, tenho que percorrer primeiro a lista das listas de filmes e para cada
		// lista de filmes, devo procurar por seus filmes.
		int lastId = movieList.peekLastId();

		if (lastId > 0) {
			for (int i = 1; i <= lastId; i++) {
		
				ListaFilmesVO obj = (ListaFilmesVO) movieList.search(i);
				
				if (obj != null) {
					System.out.println("Lista " + obj.getName());
					QueueInterface<Integer> list = obj.getMovieList();
					
					// Aqui eu percorro a fila com os filmes 
					int lastIdQueue = list.peekLastId();
					
					if (lastIdQueue > 0) {
						for (int j = 1; j <= lastIdQueue; j++) {
							Integer inte = (Integer) list.search(j);
							if (inte != null) {
								FilmeVO movie = filmeBO.searchByKey(inte);
								System.out.println(movie);
							}
						}
					} else {
						System.out.println("Lista de filme vazia");
					}					
				}
			}
		} else {
			System.out.println("Nenhuma lista de filmes");
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
