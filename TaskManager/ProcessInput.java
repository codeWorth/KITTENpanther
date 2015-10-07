import java.util.Scanner;

public class ProcessInput {
	public static boolean interpretInput(Tasks tasks, Scanner scanner){
		String in = scanner.nextLine();
		while (!(in instanceof String)){
			System.out.println("Enter a string:");
			in = scanner.nextLine();
		}
		in = in.toLowerCase();

		String[] words = in.split(" ");

		if (words.length == 0){
			return true;
		}

		String firstWord = words[0];

		if (firstWord.equals("add") || firstWord.equals("addtask")){

			System.out.println("Enter the name: ");
			String theName = scanner.nextLine();
			while (!(theName instanceof String)){
				System.out.println("Enter a string:");
				theName = scanner.nextLine();
			}

			System.out.println("Enter a description: ");
			String desc = scanner.nextLine();
			while (!(desc instanceof String)){
				System.out.println("Enter a string:");
				desc = scanner.nextLine();
			}

			System.out.println("Enter the number of days until this is due: ");
			Integer untilDue = scanner.nextInt();
			while (!(untilDue instanceof Integer)){
				System.out.println("Enter an integer:");
				untilDue = scanner.nextInt();
			}

			System.out.println("Enter the priority: ");
			Integer prio = scanner.nextInt();
			while (!(prio instanceof Integer)){
				System.out.println("Enter an integer:");
				prio = scanner.nextInt();
			}

			Task newTask = new Task(theName, desc, prio, untilDue);

			System.out.println(tasks.addTask(newTask));

		} else if (firstWord.equals("today")){

			ProcessInput.printTasks(tasks.tasksForToday());

		} else if (firstWord.equals("all") || firstWord.equals("alltasks")){

			ProcessInput.printTasksWithDue(tasks.allTasks());

		}  else if (firstWord.equals("finish")){

			Task[] tasksInPrintOrder = tasks.allTasks();

			ProcessInput.printTasksWithDue(tasksInPrintOrder);
			System.out.println("Enter the number of the task you want to remove: ");
			Integer number = scanner.nextInt();
			while (!(number instanceof Integer)){
				System.out.println("Enter an integer:");
				number = scanner.nextInt();
			}

			number--;
			Task toRemove = tasksInPrintOrder[number];
			int taskToEndIndex = tasks.indexOfTask(toRemove);
			System.out.println(tasks.finishTask(taskToEndIndex));

		} else if (firstWord.equals("desc") || firstWord.equals("description")){

			Task[] tasksInPrintOrder = tasks.allTasks();

			ProcessInput.printTasksWithDue(tasksInPrintOrder);
			System.out.println("Enter a number of a task, and its description will be shown: ");
			Integer number = scanner.nextInt();
			while (!(number instanceof Integer)){
				System.out.println("Enter an integer:");
				number = scanner.nextInt();
			}

			number--;
			Task toDesc = tasksInPrintOrder[number];
			int taskToDescIndex = tasks.indexOfTask(toDesc);
			System.out.println(tasks.showTaskDesc(taskToDescIndex));

		} else if (firstWord.equals("exit")){
			return false;
			
		} else if (firstWord.equals("help")){
			
			String[] helpLines = {"add - add a task to the list",
					      "today - all tasks that are due or overdue",
					      "all - print all the tasks",
					      "finish - remove a task from the list",
					      "desc - write the description of a task",
					      "exit - stop the program",
					  	  "next - go to the next day"};

			for (String line : helpLines){
				System.out.println(line);
			}
			
		} else if (firstWord.equals("next")){
			tasks.allNextDay();
			System.out.println("It's the next day.");
		}	
		
		return true;
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

			if (task.daysUntilDue == 1){
				lePrint = lePrint + "!! DUE !! ";
			} else if (task.daysUntilDue < 1){
				lePrint = lePrint + "!! LATE !! ";
			}


			lePrint = lePrint + task.name + "______________";

			lePrint = lePrint + task.daysUntilDue;

			i++;

			System.out.println (lePrint);
		}
	}
}
  
                             
