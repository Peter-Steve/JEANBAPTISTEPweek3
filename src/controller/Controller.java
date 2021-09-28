package controller;

import java.util.Arrays;

import features.SearchFeatures;
import features.SortFeatures;
import features.SortType;
import view.Display;
import view.Read;

public class Controller {
	private int lenght;
	private int[] array;
	Read r;
	SearchFeatures searchFeatures;
	SortFeatures sortFeatures;
	
	public Controller(int lenght, int[] array) {
		super();
		this.lenght = lenght;
		this.array = array;
		r = new Read();
		searchFeatures = new SearchFeatures(lenght,array);
		sortFeatures = new SortFeatures(array,lenght);
	}
	
	
	
	@Override
	public String toString() {
		return "[array=" + Arrays.toString(array) + "]";
	}



	public void mainProgram() {
		r.readArray(this.array,this.lenght);
		Display.display(toString());
		Display.orderMenu();
		
		int choice = r.readInt();
		SortType type;
		if(choice==1) {
			type = SortType.ASCENDANT;
		}
		else if(choice==2) {
			type = SortType.DESCENDANT;
		}
		else {
			Display.display("Desole,vous n'avez effectue aucun choix");
			return;
		}
		
		Display.sortMenu();
		choice = r.readInt();
		sort(type,choice);
		if(choice<1 || choice>4) {
			return;
		}
		Display.display(toString());
		Display.searchMenu();
		
		choice = r.readInt();
		
		if(choice<1 || choice>4) {
			return;
		}
		
		Display.display("entrer la valeur a rechercher");
		
		int value = r.readInt();
		
		if(search(value,type,choice)){
			Display.display("trouve");
		}
		else {
			Display.display("non trouve");
		}
		
	}
	
	public boolean search(int value,SortType type,int method) {
		switch(method) {
		case 1:{
			return searchFeatures.linearSearch(value);
		}
			
		case 2:{
			return searchFeatures.dichotoSearch(value,type);
		}
		
		case 3:{
			return searchFeatures.fibonnaciSearch(value,type);
		}
		
		case 4:{
			return searchFeatures.searchByJump(value,type);
		}
		
		default:{
			return false;
		}
		}
		
	}
	
	public void sort(SortType type,int method) {
		switch(method) {
		case 1:{
			sortFeatures.bubbleSort(type);
		}break;
			
		case 2:{
			sortFeatures.sortBySelection(type);
		}break;
		
		case 3:{
			sortFeatures.sortByInsertion(type);
		}break;
		
		case 4:{
			sortFeatures.sortByTransposition(type);
		}break;
		
		default:{
			Display.display("C'est dommage q'aucune methode n'a pas ete choisi");
		}
		
		}
	}
}
