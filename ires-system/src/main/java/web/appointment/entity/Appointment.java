package web.appointment.entity;

import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import web.clinic.entity.Clinic;
import web.doctor.entity.Doctor;
import web.patient.entity.Patient;

@Entity
@Table(name = "appointment")
public class Appointment {

	@Id
	@Column(name = "appointment_id", nullable = false, length = 36)
	private String appointmentId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "clinic_id", insertable = false, updatable = false)
	private Clinic clinic;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "doctor_id", insertable = false, updatable = false)
	private Doctor doctor;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patient_id", insertable = false, updatable = false)
	private Patient patient;

	@Column(name = "reserve_no", nullable = false)
	private Integer reserveNo;

	@Column(name = "appointment_date", nullable = false)
	private Date appointmentDate;

	@Column(name = "time_period", nullable = false)
	private Integer timePeriod;

	@Column(name = "first_visit", nullable = false)
	private Boolean firstVisit;

	@Column(name = "status", nullable = false)
	private Integer status;

	@Column(name = "create_time", nullable = false, updatable = false, insertable = false)
	private Timestamp createTime;

	@Column(name = "update_time", insertable = false)
	private Timestamp updateTime;

	@Column(name = "notes", columnDefinition = "TEXT")
	private String notes;

	// Getters and Setters

	public String getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(String appointmentId) {
		this.appointmentId = appointmentId;
	}

	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Integer getReserveNo() {
		return reserveNo;
	}

	public void setReserveNo(Integer reserveNo) {
		this.reserveNo = reserveNo;
	}

	public Date getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(Date appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public Integer getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(Integer timePeriod) {
		this.timePeriod = timePeriod;
	}

	public Boolean getFirstVisit() {
		return firstVisit;
	}

	public void setFirstVisit(Boolean firstVisit) {
		this.firstVisit = firstVisit;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}
}