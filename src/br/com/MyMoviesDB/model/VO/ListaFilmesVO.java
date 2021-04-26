package br.com.MyMoviesDB.model.VO;

import java.io.Serializable;

import structures.QueueInterface;

public class ListaFilmesVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3793380992668459720L;
	
	private long id;
	private QueueInterface<FilmeVO> movieList;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public QueueInterface<FilmeVO> getMovieList() {
		return movieList;
	}

	public void setMovieList(QueueInterface<FilmeVO> movieList) {
		this.movieList = movieList;
	}

	@Override
	public String toString() {
		return "[id = " + id + ", Lista = /n" + movieList + "]";
	}

}
