package aplicacao;

import java.util.Locale;
import java.util.Scanner;

public class programa {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		String nome;
		double salario, porcentagemEntrada, ps, valorTotal, porcentagemValorTotal, valorMensal, valorFinalpago;
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
		
		do {
		valorFinalpago = valorTotal - ((valorTotal * porcentagemEntrada)/100);
		System.out.println("Valor apos a porcentagem de entrada :" +valorFinalpago);
		valorMensal = valorFinalpago / prestacoes;
		System.out.println("valor de casa prestacao : " + valorMensal);
		porcentagemValorTotal = (valorMensal * 30)/ 100;
		System.out.println("trinta por cento do valor pago mensalmente " + porcentagemValorTotal);
		ps = (salario * 30)/100;
		System.out.println("trinta por cento do salario mensal : " +  ps);
		} while (porcentagemValorTotal > ps);
		
		
		sc.close();
	}

}
