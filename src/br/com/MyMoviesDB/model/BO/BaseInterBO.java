package br.com.MyMoviesDB.model.BO;

public interface BaseInterBO<T> {

	void create(T obj);

	void update(T obj, int id);

	void delete(int id);

	void read();

}
