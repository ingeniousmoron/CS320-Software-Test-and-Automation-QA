package task.taskService;

import java.util.*;


public class TaskService {
	private final HashMap<String, Task> taskList = new HashMap<String, Task>();
	private int currentIdNum = 0;
	
	public void addTask(String name, String desc) {
		String id = Integer.toString(currentIdNum);
		Task newTask = new Task(id, name, desc);
		taskList.put(id, newTask);
		
		++currentIdNum;
	}
	
	public void deleteTask(String id) {
		if (taskList.get(id) == null) {
			throw new IllegalArgumentException("Task not in system");
		}
		taskList.remove(id);
	}
	
	public void updateName(String id, String name) {
		if (taskList.get(id) == null) {
			throw new IllegalArgumentException("Task not in system");
		}
		taskList.get(id).setTaskName(name);
	}
	
	public void updateDesc(String id, String desc) {
		if (taskList.get(id) == null) {
			throw new IllegalArgumentException("Task not in system");
		}
		taskList.get(id).setTaskDesc(desc);
	}
	
	public HashMap<String, Task> getTaskList() {
		return taskList;
	}

}
