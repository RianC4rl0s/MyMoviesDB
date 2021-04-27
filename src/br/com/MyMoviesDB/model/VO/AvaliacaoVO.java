package br.com.MyMoviesDB.model.VO;

import java.io.Serializable;
import java.util.Calendar;

import br.com.MyMoviesDB.model.BO.FilmeBO;

public class AvaliacaoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3257722554720400018L;
	
	private int evaluatorID;
	private Calendar date;
	private double evaluation;
	private String criticism;
	private int movieID;

	public int getEvaluator() {
		return evaluatorID;
	}

	public void setEvaluator(int evaluator) {
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
		return "AvaliacaoVO [Avaliador = " + evaluatorID + ", Data = " + date + ", Nota = " + evaluation + ", Crítica = "
				+ criticism + ", Filme = " + movie.toString() + "]";
	}

}
