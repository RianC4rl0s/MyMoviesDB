package br.com.MyMoviesDB.model.BO;

import java.io.IOException;


import br.com.MyMoviesDB.model.DAO.BaseInterDAO;
import br.com.MyMoviesDB.model.DAO.KeyDataDAO;
import br.com.MyMoviesDB.model.VO.KeyData;


public class KeyDataBO {
	BaseInterDAO<KeyData> dao;
	KeyData kd;
	
	public KeyDataBO() {
		dao = new KeyDataDAO();

		try {
			kd = dao.reader();
		} catch (ClassNotFoundException e) {
			kd = (KeyData) new Object();
			e.printStackTrace();
		} catch (IOException e) {
			kd = (KeyData) new Object();
			e.printStackTrace();
		}
	}
	
	
	public void create(KeyData obj) {
		if (obj != null) {
			try {
				dao.writer(kd);
				System.out.println("KeyData Cadastrado!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Objeto nulo");
		}
	}
	public void update(KeyData kd) {
		if(kd != null) {
			this.kd = kd;
			
			try {
				dao.writer(kd);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Objeto nulo");
		}
	}
	public void delete() {
		this.kd.setMovieKey(0);
		if(kd != null) {
			try {
				dao.writer(kd);
				System.out.println("KeyData Deletado!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}	
	
	public void read() {
		System.out.println(kd);
	}
}
