package br.com.MyMoviesDB.model.VO;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import br.com.MyMoviesDB.model.BO.AvaliadorBO;
import br.com.MyMoviesDB.model.BO.FilmeBO;

public class AvaliacaoVO implements Serializable,Comparable<AvaliacaoVO> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3257722554720400018L;

	private Calendar date;
	private double evaluation;
	private String criticism;
	private int movieKey;
	private int evaluatorKey;

	public long getEvaluator() {
		return evaluatorKey;
	}

	public void setEvaluator(int evaluator) {
		this.evaluatorKey = evaluator;
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
		return movieKey;
	}

	public void setMovie(int movie) {
		this.movieKey = movie;
	}

	@Override
	public String toString() {
		FilmeVO movie = new FilmeBO().searchByKey(this.movieKey);
		AvaliadorVO avaliador = new AvaliadorBO().searchByKey(this.evaluatorKey);
		return "[Avaliador = " + avaliador + ", Data = "
				+ new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(date.getTime()) + ", Nota = " + evaluation
				+ ", Crítica = " + criticism + ", Filme = " + movie.toString() + "]";
	}

	@Override
	public int compareTo(AvaliacaoVO o) {
		Date time = this.date.getTime();
		Date timeO = o.date.getTime();
		
		if(time.compareTo(timeO) < 0) {
			return -1;
		}else if(time.compareTo(timeO) > 0){
			return 1;
		}else {
			return 0;
		}
	}
}
