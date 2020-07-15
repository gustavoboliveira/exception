package application;

import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Program {

	public static void main(String[] args) throws DomainException{
		
		Scanner sc = new Scanner (System.in);
		
		try {
			System.out.println("Encontre com os dados da conta:");
			System.out.printf("Número: ");
			int numero = sc.nextInt();
			sc.nextLine();
			System.out.printf("Nome: ");
			String nome = sc.nextLine();
			System.out.printf("Saldo Inicial: R$ ");
			double saldoConta = sc.nextDouble();
			System.out.printf("Limite de Saque: R$ ");
			double limiteSaque = sc.nextDouble();

			Account conta = new Account(numero, nome, saldoConta, limiteSaque);

			System.out.println();
			System.out.printf("Insira valor para saque: R$ ");
			double valor = sc.nextDouble();
			conta.saque(valor);

			System.out.println();
			System.out.println(conta);
		}
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		catch (RuntimeException e) {
			System.out.println("Erro inesperado.");
		}
		
		sc.close();
	}
}
