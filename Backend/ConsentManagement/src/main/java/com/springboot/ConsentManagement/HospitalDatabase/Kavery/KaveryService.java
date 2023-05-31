package com.springboot.ConsentManagement.HospitalDatabase.Kavery;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Doctor;
import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.Patient;
import com.springboot.ConsentManagement.ConsentService.HospitalService;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisEntity.FortisEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryEntity.KaveryEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryRepositoryAPI.KaveryRepoAPI;
import com.springboot.ConsentManagement.HospitalFactory;
import org.checkerframework.framework.qual.QualifierArgument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Service("KaveryService")
public class KaveryService implements HospitalService {
    public static final String HP_NAME = "Kavery";
    @Autowired
    private KaveryRepoAPI kaveryRepoAPI;

    @Override
    public List<HealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone) {
        return null;
    }

    @Override
    public HealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId, String RecordIds) {
        return kaveryRepoAPI.findByPatientNameAndAbhaIdAndEhrId(patientName,abhaId,RecordIds);
    }

    @Override
    public HealthRecord findByPatientNameAndAbhaIdAndDoctorLicense(String name, String abhaId, String doctorLicense) {
        return kaveryRepoAPI.findByPatientNameAndAbhaIdAndDoctorLicense(name,abhaId,doctorLicense);
    }

    @Override
    public List<KaveryEHealthRecord> findByAbhaId(String abhaId) {
        return kaveryRepoAPI.findByAbhaId(abhaId);
    }

    @Override
    public List<KaveryEHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense) {
        return kaveryRepoAPI.findByDoctorNameAndDoctorLicense(name,doctorLicense);
    }

    @Override
    public List<? extends HealthRecord> findAll() {
        return kaveryRepoAPI.findAll();
    }

    @Override
    public List<String> findDistinctDoctorLicenseInRepo() {
        return null;
    }

    @Override
    public HealthRecord addPatientEHealthRecord(Patient pat) throws IOException {
        int min = 3334;
        int max = 6666;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
        KaveryEHealthRecord healthRecord = new KaveryEHealthRecord(
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
        return kaveryRepoAPI.save(healthRecord);
    }

    @Override
    public HealthRecord addDoctorEHealthRecord(Doctor doc) {
        int min = 1000;
        int max = 3333;
        int randomNumber = (int) (Math.random() * (max - min + 1)) + min;
        KaveryEHealthRecord healthRecord = new KaveryEHealthRecord(
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
        return kaveryRepoAPI.save(healthRecord);
    }

    @Override
    public HealthRecord updateEHealthRecord(Doctor doc, String ehrId) throws IOException {
        KaveryEHealthRecord healthRecord = kaveryRepoAPI.findByEhrId(ehrId);
        healthRecord.setDoctorLicense(doc.getDoctorLicense());
        healthRecord.setDoctorName(doc.getName());
        return kaveryRepoAPI.save(healthRecord);
    }
}
