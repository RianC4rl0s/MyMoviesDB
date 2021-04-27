import java.util.Scanner;

import br.com.MyMoviesDB.model.BO.BaseInterBO;
import br.com.MyMoviesDB.model.BO.FilmeBO;
import br.com.MyMoviesDB.model.VO.FilmeVO;

public class Main {

	public static void main(String[] args) {

		int opc = 0;
		Scanner cin = new Scanner(System.in);

		BaseInterBO<FilmeVO> filmeBO = new FilmeBO();

		do {

			System.out.println("======== MENU ========");
			System.out.println("1 - Filmes");
			System.out.println("2 - Avaliadores");
			System.out.println("3 - Avaliações");
			System.out.println("4 - Listas de Filmes");
			System.out.println("5 - Sair");
			System.out.print("\nEscolha uma opção: ");

			opc = cin.nextInt();

			switch (opc) {

			case 1: {

				int opcF;

				System.out.println();
				System.out.println("======= FILMES =======");
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Editar");
				System.out.println("3 - Deletar");
				System.out.println("4 - Listar");
				System.out.print("\nEscolha uma opção: ");

				opcF = cin.nextInt();
				cin.nextLine();

				switch (opcF) {

				case 1: {

					FilmeVO movie = new FilmeVO();

					System.out.println();
					System.out.println("= CADASTRAR FILME =");

					System.out.print("Título: ");
					movie.setTitle(cin.nextLine());
					System.out.print("Gênero: ");
					movie.setGenre(cin.nextLine());
					System.out.print("Duração: ");
					movie.setDurationTime(cin.nextLine());
					System.out.print("Diretor: ");
					movie.setDirector(cin.nextLine());
					System.out.print("Descrição: ");
					movie.setDescription(cin.nextLine());

					System.out.print("Ano: ");
					movie.setYear(cin.nextInt());
					System.out.print("Faixa Etária: ");
					movie.setAgeRange(cin.nextInt());

					movie.setGeneralEvaluation("N/A");

					filmeBO.create(movie);

					System.out.println();
					
					break;
				}

				case 2: {

					FilmeVO movie = new FilmeVO();

					System.out.println();
					System.out.println("= EDITAR FILME =");
					filmeBO.read();

					System.out.print("Escolha o filme a ser editado pelo id: ");
					int id = cin.nextInt();
					cin.nextLine();

					if (filmeBO.search(id) != null) {

						System.out.println("Digite as novas informações: ");

						System.out.print("Título: ");
						movie.setTitle(cin.nextLine());
						System.out.print("Gênero: ");
						movie.setGenre(cin.nextLine());
						System.out.print("Duração: ");
						movie.setDurationTime(cin.nextLine());
						System.out.print("Diretor: ");
						movie.setDirector(cin.nextLine());
						System.out.print("Descrição: ");
						movie.setDescription(cin.nextLine());

						System.out.print("Ano: ");
						movie.setYear(cin.nextInt());
						System.out.print("Faixa Etária: ");
						movie.setAgeRange(cin.nextInt());

						filmeBO.update(movie, id);

						System.out.println();
					} else {
						System.out.println("Filme não encontrado!");
						System.out.println();
					}
					
					break;
				}

				case 3: {

					System.out.println();
					System.out.println("= DELETAR FILME =");
					filmeBO.read();

					System.out.print("Escolha o filme a ser deletado pelo id: ");
					int id = cin.nextInt();
					cin.nextLine();

					if (filmeBO.search(id) != null) {

						System.out.print("Tem certeza que deseja deletar? S - 1/N - 0");
						int resp = cin.nextInt();

						if (resp == 1) {
							filmeBO.delete(id);
						}

						System.out.println();
					} else {
						System.out.println("Filme não encontrado!");
						System.out.println();
					}
					
					break;
				}

				case 4: {

					System.out.println();
					System.out.println("= LISTAR FILME =");
					filmeBO.read();
					System.out.println();
					
					break;
				}

				default: {
					System.out.println("Entrada Inválida");
					System.out.println();
				}

				}
				
				break;
			}
			
			case 5: {
				System.out.println("Operação finalizada!");
				System.out.println();
				
				break;
			}

			default: {
				System.out.println("Entrada Inválida");
				System.out.println();
			}

			}

		} while (opc != 5);

		cin.close();
	}

}
