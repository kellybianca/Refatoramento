package models;

import java.util.ArrayList;
import java.util.Scanner;

import excessoes.TratandoExcessoes;
import interfaceModels.IGerenciador;
import modelPacoteAssinatura.PacotesAssinatura;
import modelTipoPagamento.Boleto;
import modelTipoPagamento.Cartao;
import repository.GerenciadorFilmes;
import repository.GerenciadorPacotes;
import repository.GerenciadorSeries;
import repository.GerenciadorTipoPagamento;
import repository.GerenciadorUser;
import videos.Filmes;
import videos.Series;

public class Login {

	Scanner input = new Scanner(System.in);

	int opcoes = 0;

	TratandoExcessoes excessoes = new TratandoExcessoes();
	ArrayList<TipoPagamento> tipoPagamento = new ArrayList<>();
	ArrayList<IGerenciador> dadosUsuario = new ArrayList<>();
	GerenciadorUser gerenciaUser = new GerenciadorUser();
	GerenciadorFilmes gerenciaFilmes = new GerenciadorFilmes();
	GerenciadorSeries gerenciadorSeries = new GerenciadorSeries();
	GerenciadorTipoPagamento gerenciadorTipoPagamento = new GerenciadorTipoPagamento();
	GerenciadorPacotes gerenciadorPacotes = new GerenciadorPacotes();
	PacotesAssinatura pacotes = new PacotesAssinatura();

	public void opcoes() {

		System.out.println("\n\nBem vindo a sua conta ");
		System.out.println("Escolha uma das opcoes abaixo: ");
		System.out.println("(1) Editar Perfil");
		System.out.println("(2) Remover Perfil");
		System.out.println("(3) Mostrar informacoes da conta");
		System.out.println("(4) Pacote de assinatura");
		System.out.println("(5) Cadastrar Filmes/Series");
		System.out.println("(6) Remover Filmes/Series");
		System.out.println("(7) Buscar Filmes/Series");
		System.out.println("(8) Pagamento");
		System.out.println("(9) Sair");
	}

