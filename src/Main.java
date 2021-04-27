import java.util.Calendar;
import java.util.Scanner;

import br.com.MyMoviesDB.model.BO.AvaliacaoBO;
import br.com.MyMoviesDB.model.BO.BaseInterBO;
import br.com.MyMoviesDB.model.BO.FilmeBO;
import br.com.MyMoviesDB.model.VO.AvaliacaoVO;
import br.com.MyMoviesDB.model.VO.FilmeVO;

public class Main {

	public static void main(String[] args) {

		int opc = 0;
		Scanner cin = new Scanner(System.in);

		BaseInterBO<FilmeVO> filmeBO = new FilmeBO();
		BaseInterBO<AvaliacaoVO> avaliacaoBO = new AvaliacaoBO();

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
			//=====================================================
			//FILME
			//=====================================================
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
			//======================================================
			//AVALIAÇÕES
			//======================================================
			case 3:{
			
				int opcF;
				System.out.println();
				System.out.println("======= Avaliações =======");
				System.out.println("1 - Avaliar");
				System.out.println("2 - Editar");
				System.out.println("3 - Deletar");
				System.out.println("4 - Listar");
				System.out.print("\nEscolha uma opção: ");

				opcF = cin.nextInt();
				cin.nextLine();
				switch (opcF) {
				case 1: {
					System.out.println();
					System.out.println("= Avaliar =");
					AvaliacaoVO avaliacao = new AvaliacaoVO();
					
					System.out.println("Digite o id do filme desejado");
					System.out.println(1);
					int movieID = cin.nextInt();
					if(filmeBO.search(1) != null) {
						System.out.println(1);
						avaliacao.setMovie(movieID);
						cin.nextLine();
						System.out.println(1);
						System.out.println("Digite sua critica: ");
						avaliacao.setCriticism(cin.nextLine());
						
						
						avaliacao.setDate(Calendar.getInstance());
						System.out.println("Digite a nota do filme: ");
						double evaluate = cin.nextDouble();
						
						avaliacao.setEvaluation(evaluate);
						
						FilmeVO m = filmeBO.search(movieID);
						String ge = m.getGeneralEvaluation();
						
						if(ge.matches("N/A")) {
							m.setGeneralEvaluation( Double.toString( evaluate));
							filmeBO.update(m, movieID);
						}else {
							ge = Double.toString((Double.parseDouble(ge) + evaluate)/2);
							m.setGeneralEvaluation(ge);
							filmeBO.update(m, movieID);
						}
						
						avaliacao.setEvaluator(1);
						
						avaliacaoBO.create(avaliacao);
					}else {
						System.out.println("Filme não encontrado!");
						System.out.println();
					}
					
					break;
				}case 2: {
					System.out.println();
					System.out.println("========== EDITAR AVALIAÇÂO =========");
					AvaliacaoVO avaliacao = new AvaliacaoVO();
					
					
						
						int avaliacaoID = cin.nextInt();
						cin.nextLine();
						if(avaliacaoBO.search(avaliacaoID) != null) {
							System.out.println("Digite o id do filme desejado");
							
							int movieID = cin.nextInt();
							if(filmeBO.search(movieID) != null) {

								avaliacao.setMovie(cin.nextInt());
								cin.nextLine();
								
								System.out.println("Digite sua critica: ");
								avaliacao.setCriticism(cin.nextLine());
								
								
								avaliacao.setDate(Calendar.getInstance());
								System.out.println("Digite a nota do filme: ");
								avaliacao.setEvaluation(cin.nextDouble());
								avaliacao.setEvaluator(1);
								
								
							avaliacaoBO.update(avaliacao, avaliacaoID);
						}
						
						
					}else {
						System.out.println("Filme não encontrado!");
						System.out.println();
					}
					
					break;
				}
				case 3:{
					System.out.println();
					System.out.println("= DELETAR AVALIAÇÃO =");
					System.out.println("Digite o id da avaliação a ser deletada");
					int avaliacaoID = cin.nextInt();
					cin.nextLine();
					if(avaliacaoBO.search(avaliacaoID) != null) {
						System.out.println("Realmente deseja apagar a avaliação: Sim(s), Não(qualquer valor)");
						char confirm = cin.next().charAt(0);
						if(confirm == 'S' || confirm == 's') {
							avaliacaoBO.delete(avaliacaoID);
						}else {
							System.out.println("Operação cancelada");
						}
						
					}else {
						System.out.println("Id de valiação invalido");
					}
					
					
					break;
				}
				case 4:{
					System.out.println();
					System.out.println("= LISTAR AVALIAÇÕES =");
					
					avaliacaoBO.read();
					System.out.println();
					break;
				}
				default:
					System.out.println("Opção invalida!!!");
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
