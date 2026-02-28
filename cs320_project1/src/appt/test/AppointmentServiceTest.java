package appt.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import appt.appointmentService.AppointmentService;

class AppointmentServiceTest {
	@Test
	void testAddAppt() {
		AppointmentService test = new AppointmentService();
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment";
		c.set(2026, 5, 19);
		Date date = c.getTime();
		
		test.addAppt(date, desc);
		test.addAppt(date, desc);
		
		assertTrue(test.getApptList().size() == 2);
		assertEquals(date, test.getApptList().get("0").getApptDate());
		assertEquals(desc, test.getApptList().get("0").getApptDesc());
		assertEquals(date, test.getApptList().get("1").getApptDate());
		assertEquals(desc, test.getApptList().get("1").getApptDesc());
	}
	
	@Test
	void testDeleteAppt() {
		AppointmentService test = new AppointmentService();
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment";
		c.set(2026, 5, 19);
		Date date = c.getTime();
		
		test.addAppt(date, desc);
		test.deleteAppt("0");
		
		assertTrue(test.getApptList().size() == 0);
	}
	
	@Test
	void testAddBadDate() {
		AppointmentService test = new AppointmentService();
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment";
		c.set(2024, 5, 19);
		Date date = c.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addAppt(date, desc);
		});
	}
	
	@Test
	void testAddNullDate() {
		AppointmentService test = new AppointmentService();
		Date date = null;
		String desc = "Drs appointment";
		
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addAppt(date, desc);
		});
	}
	
	@Test
	void testAddBadDesc() {
		AppointmentService test = new AppointmentService();
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment this is a bad description aslkdj;dsjkds;fjdfs;d;s";
		c.set(2026, 5, 19);
		Date date = c.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addAppt(date, desc);
		});
	}
	
	@Test
	void testAddNullDesc() {
		AppointmentService test = new AppointmentService();
		Calendar c = Calendar.getInstance();
		String desc = null;
		c.set(2026, 5, 19);
		Date date = c.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.addAppt(date, desc);
		});
	}
	
	@Test
	void testDeleteIdNotFound() {
		AppointmentService test = new AppointmentService();
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment";
		c.set(2026, 5, 19);
		Date date = c.getTime();
		
		test.addAppt(date, desc);
		
		assertThrows(IllegalArgumentException.class, () -> {
			test.deleteAppt("1");
		});
	}

}
