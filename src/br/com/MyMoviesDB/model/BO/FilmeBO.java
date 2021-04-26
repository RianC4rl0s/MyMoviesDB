package br.com.MyMoviesDB.model.BO;

import java.io.IOException;

import br.com.MyMoviesDB.model.DAO.BaseInterDAO;
import br.com.MyMoviesDB.model.DAO.FilmeDAO;
import br.com.MyMoviesDB.model.VO.FilmeVO;
import structures.DoubleList;
import structures.ListInterface;

public class FilmeBO implements BaseInterBO<FilmeVO> {

	BaseInterDAO<ListInterface<Object>> dao;
	ListInterface<Object> movies;
	String path = "data/movies.dat";

	public FilmeBO() {

		dao = new FilmeDAO();

		try {
			movies = dao.reader();
		} catch (ClassNotFoundException e) {
			movies = new DoubleList<Object>();
			e.printStackTrace();
		} catch (IOException e) {
			movies = new DoubleList<Object>();
			e.printStackTrace();
		}
	}

	@Override
	public void create(FilmeVO obj) {

		if (obj != null) {
			if (obj.getTitle() != null) {
				movies.addLast(obj);
				try {
					dao.writer(movies);
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("ERR: Título inválido");
			}
		} else {
			System.out.println("ERR: Objeto inválido");
		}

	}

	@Override
	public void update(FilmeVO obj, int id) {

		if (obj != null) {
			if (movies.search(id) != null) {
				if (obj.getTitle() != null) {
					movies.addAfter(obj, id);
					movies.remove(id);

					try {
						dao.writer(movies);
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

}
