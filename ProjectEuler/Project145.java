import java.util.*;

public class Project145{
	public static ArrayList<char[]> situations(int numOfDigits, ArrayList<char[]> prevSits){
   		/*
		0 = even < 10
		1 = even >= 10
		2 = odd < 10
		3 = odd >= 10
		*/
		if (numOfDigits == 0){
			return prevSits;
		} else {
			int length = prevSits.size();
			for (int i = 0; i < length; i++){
				char[] prevState = prevSits.get(i).clone();
				prevSits.get(i)[numOfDigits-1] = '0';

				prevState[numOfDigits-1] = '1';
				prevSits.add(prevState.clone());

				prevState[numOfDigits-1] = '2';
				prevSits.add(prevState.clone());

				prevState[numOfDigits-1] = '3';
				prevSits.add(prevState.clone());
			}
			return situations(numOfDigits-1, prevSits);
		}
	}

	public static void main(String[] args) {
		ArrayList<char[]> sits = new ArrayList<char[]>();
		int numOfDigits = 8;
		int numOfDigits++;
		numOfDigits *= 0.5;

		char[] prevState = new char[numOfDigits];
		prevState[numOfDigits-1] = '0';
		sits.add(prevState.clone());

		prevState[numOfDigits-1] = '1';
		sits.add(prevState.clone());

		prevState[numOfDigits-1] = '2';
		sits.add(prevState.clone());

		prevState[numOfDigits-1] = '3';
		sits.add(prevState.clone());

		sits = situations(numOfDigits-1, sits);
		String str1 = "";
		String str2; = "";

		int num1 = 0;
		int num2 = 0;

		int sumPos = 1;
		int allPos = 0;

		String added = "";
		for (char[] state : sits){
			str1 = "";
			str2 = "";
			for (char thisChar : state){
				if (thisChar == '0'){
					str1 += '2';
					str1 = '4' + str1;

					str2 += '4';
					str2 = '2' + str2;
				} else if (thisChar == '1'){
					str1 += '8';
					str1 = '4' + str1;

					str2 += '4';
					str2 = '8' + str2;
				} else if (thisChar == '2'){
					str1 += '3';
					str1 = '4' + str1;

					str2 += '4';
					str2 = '3' + str2;
				} else if (thisChar == '3'){
					str1 += '8';
					str1 = '7' + str1;

					str2 += '7';
					str2 = '8' + str2;
				} 
			}
			if (state.length % 2 != 0){
				str1 = str1.substring(0, state.length/2) + str1.substring(state.length/2 + 1);
				str2 = str2.substring(0, state.length/2) + str2.substring(state.length/2 + 1);
			}
			num1 = String.parseInt(str1);
			num2 = String.parseInt(str2);
			added = Integer.toString(num1+num2);
			char thisChar;
			boolean shoud = true;
			for (int i = 0; i < added.length; i++){
				thisChar = added.charAt(i);
				if  (Character.getNumericValue(thisChar) % 2 == 0){
					should = false;
					break;
				}
			}
			sumPos = 1;
			int i = 0;
			if (should){
				for (char thisChar : state){
					if (thisChar == '0'){
						if (i == 0){
							sumPos *= 20;
						} else {
							sumPos *= 30;
						}
					}
				}
			}
		}
	}
}
