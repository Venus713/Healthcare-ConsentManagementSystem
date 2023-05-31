package com.springboot.ConsentManagement.HospitalDatabase.Narayana;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Doctor;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Patient;
import com.springboot.ConsentManagement.ConsentService.HospitalService;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisEntity.FortisEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaEntity.NarayanaEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaRepositoryAPI.NarayanaRepoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service("NarayanaService")
public class NarayanaService implements HospitalService {
    public static final String HP_NAME = "Narayana";
    @Autowired
    private NarayanaRepoAPI narayanaRepoAPI;

    @Override
    public List<HealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone) {
        return null;
    }

    @Override
    public HealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId, String RecordIds) {
        return narayanaRepoAPI.findByPatientNameAndAbhaIdAndEhrId(patientName,abhaId,RecordIds);
    }

    @Override
    public HealthRecord findByPatientNameAndAbhaIdAndDoctorLicense(String name, String abhaId, String doctorLicense) {
        return narayanaRepoAPI.findByPatientNameAndAbhaIdAndDoctorLicense(name,abhaId,doctorLicense);
    }

    @Override
    public List<NarayanaEHealthRecord> findByAbhaId(String abhaId) {
        return narayanaRepoAPI.findByAbhaId(abhaId);
//        return null;
    }

    @Override
    public List<NarayanaEHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense) {

        return narayanaRepoAPI.findByDoctorNameAndDoctorLicense(name,doctorLicense);
    }

    @Override
    public List<? extends HealthRecord> findAll() {
        return narayanaRepoAPI.findAll();
    }

    @Override
    public List<String> findDistinctDoctorLicenseInRepo() {
        return null;
    }

    @Override
    public HealthRecord addPatientEHealthRecord(Patient pat) throws IOException {
        int min = 6667;
        int max = 9999;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
        NarayanaEHealthRecord healthRecord = new NarayanaEHealthRecord(
                String.valueOf(randomNumber),
                pat.getAbhaId(),
                pat.getName(),
                "",
                HP_NAME + " Hospital",
                "1234567890",
                "Heartburn",
                LocalDate.now(),
                "Nexium",
                null
        );
        return narayanaRepoAPI.save(healthRecord);
    }

    @Override
    public HealthRecord addDoctorEHealthRecord(Doctor doc) {
        int min = 1000;
        int max = 3333;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
        NarayanaEHealthRecord healthRecord = new NarayanaEHealthRecord(
                String.valueOf(randomNumber),
                "",
                "",
                doc.getName(),
                HP_NAME + " Hospital",
                "",
                "Cholestrol",
                LocalDate.now(),
                "Crestor",
                doc.getDoctorLicense()
        );
        return narayanaRepoAPI.save(healthRecord);
    }

    @Override
    public HealthRecord updateEHealthRecord(Doctor doc, String ehrId) throws IOException {
        NarayanaEHealthRecord healthRecord = narayanaRepoAPI.findByEhrId(ehrId);
        healthRecord.setDoctorLicense(doc.getDoctorLicense());
        healthRecord.setDoctorName(doc.getName());
        return narayanaRepoAPI.save(healthRecord);
    }
}
