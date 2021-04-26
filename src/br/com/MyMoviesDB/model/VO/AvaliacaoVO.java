package br.com.MyMoviesDB.model.VO;

import java.io.Serializable;
import java.util.Calendar;

public class AvaliacaoVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3257722554720400018L;
	
	private AvaliadorVO evaluator;
	private Calendar date;
	private double evaluation;
	private String criticism;
	private FilmeVO movie;

	public AvaliadorVO getEvaluator() {
		return evaluator;
	}

	public void setEvaluator(AvaliadorVO evaluator) {
		this.evaluator = evaluator;
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

	public FilmeVO getMovie() {
		return movie;
	}

	public void setMovie(FilmeVO movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "AvaliacaoVO [Avaliador = " + evaluator + ", Data = " + date + ", Nota = " + evaluation + ", Crítica = "
				+ criticism + ", Filme = " + movie + "]";
	}

}
