package br.com.MyMoviesDB.model.BO;

import java.io.IOException;

import br.com.MyMoviesDB.model.DAO.AvaliacaoDAO;
import br.com.MyMoviesDB.model.DAO.BaseInterDAO;
import structures.DoubleList;
import structures.ListInterface;

public class AvaliacaoBO {
	BaseInterDAO<ListInterface<Object>> dao;
	ListInterface<Object> ratings;
	//String path = "data/evaluate.dat";
	
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
	
	public void rate() {
		
	}
	public void updateRating(){
		
	}
	public void read() {
		
	}
	public void delete() {
		
	}
	
}
