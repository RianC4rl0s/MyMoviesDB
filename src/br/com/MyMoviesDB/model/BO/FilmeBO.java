package br.com.MyMoviesDB.model.BO;

import java.io.IOException;

import br.com.MyMoviesDB.model.DAO.BaseInterDAO;
import br.com.MyMoviesDB.model.DAO.FilmeDAO;
import br.com.MyMoviesDB.model.DAO.KeyDataDAO;
import br.com.MyMoviesDB.model.VO.FilmeVO;
import br.com.MyMoviesDB.model.VO.KeyData;
import structures.DoubleList;
import structures.ListInterface;

public class FilmeBO implements BaseInterBO<FilmeVO> {

	BaseInterDAO<ListInterface<Object>> dao;
	ListInterface<Object> movies;
	BaseInterDAO<KeyData> kdDao;
	KeyData kd;
	public FilmeBO() {

		dao = new FilmeDAO();
		kdDao = new KeyDataDAO();
		try {
			movies = dao.reader();
			kd = kdDao.reader();
		} catch (ClassNotFoundException e) {
			movies = new DoubleList<Object>();
			kd = (KeyData)new Object();
			e.printStackTrace();
		} catch (IOException e) {
			movies = new DoubleList<Object>();
			kd = (KeyData)new Object();
			e.printStackTrace();
		}
	}

	@Override
	public void create(FilmeVO obj) {

		
		if (obj != null) {
			if (obj.getTitle() != null) {
				if (kd== null) {
					kd.setMovieKey(1);
					obj.setKey(kd.getMovieKey());
					
				} else {
					//FilmeVO last = (FilmeVO) movies.peekLast(); // Pegando o último para incrementar a chave
					obj.setKey(kd.getMovieKey() + 1);
					kd.setMovieKey(kd.getMovieKey()+1);
				}

				movies.addLast(obj);
				try {
					dao.writer(movies);
					kdDao.writer(kd);
					System.out.println("Filme Cadastrado!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("ERR: Título inválido");
			}
		} else {
			System.out.println("ERR: Objeto inválido");
		}
		/*
		if (obj != null) {
			if (obj.getTitle() != null) {
				if (movies.peekFirst() == null) {
					obj.setKey(1);
				} else {
					FilmeVO last = (FilmeVO) movies.peekLast(); // Pegando o último para incrementar a chave
					obj.setKey(last.getKey() + 1);
				}

				movies.addLast(obj);
				try {
					dao.writer(movies);
					System.out.println("Filme Cadastrado!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("ERR: Título inválido");
			}
		} else {
			System.out.println("ERR: Objeto inválido");
		}
*/
	}

	@Override
	public void update(FilmeVO obj, int id) {

		if (obj != null) {
			if (movies.search(id) != null) {
				if (obj.getTitle() != null) {
					movies.updateData(obj, id);
					try {
						dao.writer(movies);
						System.out.println("Filme Editado!");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ERR: Título inválido");
				}
			} else {
				System.out.println("ERR: Objeto não exite");
			}
		} else {
			System.out.println("ERR: Objeto inválido");
		}

	}

	@Override
	public void delete(int id) {

		if (movies.search(id) != null) {

			movies.remove(id);

			try {
				dao.writer(movies);
				System.out.println("Filme Deletado!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ERR: Objeto não existe");
		}

	}

	@Override
	public void read() {
		movies.show();
	}

	@Override
	public FilmeVO search(int id) {

		FilmeVO movie = (FilmeVO) movies.search(id);

		if (movie != null) {
			return movie;
		} else {
			return null;
		}

	}

	// Método que procura pela chave do filme e o retorna se encontrar
	public FilmeVO searchByKey(int key) {
		int lastId = movies.peekLastId();

		if (lastId > 0) {
			for (int i = 1; i <= lastId; i++) {
				FilmeVO obj = (FilmeVO) movies.search(i);
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

	// Método que procura pela chave do filme e retorna o id dele na lista
	public int searchId(int key) {
		int lastId = movies.peekLastId();

		if (lastId > 0) {
			for (int i = 1; i <= lastId; i++) {
				FilmeVO obj = (FilmeVO) movies.search(i);
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

	public ListInterface<Object> searchByName(String name) {
		ListInterface<Object> list = new DoubleList<Object>();
		for (int i = 0; i < movies.getSize(); i++) {
			FilmeVO movie = (FilmeVO) movies.search(i);
			if (movie.getTitle().contains(name)) {
				list.addLast(movie);
			}
		}
		return list;
	}
}
