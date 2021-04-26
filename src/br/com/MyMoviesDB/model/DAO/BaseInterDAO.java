package br.com.MyMoviesDB.model.DAO;

import java.io.IOException;

public interface BaseInterDAO<T> {

	void writer(T list) throws IOException;

	T reader() throws IOException, ClassNotFoundException;

}
