package view;

public abstract class Display {
	public static void display(String a) {
		System.out.println(a);
	}
	
	public static void sortMenu() {
		display("1.tri a bulle");
		display("2.tri par selection");
		display("3.tri par insertion");
		display("4.tri par transposition");
	}
	
	public static void orderMenu() {
		display("1.croissant");
		display("2.decroissant");
	}
	
	public static void searchMenu() {
		display("1.Recherche lineaire");
		display("2.Recherche dichotomique");
		display("3.Recherche fibonacci");
		display("4.Recherche saut");
	}
}
