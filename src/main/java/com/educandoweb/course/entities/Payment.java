package com.educandoweb.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity                     // BANCO H2 É UM BANCO RELACIONAL EM MEMÓRIA 
@Table(name = "tb_payment")    // RENOMEIO A TABELA USER PARA TB_USER POIS USER É UMA PALAVRA RESERVADA DO BANCO H2
public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id   //estes 2 @ é para geração automática da chave Id e dizer que é Banco de Dados
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Instant moment;
	
	@OneToOne
	@MapsId
	private Order order;
	
	public Payment() {
	}

	public Payment(Long id, Instant moment, Order order) {
		super();
		this.id = id;
		this.moment = moment;
		this.order = order;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Payment other = (Payment) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
