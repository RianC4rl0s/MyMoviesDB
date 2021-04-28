package br.com.MyMoviesDB.model.BO;

import java.io.IOException;

import br.com.MyMoviesDB.model.DAO.AvaliadorDAO;
import br.com.MyMoviesDB.model.DAO.BaseInterDAO;
import br.com.MyMoviesDB.model.VO.AvaliadorVO;
import structures.DoubleList;
import structures.ListInterface;

public class AvaliadorBO implements BaseInterBO<AvaliadorVO> {

	BaseInterDAO<ListInterface<Object>> dao;
	ListInterface<Object> evaluators;

	public AvaliadorBO() {

		dao = new AvaliadorDAO();

		try {
			evaluators = dao.reader();
		} catch (ClassNotFoundException e) {
			evaluators = new DoubleList<Object>();
			e.printStackTrace();
		} catch (IOException e) {
			evaluators = new DoubleList<Object>();
			e.printStackTrace();
		}

	}

	@Override
	public void create(AvaliadorVO obj) {

		if (obj != null) {
			if ((obj.getName() != null || obj.getName().equals("")) && obj.getAge() >= 0) {
				if (evaluators.peekFirst() == null) {
					obj.setKey(1);
				} else {
					AvaliadorVO last = (AvaliadorVO) evaluators.peekLast(); // Pegando o último para incrementar a chave
					obj.setKey(last.getKey() + 1);
				}

				evaluators.addLast(obj);

				try {
					dao.writer(evaluators);
					System.out.println("Avaliador Cadastrado!");
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				System.out.println("ERR: Entradas inválidas");
			}
		} else {
			System.out.println("ERR: Objeto inválido");
		}

	}

	@Override
	public void update(AvaliadorVO obj, int id) {

		AvaliadorVO updated = (AvaliadorVO) evaluators.search(id);

		if (obj != null) {
			if (updated != null) {
				if ((obj.getName() != null || obj.getName().equals("")) && obj.getAge() >= 0) {
					obj.setKey(updated.getKey()); // Ao atualizar, fica com a mesma key
					evaluators.updateData(obj, id);

					try {
						dao.writer(evaluators);
						System.out.println("Avaliador Atualizado!");
					} catch (IOException e) {
						e.printStackTrace();
					}
				} else {
					System.out.println("ERR: Entradas inválidas");
				}
			} else {
				System.out.println("ERR: Objeto não existe");
			}
		} else {
			System.out.println("ERR: Objeto inválido");
		}

	}

	@Override
	public void delete(int id) {

		if (evaluators.search(id) != null) {

			evaluators.remove(id);

			try {
				dao.writer(evaluators);
				System.out.println("Avaliador Deletado!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("ERR: Objeto não existe");
		}

	}

	@Override
	public AvaliadorVO search(int id) {

		AvaliadorVO evaluator = (AvaliadorVO) evaluators.search(id);

		if (evaluator != null) {
			return evaluator;
		} else {
			return null;
		}

	}

	// Método que procura pela chave do avaliador e retorna true se encontrar
	public AvaliadorVO searchByKey(int key) {
		int lastId = evaluators.peekLastId();

		if (lastId > 0) {
			for (int i = 1; i <= lastId; i++) {
				AvaliadorVO obj = (AvaliadorVO) evaluators.search(i);
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

	@Override
	public void read() {
		evaluators.show();
	}

}
