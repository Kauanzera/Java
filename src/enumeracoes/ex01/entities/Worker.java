package enumeracoes.ex01.entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import enumeracoes.ex01.entities.enums.WorkerLevel;

public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	
	private Department dep;
	private List<HourContract> contracts = new ArrayList<>();
	//Quando se tiver uma composição 'para muitos', não se inclui a lista dentro do construtor, somente se inicia a lista vazia

	
	//Contrutores
	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department dep) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.dep = dep;
	}

	
	//Acessores
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDep() {
		return dep;
	}

	public void setDep(Department dep) {
		this.dep = dep;
	}

	public List<HourContract> getContract() {
		return contracts;
	}
	
	
	//Adicionar contratos na lista
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	//Remover contratos da lista
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	//Verificação se o mês e ano batem com os dos contratos, informados para calculo de salário valor/hora
	public Double income(int year, int month) {
		
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		
		//Verificação para cada contrato declarado
		for (HourContract c : contracts) {
			
			//Atribuição da data do contrato atual para a variável temporária 'cal' de tipo 'Calendar' 
			cal.setTime(c.getDate());
			
			//Atriuição de ano e mês como números inteiros
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			
			//Condição de verificação do Mês e Ano
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}			
		}
		
		return sum;
		
	}	
}
