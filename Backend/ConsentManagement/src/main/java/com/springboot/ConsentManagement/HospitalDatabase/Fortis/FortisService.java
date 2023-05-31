package com.springboot.ConsentManagement.HospitalDatabase.Fortis;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Doctor;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Patient;
import com.springboot.ConsentManagement.ConsentService.HospitalService;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisEntity.FortisEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisRepositoryAPI.FortisRepoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

import java.io.IOException;
import java.util.List;

@Service("FortisService")
public class FortisService implements HospitalService {
    public static final String HP_NAME = "Fortis";
    @Autowired
    private FortisRepoAPI fortisRepoAPI;

    @Override
    public List<HealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone) {
        return null;
    }

    @Override
    public HealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId, String RecordIds) {
        return fortisRepoAPI.findByPatientNameAndAbhaIdAndEhrId(patientName,abhaId,RecordIds);
    }

    @Override
    public HealthRecord findByPatientNameAndAbhaIdAndDoctorLicense(String name, String abhaId, String doctorLicense) {
        return fortisRepoAPI.findByPatientNameAndAbhaIdAndDoctorLicense(name,abhaId,doctorLicense);
    }

    @Override
    public List<FortisEHealthRecord> findByAbhaId(String abhaId) {
        return fortisRepoAPI.findByAbhaId(abhaId);
//        return null;
    }

    @Override
    public List<FortisEHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense) {
        return fortisRepoAPI.findByDoctorNameAndDoctorLicense(name,doctorLicense);

    }

    @Override
    public List<? extends HealthRecord> findAll() {
        return fortisRepoAPI.findAll();
    }

    @Override
    public List<String> findDistinctDoctorLicenseInRepo() {
        return fortisRepoAPI.findDistinctDoctorLicenseInRepo();
    }

    @Override
    public HealthRecord addPatientEHealthRecord(Patient pat) throws IOException {
        int min = 1000;
        int max = 3333;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
        FortisEHealthRecord healthRecord = new FortisEHealthRecord(
                String.valueOf(randomNumber),
                pat.getAbhaId(),
                pat.getName(),
                "",
                HP_NAME + " Hospital",
                "1234567890",
                "Cholestrol",
                LocalDate.now(),
                "Crestor",
                null
        );
        return fortisRepoAPI.save(healthRecord);
    }

    @Override
    public HealthRecord addDoctorEHealthRecord(Doctor doc) {
        int min = 1000;
        int max = 3333;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
        FortisEHealthRecord healthRecord = new FortisEHealthRecord(
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
        return fortisRepoAPI.save(healthRecord);
    }

    @Override
    public HealthRecord updateEHealthRecord(Doctor doc, String ehrId) throws IOException {
        FortisEHealthRecord healthRecord = fortisRepoAPI.findByEhrId(ehrId);
        healthRecord.setDoctorLicense(doc.getDoctorLicense());
        healthRecord.setDoctorName(doc.getName());
        return fortisRepoAPI.save(healthRecord);
    }

}
