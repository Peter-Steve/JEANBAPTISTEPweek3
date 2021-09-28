package playbook;

import controller.Controller;
import features.SortFeatures;
import features.SortType;
import view.Read;

public class PlayBook {

	public static void main(String[] args) {
		Read r = new Read();
		int p = r.readPositifInteger();
		int[] tab = new int[p];
		Controller c = new Controller(p,tab);
		c.mainProgram();
	}

}
