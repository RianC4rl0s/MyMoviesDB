package br.com.MyMoviesDB.model.DAO;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.MyMoviesDB.model.VO.ListaFilmesVO;
import structures.DoubleList;
import structures.ListInterface;
import structures.QueueInterface;
import structures.QueueWithList;

public class ListaFilmesDAO {

	// Metodo para escrever a lista de filmes em um arquivo
	public void writer(ListaFilmesVO list) throws IOException {

		File file = new File("data/listas_de_filmes/" + list.getName() + ".bin");
		file.delete();
		file.createNewFile();

		ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));

		int lastId = list.getMovieList().peekLastId();

		if (lastId > 0) {
			for (int i = 1; i <= lastId; i++) {
				Object obj = list.getMovieList().search(i);
				if (obj != null) {
					objOutput.writeObject(obj);
				}
			}
		} else {
			System.out.println("ERR: Lista Vazia");
		}
		objOutput.close();
	}

	// Método para ler a lista de filmes em um arquivo
	public ListaFilmesVO reader(String name) throws IOException, ClassNotFoundException {
		
		ListaFilmesVO listaFilmes = new ListaFilmesVO();
		QueueInterface<Integer> lista = new QueueWithList<Integer>();

		File file = new File("data/listas_de_filmes/" + name + ".bin");

		if (file.exists()) {
			ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));

			Object x;

			try {
				while ((x = objInput.readObject()) != null) {
					lista.add((Integer) x);
				}
			} catch (EOFException e) {
				// System.out.println("Lista completamente lida!");
			}

			listaFilmes.setMovieList(lista);
			listaFilmes.setName(name);
			
			objInput.close();
		}

		return listaFilmes;
	}

	// Método para escrever a lista dos nomes dos arquivos em um arquivo
	public void writer(ListInterface<String> list) throws IOException {

		File file = new File("data/listas_de_filmes/listas.bin");
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

	// Método para ler a lista de nomes dos arquivos de um arquivo
	public ListInterface<String> reader() throws IOException, ClassNotFoundException {

		ListInterface<String> list = new DoubleList<String>();

		File file = new File("data/listas_de_filmes/listas.bin");

		if (file.exists()) {
			ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));

			Object x;

			try {
				while ((x = objInput.readObject()) != null) {
					list.addLast((String) x);
				}
			} catch (EOFException e) {
				// System.out.println("Lista completamente lida!");
			}

			objInput.close();
		}

		return list;
	}

	// Método para deletar o arquivo de uma lista de filmes
	public void delete(String name) throws IOException {
		File file = new File("data/listas_de_filmes/" + name + ".bin");
		file.delete();
	}
}