	public void login(GerenciadorUser gerenciar, User user) {

		opcoes();
		opcoes = excessoes.lerInteiro(opcoes);

		while (true) {
			if (opcoes == 1) {
				System.out.println("Alterar dados do Usuario");
				System.out.println("Digite o nome do usuario que vc deseja alterar: ");
				String nome = input.nextLine();
				gerenciar.editar(nome);

			} else if (opcoes == 2) {
				System.out.println("Apagar Usuario");
				System.out.println("Voce tem certeza que deseja remover esse usuario? :(\n(1) Sim\n(2) Nao\n");
				int op = 0;
				op = excessoes.lerInteiro(op);

				if (op == 1) {
					System.out.println("Digite o nome do usuario que vc deseja remover: ");
					String nome = input.nextLine();
					gerenciar.apagar(nome);
				} else if (op == 2) {
					System.out.println("Voltando para o menu principal ... ");
				} else {
					System.out.println("Opcao nao encontrada");
				}

			} else if (opcoes == 3) {
				System.out.println("\n\n-------------------------\n");
				System.out.println("\n\nInformacoes do Usuario\n");
				gerenciar.listar();
				System.out.println("\n\n-------------------------\n\tFilmes");
				gerenciaFilmes.listar();
				System.out.println("\n\n-------------------------\n\tSerie");
				gerenciadorSeries.listar();
				System.out.println("\n\n-------------------------\n\tPacotes de assinatura");
				gerenciadorPacotes.listar();
				System.out.println("\n\n-------------------------\n\tPagamento");
				gerenciadorTipoPagamento.listar();

			} else if (opcoes == 4) {
				System.out.println("Bem vindo aos Pacotes de Assinatura");
				System.out.println("Escolha umas das opcoes abaixo: \n(1) Cadastrar\n(2) Remover");
				int pa = 0;
				pa = excessoes.lerInteiro(pa);

				if (pa == 1) {
					System.out.println("\n\n(1) Basico\n apenas uma tela por vez, sem resolucao HD, R$ 19,90");
					System.out.println("\n\n(2) Padrao\n duas telas simultaneas, resolucao HD (Full-HD em alguns casos), R$ 27,90");
					System.out.println("\n\n(3) Premium\n quatro telas simultaneas, resolucao 4K, sem HDR, R$ 37,90");
					pa = excessoes.lerInteiro(pa);
					if (pa == 1) {
						pacotes.basico();
						gerenciadorPacotes.adicionar(pacotes);
					} else if (pa == 2) {
						pacotes.padrao();
						gerenciadorPacotes.adicionar(pacotes);
					} else if (pa == 3) {					
						pacotes.premium();
						gerenciadorPacotes.adicionar(pacotes);
					}
				} 
				else if (pa == 2) {
					System.out.println("Tem certeza que deseja remover o seu pacote? :(\n(1) Sim\n(2) Nao");
					pa = excessoes.lerInteiro(pa);
					if (pa == 1) {
						gerenciadorPacotes.apagar(null);
					} else if (pa == 2) {
						System.out.println("Voltando para o menu principal");
					} else {
						System.out.println("opcao invalida");
					}
				} else {
					System.out.println("opacao invalida");
				}
			}

			else if (opcoes == 5) {
				System.out.println("\n\nCadastrar Filmes/Series");
				System.out.println("(1) Cadastrar filmes\n(2) Cadastrar Series");
				int op = 0;
				op = excessoes.lerInteiro(op);

				if (op == 1) {
					System.out.println("Digite o nome do filme");
					String nomeFilme = input.nextLine();
					System.out.println("Digite a categoria do filme");
					String categoria = input.nextLine();
					System.out.println("Digite a duracao do filme");
					int duracao = 0;
					duracao = excessoes.lerInteiro(duracao);

					Filmes filme = new Filmes(nomeFilme, categoria, duracao);
					gerenciaFilmes.adicionar(filme);
					gerenciaFilmes.listar();
				} 
				else if (op == 2) {
					System.out.println("Digite o nome da Serie");
					String nomeSerie = input.nextLine();
					System.out.println("Digite a categoria da Serie");
					String categoria = input.nextLine();
					System.out.println("Digite a quantidade de temporadas");
					int temporadas = 0;
					temporadas = excessoes.lerInteiro(temporadas);

					Series serie = new Series(categoria, nomeSerie, temporadas);
					gerenciadorSeries.cadastrarSeries(serie);
					gerenciadorSeries.listar();
				} else {
					System.out.println("Opcao inexistente");
				}
			}

			else if (opcoes == 6) {
				System.out.println("\n\nRemover Filmes/Series");
				System.out.println("(1) Remover filmes\n(2) Remover Series");
				int op = 0;
				op = excessoes.lerInteiro(op);

				if (op == 1) {
					System.out.println("Digite o nome do filme");
					String nomeFilme = input.nextLine();
					gerenciaFilmes.apagar(nomeFilme);

				} else if (op == 2) {
					System.out.println("Digite o nome da serie");
					String nomeSerie = input.nextLine();
					gerenciadorSeries.apagar(nomeSerie);
				}
			}

			else if (opcoes == 7) {
				System.out.println("Buscar Filmes/Series");
				System.out.println("(1) Buscar filmes\n(2) Buscar Series");
				int op = 0;
				op = excessoes.lerInteiro(op);
				if (op == 1) {
					gerenciaFilmes.listar();
				} else if (op == 2) {
					gerenciadorSeries.listar();
				}
			}

			else if (opcoes == 8) {
				
				
				System.out.println("\n\nDados do pagamento");
				System.out.println("Digite a data do vencimento: ");
				String data = input.nextLine();
				System.out.println("Informe o tipo de Pacote de assinatura; ");
				System.out.println("(1) Basico\n(2) Padrao\n(3) Premium");
				
				int tipo = 0;
				tipo = excessoes.lerInteiro(tipo);
				Double value = (double) 0;
				
				if (tipo == 1) {
					value = 19.90;
				} else if (tipo == 2) {
					value = 27.90;
				} else if (tipo == 3) {
					value = 37.90;
				} else {
					System.out.println("Opcao inexistente");
				}

				System.out.println("Digite a forma de pagamento: \n(1) Boleto\n(2)Cartao");
				int op = 0;
				op = excessoes.lerInteiro(op);

				if (op == 1) {
					Boleto boleto = new Boleto(data, value);
					System.out.println("Informe seu endereco: ");
					boleto.setEndereco(input.nextLine());
					System.out.println("Informe seu bairro: ");
					boleto.setBairro(input.nextLine());
					
					
					gerenciadorTipoPagamento.adicionandoTipo(boleto);

					System.out.println("\tDados do pagamento");
					System.out.println("*******************************");
					System.out.println("Nome: " + user.nome);
					System.out.println("CPF: " + user.getCpf());
					System.out.println("Forma de pagamento: Boleto");
					System.out.println("Enderenco: " + boleto.getEndereco());
					System.out.println("Bairro: " + boleto.getBairro());
					System.out.println("Valor: " + boleto.getValor());
					System.out.println("Data do vencimento: " + boleto.getDataVencimento());
					System.out.println("*******************************");

				} else if (op == 2) {
					Cartao cartao = new Cartao(data, value);
					System.out.println("Informe os dados do cartao");
					System.out.println("Bandeira do cartao: ");
					cartao.setBandeira(input.nextLine());
					System.out.println("Numero do cartao: ");
					cartao.setCodigo(input.nextLine());
					System.out.println("Data de validade do cartao: ");
					cartao.setDataVencimento(input.nextLine());
					System.out.println("Codigo de seguranca: ");
					cartao.setCodigo(input.nextLine());

					gerenciadorTipoPagamento.adicionandoTipo(cartao);

					System.out.println("\tDados do pagamento");
					System.out.println("*******************************");
					System.out.println("Nome: " + user.nome);
					System.out.println("CPF: " + user.getCpf());
					System.out.println("Forma de pagamento: Cartão");
					System.out.println("Bandeira: " + cartao.getBandeira());
					System.out.println("Numero do cartao: " + cartao.getNumeroCartao());
					System.out.println("Data de validade do cartao: " + cartao.getDataVencimento());
					System.out.println("Codigo de seguranca: " + cartao.getCodigo());
					System.out.println("Valor: " + cartao.getValor());
					System.out.println("Data de vencimento: " + cartao.getDataVencimento());
					System.out.println("*******************************");

				} else {
					System.out.println("Opcao inexistente");
				}
			} else if (opcoes == 9) {
				break;
			} else {
				System.out.println("Opcao invalida");
			}
			opcoes();
			opcoes = excessoes.lerInteiro(opcoes);
		}

	}

}