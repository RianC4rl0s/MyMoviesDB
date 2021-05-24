package CreateKeyData;

import java.io.IOException;

import br.com.MyMoviesDB.model.DAO.KeyDataDAO;
import br.com.MyMoviesDB.model.VO.KeyData;

public class CreateKeyData {

	public static void main(String[] args) {
		KeyData kd = new KeyData();
		KeyDataDAO dao = new KeyDataDAO();
		
		
		kd.setAvaliatorkey(1);
		kd.setAvaliatorkey(1);
		kd.setMovieKey(1);
		
		try {
			dao.writer(kd);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
