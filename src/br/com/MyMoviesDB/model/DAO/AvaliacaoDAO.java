package br.com.MyMoviesDB.model.DAO;

//import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import structures.DoubleList;
import structures.ListInterface;


public class AvaliacaoDAO implements BaseInterDAO<ListInterface<Object>>{
	
	//private String pathBin = "data/rtData.bin";
	//private String pathCSV = "data/rtCSVdata.csv";
	
	
	@Override
	public void writer(ListInterface<Object> list) throws IOException {

		File file = new File("data/rtData.bin");
		file.delete();
		file.createNewFile();

		ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));
/*<<<<<<< HEAD

		for (int i = 1; i <= list.getSize(); i++) {
			objOutput.writeObject(list.search(i));
=======*/
		
		for (int i = 0; i < list.getSize();i++) {
			Object obj = list.search(i);
			if (obj != null) {
				objOutput.writeObject(obj);
			}
//>>>>>>> aac2588f1f03bab22bb22368cfac7172a4e2fbd2
		}

		objOutput.close();
	}
	@Override
	public ListInterface<Object> reader() throws IOException, ClassNotFoundException {

		ListInterface<Object> list = new DoubleList<Object>();

		File file = new File("data/rtData.bin");

		if (file.exists()) {
			ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));

			Object x;

			try {
				while ((x = objInput.readObject()) != null) {
					list.addFirst(x);
				}
			} catch (EOFException e) {
				//System.out.println("Lista completamente lida!");
			}

			objInput.close();
		}

		return list;
	}
	/*
	public String textReader() throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(pathCSV));
		StringBuffer sB = new StringBuffer();
		String line = "";
		while(line != null) {
			sB.append(line + "\n");
			line = br.readLine();
		}
		br.close();
		return sB.toString();
	}
	public void textWriter(String text) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(pathCSV));
		bw.append(text);
		bw.close();
	}*/
}
