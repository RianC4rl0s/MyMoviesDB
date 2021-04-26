package br.com.MyMoviesDB.model.DAO;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import structures.ListInterface;
import structures.SimpleList;

public class FilmeDAO implements BaseInterDAO<ListInterface<Object>> {

	@Override
	public void writer(ListInterface<Object> list) throws IOException {

		File file = new File("data/movies.bin");
		file.delete();
		file.createNewFile();

		ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));

		for (int i = 1; i <= list.getSize(); i++) {
			objOutput.writeObject(list.search(i));
		}

		objOutput.close();
	}

	@Override
	public ListInterface<Object> reader() throws IOException, ClassNotFoundException {

		ListInterface<Object> lista = new SimpleList<Object>();

		File file = new File("data/movies.bin");

		if (file.exists()) {
			ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));

			Object x;

			try {
				while ((x = objInput.readObject()) != null) {
					lista.addFirst(x);
				}
			} catch (EOFException e) {
				System.out.println("Lista completamente lida!");
			}

			objInput.close();
		}

		return lista;
	}

}
