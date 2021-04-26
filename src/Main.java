import br.com.MyMoviesDB.model.BO.FilmeBO;
import br.com.MyMoviesDB.model.VO.FilmeVO;

public class Main {

	public static void main(String[] args) {
		
		FilmeVO vo = new FilmeVO();
		vo.setTitle("Karate Kit");
		
		FilmeBO fBo = new FilmeBO();
		
		//fBo.create(vo);

		fBo.read();
	}

}
