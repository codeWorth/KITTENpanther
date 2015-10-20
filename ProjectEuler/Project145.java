public class Project145{
  public static ArrayList<int[]> situations(int numOfDigits, ArrayList<int[]> prevSits){
    /*
		0 = even < 10
		1 = even >= 10
		2 = odd < 10
		3 = odd >= 10
		*/
		if (numOfDigits == 0){
			return prevSits;
		} else {
			ArrayList<int[]> newSits = new ArrayList<int[]>();
			for (int i = 0; i < prevSits.size(); i++){
				int[] prevState = prevSits.get(i);
				prevSits.add
				prevSits.get(i)[numOfDigits-1] = 0;
			}
			return situations(numOfDigits-1, prevSits);
		}
}
