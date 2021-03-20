# MyMoviesDB 	:movie_camera: :film_strip:
### Programa em Java para gerenciamento pessoal de filmes/séries.

O programa MyMoviesDB tem o objetivo de armazenar e exibir avalições sobre produções de cinema através de arquivos. Ele é capaz de:

### **Cadastrar, consultar, atualizar e deletar:** 
- Filmes (Título, Ano, Faixa Etária, Gênero, Duração, Ano, Diretor, Descrição, Nota Geral);
- Avaliações (Avaliador, Data, Nota (0.00 a 10.00), Crítica, Filme);
- Avaliadores (Nome, Idade).
- Listas de Filmes (Id da Lista, Filmes).

## Obervações: :warning:
- Exibe N/A (nenhuma avaliação) na Nota Geral caso não tenha nenhuma avaliação.
- O programa exibe listas de Filmes ordenadas pela Nota Geral (da maior para menor);
- O programa exibe Avaliações dos filmes ordenadas pela Data (da mais recente para a mais antiga);
- A lista de filmes serve como uma lista para os filmes que o usuário quer assistir, funcionando como uma fila e dando prioridade ao primeiro filme.
- O programa não consulta com interface gráfica. Seu uso se restringe ao terminal.

O sistema tem sua estrutura baseada na arquitetura MVC, entretanto, devido à sua simplicidade e sem a necessidade de interface gráfica, apenas o pacote para modelagem dos dados é implementado. O pacote Model está dividido entre os pacotes DAO(Data Access Object), BO(Business Object) e VO(Value Object). É desenvolvido utilizando Java 8 no Eclipse IDE.
