package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		String nome;
		double salario, porcentagemEntrada, ps, valorTotal, porcentagemValorTotal, valorMensal, valorFinalpago,
				valorDeEntrada;
		int prestacoes, opcao;

		System.out.println("DIGITE OS DADOS DO FINANCIAMENTO");
		System.out.print("Nome do cliente: ");
		nome = sc.nextLine();

		System.out.print("Salario: ");
		salario = sc.nextDouble();
		while (salario <= 0) {
			System.out.print("O salário não pode ser negativo, digite novamente: ");
			salario = sc.nextDouble();
		}

		System.out.print("Numero de prestacoes: ");
		prestacoes = sc.nextInt();

		System.out.print("Porcentagem de entrada: ");
		porcentagemEntrada = sc.nextDouble();

		System.out.print("Valor total financiado: ");
		valorTotal = sc.nextDouble();

		valorFinalpago = valorTotal - ((valorTotal * porcentagemEntrada) / 100);
		valorMensal = valorFinalpago / prestacoes;
		porcentagemValorTotal = (valorMensal * 30) / 100;
		ps = (salario * 30) / 100;
		
		valorDeEntrada = valorTotal - valorFinalpago;
		
		while (porcentagemValorTotal > ps) {
			System.out.println("O valor total financiado não foi aceito pois cada mensalidade passa 30% do"
					+ " seu salario, por favor insira um novo valor total financiado");
			System.out.print("Valor total financiado: ");
			valorTotal = sc.nextDouble();

			valorFinalpago = valorTotal - ((valorTotal * porcentagemEntrada) / 100);
			valorMensal = valorFinalpago / prestacoes;
			porcentagemValorTotal = (valorMensal * 30) / 100;
			ps = (salario * 30) / 100;
		}

		System.out.println();
		System.out.println("MENU:");
		do {
			System.out.println("1 - Mostrar valor da entrada");
			System.out.println("2 - Mostrar o valor financiado");
			System.out.println("3 - Mostrar valor de cada prestação");
			System.out.println("4 - Sair");
			System.out.print("Digite uma opcao: ");
			opcao = sc.nextInt();
			System.out.println();

			if (opcao == 1) {
				System.out.println("ENTRADA :" + valorDeEntrada);
				System.out.println();
			} else if (opcao == 2) {
				System.out.println("VALOR FINANCIADO: " + valorFinalpago);
				System.out.println();
			} else if (opcao == 3) {
				System.out.printf("VALOR DE CADA PRESTAÇÃO: %.2f%n", valorMensal);
				System.out.println();
			}
		} while (opcao != 4);

		System.out.println("FIM DO PROGRAMA!");
		sc.close();
	}

}
