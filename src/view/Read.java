package view;

import java.util.Scanner;

public class Read {
	private Scanner scan;
	
	public Read() {
		scan = new Scanner(System.in);
	}
	
	public int readInt() {
		return this.scan.nextInt();
	}
	
	public int readPositifInteger() {
		Display.display("entrer un entier positif pour la taille du tableau");
		
		int i = this.scan.nextInt();
		
		while(i<=0) {
			Display.display("La taille du tableau doit etre strictement positif");
			i = this.scan.nextInt();
		}
		
		return i;
	}
	
	public void readArray(int[] array, int lenght) {
		Display.display("Entrer les valeurs du tableau");
		for (int i = 0; i <lenght; i++) {

			array[i] = scan.nextInt();

		}
	}
}

