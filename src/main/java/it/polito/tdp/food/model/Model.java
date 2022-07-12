package it.polito.tdp.food.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.food.db.FoodDao;

public class Model {
	
	private Graph<Food,DefaultWeightedEdge> grafo;
	private FoodDao dao;
	private Map<Integer,Food> foodMap;
	
	public Model() {
		super();
		this.dao = new FoodDao();
	}
	
	public void creaGrafo(Integer p) {
		this.grafo = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
		this.foodMap = new HashMap<>();
		
		// vertici
		Graphs.addAllVertices(this.grafo, dao.getFoodsByPortions(p, foodMap));
		
		// archi
		for(Edge e : dao.getAllEdges(foodMap)) {
			Graphs.addEdgeWithVertices(this.grafo, e.getFood1(), e.getFood2(), e.getCalorie());
		}
		
	}
	
	public int nVertici() {
		return this.grafo.vertexSet().size();
	}
	
	public int nArchi() {
		return this.grafo.edgeSet().size();
	}
	
	public List<Food> getFood(){
		List<Food> cibi = new ArrayList<>(this.grafo.vertexSet());
		Collections.sort(cibi);
		return cibi;
	}
	
	public List<Adiacente> getAdiacenti(Food f){
		List<Adiacente> ad = new ArrayList<>();
		
		
		for(Food fi : Graphs.neighborListOf(this.grafo, f)) {
			
			double peso = this.grafo.getEdgeWeight(this.grafo.getEdge(f, fi));
				Adiacente a = new Adiacente (fi, peso);
				     ad.add(a);
				
		}
		
		Collections.sort(ad);
		return ad;
		
	}
	
	
	
	
	

}
