package hh.sof03.backendPractice.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Amount {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long amountId;
	private double number;
	
public Amount() {}

public Amount(double number) {
	super();
	this.number = number;
}

public Long getAmountId() {
	return amountId;
}

public void setAmountId(Long amountId) {
	this.amountId = amountId;
}

public double getNumber() {
	return number;
}

public void setNumber(double number) {
	this.number = number;
}

@Override
public String toString() {
	return "Amount [amountId=" + amountId + ", number=" + number + "]";
}

}
