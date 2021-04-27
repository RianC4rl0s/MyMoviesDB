package br.com.MyMoviesDB.model.VO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//import br.com.MyMoviesDB.model.BO.AvaliacaoBO;
import br.com.MyMoviesDB.model.BO.AvaliadorBO;
import br.com.MyMoviesDB.model.BO.BaseInterBO;
import br.com.MyMoviesDB.model.BO.FilmeBO;

public class AvaliacaoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3257722554720400018L;
	
	private Long evaluatorID;
	private Calendar date;
	private double evaluation;
	private String criticism;
	private int movieID;

	public long getEvaluator() {
		return evaluatorID;
	}

	public void setEvaluator(Long evaluator) {
		this.evaluatorID = evaluator;
	}

	public Calendar getDate() {
		return date;
	}

	public void setDate(Calendar date) {
		this.date = date;
	}

	public double getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(double evaluation) {
		this.evaluation = evaluation;
	}

	public String getCriticism() {
		return criticism;
	}

	public void setCriticism(String criticism) {
		this.criticism = criticism;
	}

	public int getMovie() {
		return movieID;
	}

	public void setMovie(int movie) {
		this.movieID = movie;
	}

	@Override
	public String toString() {
		FilmeVO movie  = new FilmeBO().search(this.movieID); 
		int i = 1;
		BaseInterBO<AvaliadorVO> avaliadorBO = new AvaliadorBO();
		AvaliadorVO avaliador = new AvaliadorVO();
		while(avaliadorBO.search(i) != null) {
			if(avaliadorBO.search(i).getKey() == this.evaluatorID) {
				avaliador = avaliadorBO.search(i);			
			}else {
				i++;
			}
		}
		return "AvaliacaoVO [Avaliador = " + avaliador + ", Data = " +  new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date.getTime())+ ", Nota = " + evaluation + ", Crítica = "
				+ criticism + ", Filme = " + movie.toString() + "]";
	}

}
