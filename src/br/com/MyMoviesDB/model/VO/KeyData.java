package br.com.MyMoviesDB.model.VO;

public class KeyData {

	private int movieKey;
	private int avaliatorkey;
	private int avaliacaoKey;
	
	public int getAvaliatorkey() {
		return avaliatorkey;
	}

	public void setAvaliatorkey(int avaliatorkey) {
		this.avaliatorkey = avaliatorkey;
	}

	public int getAvaliacaoKey() {
		return avaliacaoKey;
	}

	public void setAvaliacaoKey(int avaliacaoKey) {
		this.avaliacaoKey = avaliacaoKey;
	}

	public int getMovieKey() {
		return movieKey;
	}

	public void setMovieKey(int movieKey) {
		this.movieKey = movieKey;
	}

	public String toString() {
		return "MovieKey = " + movieKey + " Avaliator key ="+ avaliatorkey+ " AvaliacaoKey = "+avaliacaoKey;
	}
	

}
