import java.util.Calendar;
import java.util.Scanner;

import br.com.MyMoviesDB.model.BO.AvaliacaoBO;
import br.com.MyMoviesDB.model.BO.AvaliadorBO;
import br.com.MyMoviesDB.model.BO.BaseInterBO;
import br.com.MyMoviesDB.model.BO.FilmeBO;
import br.com.MyMoviesDB.model.VO.AvaliacaoVO;
import br.com.MyMoviesDB.model.VO.AvaliadorVO;
import br.com.MyMoviesDB.model.VO.FilmeVO;

public class Main {

	public static void main(String[] args) {

		int opc = 0;
		Scanner cin = new Scanner(System.in);

		BaseInterBO<AvaliacaoVO> avaliacaoBO = new AvaliacaoBO();
		AvaliadorBO avaliadorBO = new AvaliadorBO();
		FilmeBO filmeBO = new FilmeBO();

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
			// =====================================================
			// FILME
			// =====================================================
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
			// ======================================================
			// AVALIADORES
			// ======================================================
			case 2: {

				int opcF;

				System.out.println();
				System.out.println("==== AVALIADORES ====");
				System.out.println("1 - Cadastrar");
				System.out.println("2 - Editar");
				System.out.println("3 - Deletar");
				System.out.println("4 - Listar");
				System.out.print("\nEscolha uma opção: ");

				opcF = cin.nextInt();
				cin.nextLine();

				switch (opcF) {

				case 1: {

					AvaliadorVO evaluator = new AvaliadorVO();

					System.out.println();
					System.out.println("= CADASTRAR AVALIADOR =");

					System.out.print("Nome: ");
					evaluator.setName(cin.nextLine());
					System.out.print("Idade: ");
					evaluator.setAge(cin.nextInt());

					cin.nextLine();

					avaliadorBO.create(evaluator);

					System.out.println();

					break;
				}

				case 2: {

					AvaliadorVO evaluator = new AvaliadorVO();

					System.out.println();
					System.out.println("= EDITAR AVALIADOR =");
					avaliadorBO.read();

					System.out.print("Escolha o avaliador a ser editado pelo id: ");
					int id = cin.nextInt();
					cin.nextLine();

					if (avaliadorBO.search(id) != null) {

						System.out.println("Digite as novas informações: ");

						System.out.print("Nome: ");
						evaluator.setName(cin.nextLine());
						System.out.print("Idade: ");
						evaluator.setAge(cin.nextInt());

						cin.nextLine();

						avaliadorBO.update(evaluator, id);

						System.out.println();
					} else {
						System.out.println("Avaliador não encontrado!");
						System.out.println();
					}

					break;
				}

				case 3: {

					System.out.println();
					System.out.println("= DELETAR AVALIADOR =");
					avaliadorBO.read();

					System.out.print("Escolha o avaliador a ser deletado pelo id: ");
					int id = cin.nextInt();
					cin.nextLine();

					if (avaliadorBO.search(id) != null) {

						System.out.print("Tem certeza que deseja deletar? S - 1/N - 0 ");
						int resp = cin.nextInt();

						if (resp == 1) {
							avaliadorBO.delete(id);
						}

						System.out.println();
					} else {
						System.out.println("Avaliador não encontrado!");
						System.out.println();
					}

					break;
				}

				case 4: {

					System.out.println();
					System.out.println("= LISTAR AVALIADORES =");
					avaliadorBO.read();
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
			// ======================================================
			// AVALIAÇÕES
			// ======================================================
			case 3: {

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
					System.out.println("= AVALIAR =");
					AvaliacaoVO avaliacao = new AvaliacaoVO();

					filmeBO.read();

					System.out.println("Digite o id do filme desejado");

					int movieID = cin.nextInt();
					FilmeVO movie = filmeBO.search(movieID);

					if (movie != null) {

						avaliacao.setMovie(movie.getKey());
						cin.nextLine();

						System.out.println("Digite sua critica: ");
						avaliacao.setCriticism(cin.nextLine());
						avaliacao.setDate(Calendar.getInstance());

						System.out.println("Digite a nota do filme(0-10): ");
						double evaluate = cin.nextDouble();

						avaliacao.setEvaluation(evaluate);
						
						movie.setSumEvaluations(movie.getSumEvaluations() + evaluate); // Soma das avaliações
						movie.setEvaluationQt(movie.getEvaluationQt() + 1); // Quantidade das avaliações
						
						movie.setGeneralEvaluation();	// Setando nova média

						System.out.println("Digite sua chave de avaliador: ");
						int evaluatorKey = cin.nextInt();

						if (avaliadorBO.searchByKey(evaluatorKey) != null) {
							avaliacao.setEvaluator(evaluatorKey);
							filmeBO.update(movie, movieID);
							avaliacaoBO.create(avaliacao);
						} else {
							System.out.println("ERR: Avaliador Inválido");
						}

					} else {
						System.out.println("ERR: Filme não encontrado!");
						System.out.println();
					}

					break;
				}
				case 2: {
					System.out.println();
					System.out.println("= EDITAR AVALIAÇÂO =");

					AvaliacaoVO avaliacao;

					avaliacaoBO.read();

					System.out.println("Digite o id da avaliação a ser editada: ");
					int avaliacaoID = cin.nextInt();
					cin.nextLine();

					avaliacao = avaliacaoBO.search(avaliacaoID);

					if (avaliacao != null) {

						int movieKey = avaliacao.getMovie();
						FilmeVO movie = filmeBO.searchByKey(movieKey);
						char confirmar;

						System.out.println("Deseja editar critica? Sim(s), Não(Qualquer tecla)");
						confirmar = cin.next().charAt(0);
						if (confirmar == 'S' || confirmar == 's') {
							System.out.println("Digite sua critica: ");
							avaliacao.setCriticism(cin.nextLine());
						}

						// avaliacao.setDate(Calendar.getInstance());

						System.out.println("Deseja editar a nota? Sim(s), Não(Qualquer tecla)");
						confirmar = cin.next().charAt(0);

						if (confirmar == 'S' || confirmar == 's') {

							System.out.println("Digite a nota do filme(0-10): ");
							double evaluate = cin.nextDouble();
							
							double oldEvaluate = avaliacao.getEvaluation();
							
							avaliacao.setEvaluation(evaluate);

							movie.setSumEvaluations(movie.getSumEvaluations() - oldEvaluate); // Diminuindo a nota antiga na soma das avaliações
							movie.setSumEvaluations(movie.getSumEvaluations() + evaluate); // Somando com novo valor com a soma
							
							movie.setGeneralEvaluation(); // Setando nova média

							System.out.println("Digite seu id de valiador: ");
							int evaluatorKey = cin.nextInt();

							if (avaliadorBO.searchByKey(evaluatorKey) != null) {
								avaliacao.setEvaluator(evaluatorKey);
								filmeBO.update(movie, filmeBO.searchId(movieKey));
								avaliacaoBO.create(avaliacao);
							} else {
								System.out.println("ERR: Avaliador Inválido");
							}
						}

					} else {
						System.out.println("Avaliação não encontrada!");
						System.out.println();
					}

					break;
				}
				case 3: {
					System.out.println();
					System.out.println("= DELETAR AVALIAÇÃO =");

					avaliacaoBO.read();

					System.out.println("Digite o id da avaliação a ser deletada");
					int avaliacaoID = cin.nextInt();
					cin.nextLine();

					AvaliacaoVO avaliacao = avaliacaoBO.search(avaliacaoID);

					if (avaliacao != null) {
						System.out.println("Realmente deseja apagar a avaliação: Sim(s), Não(qualquer valor)");
						char confirm = cin.next().charAt(0);

						if (confirm == 'S' || confirm == 's') {

							// Pegando informações do filme daquela avaliação para restaurar a nota geral
							int movieKey = avaliacao.getMovie();
							FilmeVO movie = filmeBO.searchByKey(movieKey);
							
							movie.setSumEvaluations(movie.getSumEvaluations() - avaliacao.getEvaluation()); // Diminuindo a nota na soma das avaliações
							movie.setEvaluationQt(movie.getEvaluationQt() - 1); // Diminuindo a quantidade de avaliações do filme
							
							movie.setGeneralEvaluation(); // Setando nova média

							filmeBO.update(movie, filmeBO.searchId(movieKey));

						} else {
							System.out.println("Operação cancelada");
						}

					} else {
						System.out.println("ERR: Id de valiação invalido");
					}

					break;
				}
				case 4: {
					System.out.println();
					System.out.println("= LISTAR AVALIAÇÕES =");

					avaliacaoBO.read();

					System.out.println();
					break;
				}
				default:
					System.out.println("ERR: Opção invalida!!!");
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
