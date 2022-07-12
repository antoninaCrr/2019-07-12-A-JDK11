package it.polito.tdp.food.model;

public class Edge {

	private Food food1;
	private Food food2;
	private double calorie;
	
	
	public Edge(Food food1, Food food2, double calorie) {
		super();
		this.food1 = food1;
		this.food2 = food2;
		this.calorie = calorie;
	}


	public Food getFood1() {
		return food1;
	}


	public void setFood1(Food food1) {
		this.food1 = food1;
	}


	public Food getFood2() {
		return food2;
	}


	public void setFood2(Food food2) {
		this.food2 = food2;
	}


	public double getCalorie() {
		return calorie;
	}


	public void setCalorie(double calorie) {
		this.calorie = calorie;
	}
	
	
	
	
}
