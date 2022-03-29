package model;

public class Game {
	private String nomYapelli; 
	private String animal;
	private String ciuYpai;
	private String cosa;

	
	
	
	public Game(String nomYapelli, String animal, String ciuYpai, String cosa) {
		super();
		this.nomYapelli = nomYapelli;
		this.animal = animal;
		this.ciuYpai= ciuYpai;
		this.cosa = cosa;
		
	}
	public String getNomYapelli() {
		return nomYapelli;
	}
	public void setNomYapelli(String nomYapelli) {
		this.nomYapelli = nomYapelli;
	}
	
	
	public String getAnimal() {
		return animal;
	}
	public void setAnimal(String animal) {
		this.animal = animal;
	}
	
	
	public String getCiuYpai() {
		return ciuYpai;
	}
	public void setCiuYpai(String ciuYpai) {
		ciuYpai = ciuYpai;
	}
	public String getCosa() {
		return cosa;
	}
	public void setCosa(String cosa) {
		this.cosa = cosa;
	}
	
	
	
	
	

}
