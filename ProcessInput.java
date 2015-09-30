public class ProcessInput {
	public static void interpretInput(Tasks tasks){
		Scanner scanner = new Scanner(System.in);

		String in = scanner.nextLine();

		String inLower = in.toLowerCase();

		String[] words = inLower.split(" ");

		if (words.length == 0){
			return;
		}

		String firstWord = words[0];

		if (firstWord.equals("add") || firstWord.equals("addtask")){
			System.out.println("Enter the name: ");
			String theName = scanner.nextLine();

			System.out.println("Enter a description: ");
			String desc = scanner.nextLine();

			System.out.println("Enter the number of days until this is due: ");
			int untilDue = scanner.nextInt();

			System.out.println("Enter the priority: ");
			int prio = scanner.nextInt();

			Task newTask = new Task(theName, desc, prio, untilDue);

			tasks.addtask(newTask);
		} else if (firstWord.equals("today")){
			ProcessInput.printTasks(tasks.tasksForToday());
		} else if (firstWord.equals("all") || firstWord.equals("alltasks")){
			ProcessInput.printTasksWithDue(tasks.allTasks());
		}  else if (firstWord.equals("finish")){
			System.out.println("");
		}
	}

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
  
                             
