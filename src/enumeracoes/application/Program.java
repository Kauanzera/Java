package enumeracoes.application;

import java.util.Date;

import enumeracoes.entities.Order;
import enumeracoes.entities.enums.OrderStatus;

public class Program {
	
	public static void main(String[] args) {
		
		//Objeto 'order' do tipo Order com os seguintes valores
		Order order = new Order(1080, new Date(), OrderStatus.PAGAMENTO_PENDENTE);	//Desse modo, o OrderStatus vai imprimir a própria string do PAGAMENTO_PENDENTE 
		
		System.out.println(order);
		
		
		//Conversão de String para Enum:
		
		OrderStatus os1 = OrderStatus.ENTREGUE;
		OrderStatus os2 = OrderStatus.valueOf("ENTREGUE"); //Método usado para converter uma String para um Enum
		
		System.out.printf("%s \n%s", os1, os2);
		
	}

}
