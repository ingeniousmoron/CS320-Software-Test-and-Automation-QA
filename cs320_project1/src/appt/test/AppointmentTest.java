package appt.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;
import java.util.Calendar;
import appt.appointmentService.Appointment;

class AppointmentTest {

	@Test
	void testApptClass() {
		String id = "0";
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment";
		
		c.set(2026, 5, 19);
		Date date = c.getTime();
		
		Appointment newAppt = new Appointment(id, date, desc);
		
		assertEquals("0", newAppt.getApptId());
		assertEquals(date, newAppt.getApptDate());
		assertEquals(desc, newAppt.getApptDesc());
	}
	
	@Test
	void testIdTooLong() {
		String id = "000000000000000000";
		Date date = new Date();
		String desc = "Drs appointment";
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, desc);
		});
	}
	
	@Test
	void testIdNull() {
		String id = null;
		Date date = new Date();
		String desc = "Drs appointment";
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, desc);
		});
	}
	
	
	@Test
	void testDateBad() {
		String id = "0";
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment";
		
		c.set(2024, 5, 19);
		Date date = c.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, desc);
		});		
	}
	
	@Test
	void testDateNull() {
		String id = "0";
		Date date = null;
		String desc = "Drs appointment";
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, desc);
		});
	}
	
	@Test
	void testSetDateBad() {
		String id = "0";
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment";
		
		c.set(2026, 5, 19);
		Date date = c.getTime();		
		Appointment newAppt = new Appointment(id, date, desc);
		c.set(2024, 5, 19);
		Date badDate = c.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			newAppt.setApptDate(badDate);
		});
	}
	
	@Test
	void testSetDateNull() {
		String id = "0";
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment";
		
		c.set(2026, 5, 19);
		Date date = c.getTime();		
		Appointment newAppt = new Appointment(id, date, desc);
		
		assertThrows(IllegalArgumentException.class, () -> {
			newAppt.setApptDate(null);
		});
	}
	
	@Test
	void testDescTooLong() {
		String id = "0";
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment this is a bad description aslkdj;dsjkds;fjdfs;d;s";
		
		c.set(2026, 5, 19);
		Date date = c.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, desc);
		});
	}
	
	@Test
	void testDescNull() {
		String id = "0";
		Calendar c = Calendar.getInstance();
		String desc = null;
		
		c.set(2026, 5, 19);
		Date date = c.getTime();
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Appointment(id, date, desc);
		});
	}
	
	@Test
	void testSetDescTooLong() {
		String id = "0";
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment";
		
		c.set(2026, 5, 19);
		Date date = c.getTime();
		
		Appointment newAppt = new Appointment(id, date, desc);
		
		assertThrows(IllegalArgumentException.class, () -> {
			newAppt.setApptDesc("Drs appointment this is a bad description aslkdj;dsjkds;fjdfs;d;s");
		});
	}
	
	@Test
	void testSetDescNull() {
		String id = "0";
		Calendar c = Calendar.getInstance();
		String desc = "Drs appointment";
		
		c.set(2026, 5, 19);
		Date date = c.getTime();
		
		Appointment newAppt = new Appointment(id, date, desc);
		
		assertThrows(IllegalArgumentException.class, () -> {
			newAppt.setApptDesc(null);
		});
	}
}
