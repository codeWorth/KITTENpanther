public class ProcessInput {
	public static void interpretInput(String in){
		String inLower = in.toLowerCase();
	}
}

public class ProcessInput {
	public static void interpretInput(String in){
		String inLower = in.toLowerCase();
	}

	public static void printTasks(Task[] tasks){
		int i = 1;
		for (Task task : tasks){
			String lePrint = "";

			lePrint = lePrint + i + ". ";

			lePrint = lePrint + task.name + "______________";

			lePrint = lePrint + task.daysUntilDue;

			i++;
			System.out.println (lePrint);

		}
	} 

	public static void printTasksWithDue(Task[] tasks){
		int i = 1;
		for (Task task : tasks){
			String lePrint = "";

			lePrint = lePrint + i + ". ";

			if (daysUntilDue = 0)
				system.out.println ("DUE!!!");
			if (daysUntilDue < 0)
				system.out.println ("IS LATE!!! EEK! MEOW! EEK! IT'S LATE!!! AGGGGGGHHHHBAHBAH!!!  ITS LATE!!!")


			lePrint = lePrint + task.name + "______________";

			lePrint = lePrint + task.daysUntilDue;

			i++;

			System.out.println (lePrint);
			System.out.println (daysUntilDue);
	}
}
  
                             
