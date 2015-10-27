public class Main{
	public static void main(String[] args) {
		System.out.println("Jz is so fucking dumb... Hai");
		Wesley thisGuy = new Wesley();
		
		String hisName = thisGuy.theName();
		int hisAge = thisGuy.age;

		System.out.println(hisName);
		System.out.println(hisAge);

		thisGuy.changeName("Wesley's new name");

		hisName = thisGuy.theName();

		System.out.println("His new name is: " + hisName);

		System.out.println("");

		Wesley thisOtherGuy = new Wesley();

		thisOtherGuy.ageUp();

		hisName = thisOtherGuy.theName();
		hisAge = thisOtherGuy.age;

		System.out.println(hisName);
		System.out.println(hisAge);

		thisOtherGuy.changeName("THis wesley is fat");

		hisName = thisOtherGuy.theName();

		System.out.println("His new name is: " + hisName);
	}
}