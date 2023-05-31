package com.springboot.ConsentManagement.ConsentController;

import java.io.IOException;
import java.util.List;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Doctor;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.Entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import com.springboot.ConsentManagement.ConsentService.DoctorService;

@RestController
//@CrossOrigin(origins = "*")
public class DoctorController {
	
	@Autowired
	private DoctorService DoctorServiceHandler;
	
	@PreAuthorize("#metaId == authentication.name and hasRole('ROLE_DOCTOR')")
	@PostMapping("/Doc/{metaId}/E-Health-Records")
	public List<? extends HealthRecord> accessRecords(@PathVariable("metaId") String metaId,
											 @RequestBody DoctorRecordTemplate doctorRecordTemplate){
		return this.DoctorServiceHandler.accessRecords(metaId, doctorRecordTemplate.getRecordsList(),doctorRecordTemplate.getHospitalNames());
	}

	@PreAuthorize("(#metaId == authentication.name and hasRole('ROLE_DOCTOR'))")
	@GetMapping(path="/Doc/{metaId}/Profile")
	public Doctor getProfile(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.getProfile(metaId);	
	}

	@GetMapping(path="/Doc/{metaId}/Profile-public")
	public DoctorPublicProfile getPublicProfile(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.getPublicProfile(metaId);
	}

	@PostMapping(path="/Doc/Profile-public")
	public List<DoctorPublicProfile> getRequestedPublicProfile(@RequestBody List<String> doctorIds) {
		return this.DoctorServiceHandler.getRequestedPublicProfiles(doctorIds);
	}

	@GetMapping(path="/Doc/{metaId}/Get-Connections")
	public List<ConnectedPatient> getConnections(@PathVariable("metaId") String metaId) {
		return this.DoctorServiceHandler.getConnections(metaId);	
	}

	@PostMapping(path="/Doc/Add-E-Health-Records")
	public HealthRecord addDoctor(@RequestParam("metaId") String metaId, @RequestParam("hospitalName") String hospitalName) throws IllegalAccessException, IOException {
		return this.DoctorServiceHandler.addDoctorRecord(metaId, hospitalName);
	}

	@PostMapping(path="/Doc/Update-E-Health-Records")
	public HealthRecord updateDocker(@RequestParam("metaId") String metaId, @RequestParam("ehrId") String ehrId, @RequestParam("hospitalName") String hospitalName) throws IllegalAccessException, IOException {
		return (HealthRecord) this.DoctorServiceHandler.updatePatientRecord(metaId, ehrId, hospitalName);
	}

}
