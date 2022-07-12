package it.polito.tdp.food.model;

public class Adiacente implements Comparable<Adiacente> {

	private Food foodA;
	private Double cal;
	
	public Adiacente(Food foodA, double cal) {
		super();
		this.foodA = foodA;
		this.cal = cal;
	}

	public Food getFoodA() {
		return foodA;
	}

	public void setFoodA(Food foodA) {
		this.foodA = foodA;
	}

	public double getCal() {
		return cal;
	}

	public void setCal(double cal) {
		this.cal = cal;
	}

	@Override
	public String toString() {
		return foodA.getDisplay_name()+" "+cal;
	}

	@Override
	public int compareTo(Adiacente o) {
		// TODO Auto-generated method stub
		return -(this.cal.compareTo(o.cal));
		// ordina in verso DECRESCENTE
	}
	
	

	
	
	
	
	
	
}
