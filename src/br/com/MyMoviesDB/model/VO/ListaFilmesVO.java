package br.com.MyMoviesDB.model.VO;

import br.com.MyMoviesDB.structures.QueueInterface;

public class ListaFilmesVO {

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
