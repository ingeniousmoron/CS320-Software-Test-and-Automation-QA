package task.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import task.taskService.TaskService;

class TaskServiceTest {

	@Test
	void testAddTask() {
		TaskService test = new TaskService();
		String name = "Organize desktop";
		String desc = "Files must be in nested folders";
		
				
		test.addTask(name, desc);
		test.addTask(name, desc);
		
		assertTrue(test.getTaskList().size() == 2);
		assertTrue(test.getTaskList().get("0").getTaskName().equals(name));
		assertTrue(test.getTaskList().get("0").getTaskDesc().equals(desc));
		assertTrue(test.getTaskList().get("1").getTaskName().equals(name));
		assertTrue(test.getTaskList().get("1").getTaskDesc().equals(desc));
		
	}
	
	@Test
	void testDeleteTask() {
		TaskService test = new TaskService();
		String name = "Organize desktop";
		String desc = "Files must be in nested folders";
		
		test.addTask(name, desc);
		test.deleteTask("0");
		
		assertTrue(test.getTaskList().size() == 0);
	}
	
	@Test
	void testUpdateTask() {
		TaskService test = new TaskService();
		String name = "Organize desktop";
		String desc = "Files must be in nested folders";
		
		test.addTask(name, desc);
		test.updateName("0", "Organize laptop");
		test.updateDesc("0", "Folders must be ordered by date");
		
		assertTrue(test.getTaskList().get("0").getTaskName().equals("Organize laptop"));
		assertTrue(test.getTaskList().get("0").getTaskDesc().equals("Folders must be ordered by date"));
	}
	
	@Test
	void testAddNameLong() {
		TaskService test = new TaskService();
		String name = "Organize desktop sd;kljflkdsjfljfdslkjfsd";
		String desc = "Files must be in nested folders";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addTask(name, desc);
		});
	}
	
	@Test
	void testAddNameNull() {
		TaskService test = new TaskService();
		String name = null;
		String desc = "Files must be in nested folders";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addTask(name, desc);
		});
	}
	
	@Test
	void testAddDescLong() {
		TaskService test = new TaskService();
		String name = "Organize desktop";
		String desc = "Files must be in nested folders slkd;jf;f'sdlk'fsd;lk;lkfds";
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addTask(name, desc);
		});
	}
	
	@Test
	void testAddDescNull() {
		TaskService test = new TaskService();
		String name = "Organize desktop";
		String desc = null;
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addTask(name, desc);
		});
	}
	
	@Test
	void testUpdateIdNotFound() {
		TaskService test = new TaskService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateName("0", "Organize desktop");
		});
	}
	
	@Test
	void testUpdateNameLong() {
		TaskService test = new TaskService();		
		String name = "Organize desktop";
		String desc = "Files must be in nested folders";
		
		test.addTask(name, desc);
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateName("0", "Organize desktop sd;kljflkdsjfljfdslkjfsd");
		});
	}
	
	@Test
	void testUpdateNameNull() {
		TaskService test = new TaskService();		
		String name = "Organize desktop";
		String desc = "Files must be in nested folders";
		
		test.addTask(name, desc);
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateName("0", null);
		});
	}	
	
	@Test
	void testUpdateDescLong() {
		TaskService test = new TaskService();		
		String name = "Organize desktop";
		String desc = "Files must be in nested folders";
		
		test.addTask(name, desc);
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateDesc("0",  "Files must be in nested folders slkd;jf;f'sdlk'fsd;lk;lkfds");
		});
	}
	
	@Test
	void testUpdateDescNull() {
		TaskService test = new TaskService();		
		String name = "Organize desktop";
		String desc = "Files must be in nested folders";
		
		test.addTask(name, desc);
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.updateDesc("0",  null);
		});
	}
	
	@Test
	void testDeleteIdNotFound() {
		TaskService test = new TaskService();
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.deleteTask("0");
		});
	}

}
