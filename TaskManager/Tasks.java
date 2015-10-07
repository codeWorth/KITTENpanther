import java.util.*;

public class Tasks{
	private ArrayList<Task> tasks = new ArrayList<Task>();

	public String addTask(Task newTask){
		//check if the newTask is a dupe
		for (Task task : tasks){
			if (task.name.equals(newTask.name)){
				return "This is a duplicate.";
			}
		}

		tasks.add(newTask);
		return "Your task named \""+newTask.name+"\" was successfully added.";
	}

	public Task[] tasksForToday(){
		ArrayList<Task> tasksTodayList = new ArrayList<Task>();		for (Task task : tasks){
			if (task.daysUntilDue <= 1){
				tasksTodayList.add(task);
			}
		}
		return tasksTodayList.toArray(new Task[tasksTodayList.size()]);
	}

	public void allNextDay(){
		for (Task task : tasks){
			task.nextDay();
		}
	}

	public String finishTask(int taskToEnd){
		if (taskToEnd < tasks.size() && taskToEnd >= 0){
			Task theTask = tasks.get(taskToEnd);
			int taskEndTime = theTask.daysUntilDue;
			tasks.remove(taskToEnd);
			if (theTask.daysUntilDue > 1){
				return "You finished this task "+(taskEndTime-1)+" days early";
			} else if ((taskEndTime) == 1){
				return "You finished this task on time.";
			} else {
				return "You finished this task "+(-1 * taskEndTime +1)+" days late.";
			}
		} else {
			return "Task named " + taskToEnd + " not found.";
		}
	}

	public int indexOfTask(Task taskToFind){
		int currentIndex = 0;

		for (Task checkTask : tasks){
			if (checkTask.name.equals(taskToFind.name)){
				return currentIndex;
			}
			currentIndex++;
		}

		return -1;
	}
	
	public Task[] allTasks(){
		Task[] importanceOrderedTasks = new Task[tasks.size()];
		Task[] fullOrderedTasks = new Task[tasks.size()];
		int minDate = 100;
		int maxDate = -100;
		for (Task task : tasks){
			if (task.daysUntilDue < minDate){
				minDate = task.daysUntilDue;
			}
			if (task.daysUntilDue > maxDate){
				maxDate = task.daysUntilDue;
			}
		}
		
		maxDate++;
		
		boolean didSwap = true;
		while (didSwap){
			didSwap = false;
			for (int i = tasks.size()-2; i > -1; i--){
				if (tasks.get(i).priority > tasks.get(i+1).priority){
					Task thisTask = tasks.get(i);
					tasks.set(i, tasks.get(i+1));
					tasks.set(i+1, thisTask);
					didSwap = true;
				}
			}
		}
		
		int i = 0;
		for (Task task : tasks){
			importanceOrderedTasks[i] = task;
			i++;
		}
		
		for (int curDate = minDate; curDate < maxDate; curDate++){
			for (i = 0; i < importanceOrderedTasks.length; i++){
				if (importanceOrderedTasks[i].daysUntilDue == curDate){
					fullOrderedTasks[i] = importanceOrderedTasks[i];
				}
			}
		}

		i = fullOrderedTasks.length;
		Task[] reversedTasks = new Task[fullOrderedTasks.length];
		for (Task task : fullOrderedTasks){
			i--;
			reversedTasks[i] = task;
		}

		return reversedTasks;
	}

	public String showTaskDesc(int taskIndex){
		if (taskIndex >= 0 && taskIndex < tasks.size()){
			return tasks.get(taskIndex).description;
		} else {
			return "Index " + taskIndex + " is out of bounds.";
		}
	}
}
