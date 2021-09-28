package features;

public abstract class Features {
	
	public static boolean test(int integer1,int integer2,SortType type) {
		if(type==SortType.ASCENDANT) {
			return integer1>integer2;
		}
		
		return integer1<integer2;
	}
	
}
