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
    } else 
      for (int i = 0; i < prevSits.size(); i++){
        prevSits.add(0);
        prevSits.add(1);
        prevSits.add(2);
        prevSits.add(3);
      }
      return situations(numOfDigits-1, prevSits);
    }
  }
}
