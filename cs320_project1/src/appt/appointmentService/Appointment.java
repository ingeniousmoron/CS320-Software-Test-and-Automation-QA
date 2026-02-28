package appt.appointmentService;

import java.util.Date;

public class Appointment {
	private final String apptId;
	private Date apptDate;
	private String apptDesc;
	
	public Appointment(String id, Date date, String desc) {
		if (id == null || id.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment date");
		}
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description");
		}
		this.apptId = id;
		this.apptDate = date;
		this.apptDesc = desc;
	}
	
	public final String getApptId() {
		return apptId;
	}
	public Date getApptDate() {
		return apptDate;
	}
	public String getApptDesc() {
		return apptDesc;
	}
	
	public void setApptDate(Date date) {
		if (date == null || date.before(new Date())) {
			throw new IllegalArgumentException("Invalid appointment date");
		}
		this.apptDate = date;
	}
	public void setApptDesc(String desc) {
		if (desc == null || desc.length() > 50) {
			throw new IllegalArgumentException("Invalid appointment description");
		}
		this.apptDesc = desc;
	}
}
