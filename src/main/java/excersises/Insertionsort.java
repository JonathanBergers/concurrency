package excersises;

import java.util.ArrayList;


public class Insertionsort {

	
	public static ArrayList<Integer> sortList(ArrayList<Integer> unsortedList){
		ArrayList<Integer> sortedList = new ArrayList<Integer>();
		for(int i : unsortedList){
			insertIntIntoList(sortedList, i);
		}
		return sortedList;
	}


	/**inserts the item into the list and sorts it with insertionsort
	 *
	 *
	 * @param sortedList
	 * @param intToInsert
	 * @return
	 */
	public static ArrayList<Integer> insertIntIntoList(ArrayList<Integer> sortedList, int intToInsert){
		if(sortedList.size()==0){
			sortedList.add(intToInsert);
			return sortedList;
		}
		for(int i=0; i<sortedList.size(); i++){

			if(intToInsert <= sortedList.get(i)){
				int temp1 = sortedList.get(i);
				sortedList.set(i, intToInsert);

				for(int j=i+1; j<sortedList.size(); j++){

					int temp2 = sortedList.get(j);
					sortedList.set(j, temp1);
					temp1 = temp2;
				}
				break;
			}
		}
		return sortedList;
	}

	
	public boolean isListSorted(ArrayList<Integer> soCalledSortedList){
		for(int i=1;i<soCalledSortedList.size();i++){
			if(soCalledSortedList.get(i)<soCalledSortedList.get(i-1)){
				return false;
			}
		}
		return true;
	}

}
