package enumeracoes.ex01.application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import enumeracoes.ex01.entities.Department;
import enumeracoes.ex01.entities.HourContract;
import enumeracoes.ex01.entities.Worker;
import enumeracoes.ex01.entities.enums.WorkerLevel;

public class Program {
	public static void main(String[] args) throws ParseException {
		
		//Importações de bibliotecas utilizadas no código
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		//Declaração de como a data deve ser inserida
		
		//Inserção de departamento e dados do funcionário
		System.out.print("Insira o nome do departamento: ");
		String depName = sc.nextLine();
		
		System.out.println("Dados do trabalhador: ");
		System.out.print("Nome: ");
		String workName = sc.nextLine();
		System.out.print("Nível: ");
		String workLevel = sc.nextLine();
		System.out.print("Salário Base: ");
		Double baseSalary = sc.nextDouble();
		
		//Passando os dados informados como argumento para a classe Worker
		Worker worker = new Worker(workName, WorkerLevel.valueOf(workLevel), baseSalary, new Department(depName));
		
		//Calculo de salário por valor/hora
		System.out.printf("\nQuantos contratos o trabalhador terá? -> ");
		int contr = sc.nextInt();
		
		//Contagem de quantidade de contratos
		for (int i = 1; i<=contr; i++) {
			
			System.out.printf("\nInsira os dados do %sº contrato: \n", i);
			
			System.out.print("Insira a data (DD/MM/AAAA): ");
			Date contractDate = sdf.parse(sc.next());			//Leitura da data do contrato realizado
			
			System.out.print("Insira o valor por hora: ");
			double valuePerHour = sc.nextDouble();
			
			System.out.print("Insira a quantidade de horas: ");
			int Hours = sc.nextInt();
			
			//Calculo do salário/hora
			HourContract contract = new HourContract(contractDate, valuePerHour, Hours);
			
			//Adicionar as informações na lista de contratos 'contract'
			worker.addContract(contract);
			
		}
		
		//Solicitação de entrada de data
		System.out.printf("\nEntre com o mês e ano para o calculo do salário (MM/AAAA): ");
		String monYear = sc.next();
		
		//Obtendo os valores de mês em ano, passando de String para inteiros
		int month = Integer.parseInt(monYear.substring(0, 2));
		int year = Integer.parseInt(monYear.substring(3));
		
		//Impressão de informações na tela
		System.out.printf("Nome: %s \n", worker.getName());
		System.out.printf("Departamento: %s \n", worker.getDep().getName());	//Composição de objetos
		System.out.printf("Valor recebido em %s: %.2f", monYear, worker.income(year, month));
		
		
		sc.close();
	}

}
