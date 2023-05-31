package com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaRepositoryAPI;

import com.springboot.ConsentManagement.ConsentDatabase.ConsentTable.EHealthRecord;
import com.springboot.ConsentManagement.Entities.HealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Fortis.FortisEntity.FortisEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Kavery.KaveryEntity.KaveryEHealthRecord;
import com.springboot.ConsentManagement.HospitalDatabase.Narayana.NarayanaEntity.NarayanaEHealthRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NarayanaRepoAPI extends JpaRepository<NarayanaEHealthRecord,String> {

    public List<NarayanaEHealthRecord> findByPatientNameAndPatientPhone(String patientName, String patientPhone);

    public NarayanaEHealthRecord findByPatientNameAndAbhaIdAndEhrId(String patientName, String abhaId,String RecordIds);

    public List<NarayanaEHealthRecord> findByAbhaId(String abhaId);

    public List<NarayanaEHealthRecord> findByDoctorNameAndDoctorLicense(String name, String doctorLicense);

    NarayanaEHealthRecord findByEhrId(String ehrId);


    HealthRecord findByPatientNameAndAbhaIdAndDoctorLicense(String name, String abhaId, String doctorLicense);
}
