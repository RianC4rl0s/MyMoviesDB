package br.com.MyMoviesDB.model.BO;

import java.io.IOException;

import br.com.MyMoviesDB.model.DAO.AvaliacaoDAO;
import br.com.MyMoviesDB.model.DAO.BaseInterDAO;
import br.com.MyMoviesDB.model.VO.AvaliacaoVO;
import br.com.MyMoviesDB.model.VO.AvaliadorVO;
import br.com.MyMoviesDB.model.VO.FilmeVO;
import structures.DoubleList;
import structures.ListInterface;

public class AvaliacaoBO implements BaseInterBO<AvaliacaoVO>{
	BaseInterDAO<ListInterface<Object>> dao;
	ListInterface<Object> ratings;

	
	public AvaliacaoBO() {
		dao = new AvaliacaoDAO();
		
		try {
			ratings = dao.reader();
		}catch(ClassNotFoundException e){
			ratings = new DoubleList<Object>();
			e.printStackTrace();
		}catch(IOException e) {
			ratings = new DoubleList<Object>();
			e.printStackTrace();
			
		}
	}
	
	public void create(AvaliacaoVO avaliacao) {
		if(avaliacao != null) {

			ratings.addLast(avaliacao);
			try {
				dao.writer(ratings);
				System.out.println("Nova critica adicionaca com sucesso!!!");
			} catch (IOException e) {
				e.printStackTrace();
				
			}	

		}else {
			System.out.println("Não foi possivel adicionar o objeto, pois o mesmo esta vazio.");
		}
		
		
		
		
	}
	public void update(AvaliacaoVO a,int id){
		
		if(a != null) {
			if(ratings.search(id)!= null) {
				ratings.updateData(a, id);
				try {
					dao.writer(ratings);
					System.out.println("Editado");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Critica não eiste");
			}
		}else {
			System.out.println("A critica editada é invalida");
		}
	
	
	}
	public void read() {
		ratings.show();
	}
	public void delete(int id) {
		if(ratings.search(id) != null) {
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
		if(a != null) {
			return a;
		}else {
			return null;
		}
	}
	public ListInterface<Object> searchByMovie(String movie){
	
		ListInterface<Object> list = new DoubleList<Object>();
	
		return list;
	}
	
}
