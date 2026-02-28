package appt.appointmentService;

import java.util.*;

public class AppointmentService {
	private final HashMap<String, Appointment> apptList = new HashMap<String, Appointment>();	
	private int currentIdNum = 0;
	
	public void addAppt(Date date, String desc) {
		
		String id = Integer.toString(currentIdNum);
		Appointment newAppt = new Appointment(id, date, desc);
		apptList.put(id, newAppt);
		
		++currentIdNum;
	}
	
	public void deleteAppt(String id) {
		if (apptList.get(id) == null) {
			throw new IllegalArgumentException("Appointment not in system");
		}
		apptList.remove(id);		
	}
	
	public HashMap<String, Appointment> getApptList() {
		return apptList;
	}

}
