package br.com.MyMoviesDB.model.VO;

import java.io.Serializable;

import br.com.MyMoviesDB.model.BO.FilmeBO;
import structures.QueueInterface;

public class ListaFilmesVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID= 3793380992668459720L;
	
	private long key;
	private String name;
	private QueueInterface<Integer> movieList;

	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public long getKey() {
		return key;
	}

	public void setKey(long key) {
		this.key = key;
	}

	public QueueInterface<Integer> getMovieList() {
		return movieList;
	}

	public void setMovieList(QueueInterface<Integer> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "[key = " + key + ", Lista = /n" + movieList + "]";
	}
	public void addMovieToList(int movieID) {
		
			FilmeVO filme = new FilmeBO().search(movieID) ;
			if(filme != null) {
				
				movieList.add(filme.getKey());
				
				
				System.out.println("Filme adiciona a lista!!");
			}else {
				System.out.println("Não foi póssivel encontrar o filme");
			}
		
		
		
	}
	public void removeMovieFromList() {
		System.out.println(movieList.remove());
	}
}
