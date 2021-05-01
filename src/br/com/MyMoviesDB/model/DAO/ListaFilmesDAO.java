package br.com.MyMoviesDB.model.DAO;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import structures.DoubleList;
import structures.ListInterface;

public class ListaFilmesDAO  implements BaseInterDAO<ListInterface<Object>>{
	
	@Override
	public void writer(ListInterface<Object> list) throws IOException {

		File file = new File("data/ListaFilmes.bin");
		file.delete();
		file.createNewFile();

		ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));

		int lastId = list.peekLastId();

		if (lastId > 0) {
			for (int i = 1; i <= lastId; i++) {
				Object obj = list.search(i);
				if (obj != null) {
					objOutput.writeObject(obj);
				}
			}
		} else {
			System.out.println("ERR: Lista Vazia");
		}
		objOutput.close();
	}
	@Override
	public ListInterface<Object> reader() throws IOException, ClassNotFoundException {

		ListInterface<Object> lista = new DoubleList<Object>();

		File file = new File("data/ListaFilmes.bin");

		if (file.exists()) {
			ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));

			Object x;

			try {
				while ((x = objInput.readObject()) != null) {
					lista.addLast(x);
				}
			} catch (EOFException e) {
				//System.out.println("Lista completamente lida!");
			}

			objInput.close();
		}

		return lista;
	}
}
