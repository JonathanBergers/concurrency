import java.util.ArrayList;


public class Insertionsort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}
	
	private static ArrayList<Integer> sortList(ArrayList<Integer> unsortedList){
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		for(int i : unsortedList){
			insertIntIntoList(sortedList, i);
		}
		return sortedList;
	}
	
	private static ArrayList<Integer> insertIntIntoList(ArrayList<Integer> sortedList, int intToInsert){
		if(sortedList.size()==0){
			sortedList.add(intToInsert);
			return sortedList;
		}
		for(int i=0;i<sortedList.size();i++){
			if(intToInsert <= sortedList.get(i)){
				int temp1 = sortedList.get(i);
				sortedList.set(i, intToInsert);
				for(int j=i+1;j<sortedList.size();j++){
					int temp2 = sortedList.get(j);
					sortedList.set(j, temp1);
					temp1 = temp2;
				}
				break;
			}
		}
		return sortedList;
	}
	
	
	private static int randInt(int i, int j) {
		return (int) (Math.random() * (j - i)) + i;
	}
	private static ArrayList<Integer> fillList(int size){
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<size;i++){
			list.add(randInt(0, size));
		}
		return list;
	}
	
	
	private boolean isListSorted(ArrayList<Integer> soCalledSortedList){
		for(int i=1;i<soCalledSortedList.size();i++){
			if(soCalledSortedList.get(i)<soCalledSortedList.get(i-1)){
				return false;
			}
		}
		return true;
	}

}
