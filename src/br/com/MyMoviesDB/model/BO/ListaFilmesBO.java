package br.com.MyMoviesDB.model.BO;

import java.io.IOException;

import br.com.MyMoviesDB.model.DAO.BaseInterDAO;
import br.com.MyMoviesDB.model.DAO.ListaFilmesDAO;
import br.com.MyMoviesDB.model.VO.ListaFilmesVO;
import structures.DoubleList;
import structures.ListInterface;

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
		if(lm != null) {
			movieList.addLast(lm);
			try {
				dao.writer(movieList);
				System.out.println("Nova lista criada com sucesso");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("Não foi possivel adicionar o objeto, pois o mesmo esta vazio.");
		}
	}
	
	public void update(ListaFilmesVO lm, int id) {
		if(lm != null) {
			if(movieList.search(id)!= null) {
				movieList.updateData(lm, id);
				try {
					dao.writer(movieList);
					System.out.println("Editado");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Lista não eiste");
			}
		}else {
			System.out.println("A Lista editada é invalida");
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
	public void addNovoFilme(int id) {
		
	}
	
	
	
	
	
}
