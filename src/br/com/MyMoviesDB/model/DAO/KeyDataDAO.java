package br.com.MyMoviesDB.model.DAO;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import br.com.MyMoviesDB.model.VO.KeyData;


public class KeyDataDAO  implements BaseInterDAO<KeyData> {
	@Override
	public void writer(KeyData kd) throws IOException {

		File file = new File("data/keyData.bin");
		file.delete();
		file.createNewFile();

		ObjectOutputStream objOutput = new ObjectOutputStream(new FileOutputStream(file));

		

		if (kd != null) {
			
			Object obj = kd;
			if (obj != null) {
				objOutput.writeObject(obj);
			}
			
		} else {
			System.out.println("ERR: Lista Vazia");
		}

		objOutput.close();
	}

	@Override
	public KeyData reader() throws IOException, ClassNotFoundException {


		File file = new File("data/keyData.bin");

		KeyData kd = new KeyData();
		
		if (file.exists()) {
			ObjectInputStream objInput = new ObjectInputStream(new FileInputStream(file));

			Object x;

			
			
			try {
				while ((x = objInput.readObject()) != null) {
					kd = (KeyData) x;
				}
				
			} catch (EOFException e) {
				// System.out.println("Lista completamente lida!");
			}

			objInput.close();
		}

		return kd;
	}

}
