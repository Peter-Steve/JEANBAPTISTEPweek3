package features;

import java.util.Arrays;

public class SortFeatures {
	
	private int lenght;
	private int[] array;

	public SortFeatures( int[] array,int lenght) {
		super();
		this.lenght = lenght;
		this.array = array;
	}

	public int getLenght() {
		return lenght;
	}

	public void setLenght(int lenght) {
		this.lenght = lenght;
	}

	@Override
	public String toString() {
		return "SortFeatures [lenght=" + lenght + ", array=" + Arrays.toString(array) + "]";
	}

	public int[] getArray() {
		return array;
	}



	public void setArray(int[] array) {
		this.array = array;
	}

	public void permutation(int pos1,int pos2) {
		int valueTemp = this.array[pos1];
		this.array[pos1] = this.array[pos2];
		this.array[pos2] = valueTemp;
	}

	public void bubbleSort(SortType type) {
		int i;
		int j;
		for(i=0;i<this.lenght;i++) {
			for(j=0;j<this.lenght-i-1;j++) {
				if(Features.test(this.array[j],this.array[j+1],type)) {
					permutation(j,j+1);
				}
			}
		}
	}
	
	public void sortBySelection(SortType type) {
		int index=0;
		int unsortedIndex;
		int minimum;
		int minimumPosition;
		
		while(index<this.lenght) {
			minimum = this.array[index];
			minimumPosition = index;
			unsortedIndex = index;
			while(unsortedIndex<this.lenght) {
				if(Features.test(minimum,this.array[unsortedIndex],type)) {
					minimum = this.array[unsortedIndex];
					minimumPosition = unsortedIndex;
				}
				unsortedIndex++;
			}
			permutation(minimumPosition,index);
			index++;
		}
	}
	
	public void sortByInsertion(SortType type) {
		int index=1;
		int indexInsert;
		int valueInsert;
		
		while(index<this.lenght) {
			valueInsert = this.array[index];
			indexInsert = index-1;
			while(indexInsert>=0 && (Features.test(this.array[indexInsert],valueInsert,type) 
					|| this.array[indexInsert]==valueInsert) ) {
				this.array[indexInsert+1] = this.array[indexInsert];
				indexInsert--;
			}
			this.array[indexInsert+1]=valueInsert;
			index++;
		}
	}
	
	public void sortByTransposition(SortType type) {
		int j;
		int i;
		for( i= 0;i<this.lenght-1;i++) {
			if(Features.test(this.array[i],this.array[i+1],type)) {
				permutation(i,i+1);
				j=i-1;
				while(j>=0) {
					if(Features.test(this.array[j],this.array[j+1],type)) {
						permutation(j,j+1);
						j--;
					}
					else {
						j=-1;
					}
				}
			}
		}
	}
}
