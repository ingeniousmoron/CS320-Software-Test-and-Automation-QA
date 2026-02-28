package task.taskService;

public class Task {
	final private String taskId;
	private String taskName;
	private String taskDesc;
	
	public Task(String id, String name, String desc) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		
		this.taskId = id;
		this.taskName = name;
		this.taskDesc = desc;
	}
	
	public final String getTaskId() {
		return taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	
	public void setTaskName(String name) {
		if (name == null || name.length() > 20) {
			throw new IllegalArgumentException("Invalid name");
		}
		this.taskName = name;
	}
	public void setTaskDesc(String desc) {
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid description");
		}
		this.taskDesc = desc;
	}

}
