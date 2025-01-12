package com.springboot.ConsentManagement.ConsentService;

import java.io.IOException;
import java.util.List;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Patient;
import com.springboot.ConsentManagement.Entities.*;

public interface PatientService {
	public List<List<? extends HealthRecord>> getPatientRecords(String metaId,List<String> hospitalNames);

	public Patient getProfile(String metaId);
	public List<String> getDoctorNames(List<String> doctorIds);
	public String getPatientId(String name,String phone);

    PatientPublicProfile getPublicProfile(String metaId);

	List<PatientPublicProfile> getRequestedPublicProfiles(List<String> doctorIds);

	HealthRecord addPatientRecord(String metaId, String hospitalName) throws IOException;
//	public List<ConnectedDoctor> getConnections(String metaId);
}

