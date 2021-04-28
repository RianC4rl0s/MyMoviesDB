package br.com.MyMoviesDB.model.VO;

import java.io.Serializable;

public class FilmeVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3701530536791407915L;

	private int key;
	private String title, genre, durationTime, director, description;
	private int year;
	private int ageRange;
	private String generalEvaluation =  "N/A";
	private double sumEvaluations;
	private int evaluationQt;

	public double getSumEvaluations() {
		return sumEvaluations;
	}

	public void setSumEvaluations(double sumEvaluations) {
		this.sumEvaluations = sumEvaluations;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getAgeRange() {
		return ageRange;
	}

	public void setAgeRange(int ageRange) {
		this.ageRange = ageRange;
	}

	public String getGeneralEvaluation() {
		return generalEvaluation;
	}

	public void setGeneralEvaluation() {
		this.generalEvaluation = Double.toString(sumEvaluations / evaluationQt);
	}

	@Override
	public String toString() {
		return "[Título = " + title + ", " + "Diretor = " + director + ", " + "Descrição = " + description + ", "
				+ "Nota Geral = " + generalEvaluation + ", Key = " + key + "]";
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getEvaluationQt() {
		return evaluationQt;
	}

	public void setEvaluationQt(int evaluationQt) {
		this.evaluationQt = evaluationQt;
	}

}
