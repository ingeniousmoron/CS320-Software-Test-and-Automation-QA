package task.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import task.taskService.Task;

class TaskTest {

	@Test
	void testTaskClass() {
		Task newTask = new Task("1", "Organize desktop", "Files must be in nested folders");
		
		assertTrue(newTask.getTaskId().equals("1"));
		assertTrue(newTask.getTaskName().equals("Organize desktop"));
		assertTrue(newTask.getTaskDesc().equals("Files must be in nested folders"));
	}
	
	@Test
	void testIdTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("111111111111", "Organize desktop", "Files must be in nested folders");
		});
	}
	
	@Test
	void testIdNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task(null, "Organize desktop", "Files must be in nested folders");
		});
	}
	
	@Test
	void testNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Organize desktop sdlkjfslk;jfdl;k", "Files must be in nested folders");
		});
	}
	
	@Test
	void testNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", null, "Files must be in nested folders");
		});
	}
	
	@Test
	void testSetNameTooLong() {
		Task newTask = new Task("1", "Organize desktop", "Files must be in nested folders");
		assertThrows(IllegalArgumentException.class, () -> {
			newTask.setTaskName("Organize desktop sdlkjfslk;jfdl;k");
		});
	}
	
	@Test
	void testSetNameNull() {
		Task newTask = new Task("1", "Organize desktop", "Files must be in nested folders");
		assertThrows(IllegalArgumentException.class, () -> {
			newTask.setTaskName(null);
		});
	}
	
	@Test
	void testDescTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Organize desktop", "Files must be in nested folders slkd;jf;f'sdlk'fsd;lk;lkfds");
		});
	}
	
	@Test
	void testDescNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Task("1", "Organize desktop", null);
		});
	}
	
	@Test
	void testSetDescTooLong() {
		Task newTask = new Task("1", "Organize desktop", "Files must be in nested folders");
		assertThrows(IllegalArgumentException.class, () -> {
			newTask.setTaskDesc("Files must be in nested folders slkd;jf;f'sdlk'fsd;lk;lkfds");
		});
	}
	
	@Test
	void testSetDescNull() {
		Task newTask = new Task("1", "Organize desktop", "Files must be in nested folders");
		assertThrows(IllegalArgumentException.class, () -> {
			newTask.setTaskDesc(null);
		});
	}

}
