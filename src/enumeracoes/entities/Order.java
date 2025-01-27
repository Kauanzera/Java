package enumeracoes.entities;

import java.util.Date;

import enumeracoes.entities.enums.OrderStatus;

public class Order {

	private Integer id; //Id do pedido do tipo Integer
	private Date moment; //Data do pedido do tipo Date
	private OrderStatus status; //Status do pedido do tipo OrderStatus(Enum)
	
	//Método Construtor
	public Order() {
	}

	public Order(Integer id, Date moment, OrderStatus status) {
		this.id = id;
		this.moment = moment;
		this.status = status;
	}
	
	//Getters e Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	
	@Override
	public String toString() {
		return "Order [id=" + id + ", moment=" + moment + ", status=" + status + "]";
	}
	
	
	
}
