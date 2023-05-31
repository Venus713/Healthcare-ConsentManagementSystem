package com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryEntity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "EHealth_Records")
public class KaveryEHealthRecord implements HealthRecord {

    @Id
    @Column(name = "ehr_id", nullable = false)
    private String ehrId;

    @Column(name = "abha_id", nullable = false)
    private String abhaId;

    @Column(name = "patient_name", nullable = false)
    private String patientName;

    @Column(name = "doctor_name", nullable = false)
    private String doctorName;

    @Column(name = "hospital_name", nullable = false)
    private String hospitalName;

    @Column(name = "patient_phone", nullable = false)
    private String patientPhone;

    @Column(name = "diagnosis", nullable = false)
    private String diagnosis;

    @Column(name = "date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @Column(name = "prescription")
    private String prescription;

    @Column(name = "doctor_license")
    private String doctorLicense;

    public String getEhrId() {
        return ehrId;
    }

    @Override
    public void setEhrId(String id) {
        this.ehrId = id;
    }

    public String getAbhaId() {
        return abhaId;
    }

    public void setAbhaId(String abhaId) {
        this.abhaId = abhaId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getPatientPhone() {
        return patientPhone;
    }

    public void setPatientPhone(String patientPhone) {
        this.patientPhone = patientPhone;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getDoctorLicense() {
        return doctorLicense;
    }

    public void setDoctorLicense(String doctorLicense) {
        this.doctorLicense = doctorLicense;
    }

    public KaveryEHealthRecord(String ehrId, String abhaId, String patientName, String doctorName, String hospitalName, String patientPhone, String diagnosis, LocalDate date, String prescription, String doctorLicense) {
        this.ehrId = ehrId;
        this.abhaId = abhaId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.hospitalName = hospitalName;
        this.patientPhone = patientPhone;
        this.diagnosis = diagnosis;
        this.date = date;
        this.prescription = prescription;
        this.doctorLicense = doctorLicense;
    }
}
