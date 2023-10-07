package model;

import java.util.HashMap;
import java.util.Map;

public class DoctorData {
    private Map<String, Doctor> doctorDatabase;

    public DoctorData() {
        doctorDatabase = new HashMap<>();
    }

    public boolean addDoctor(Doctor doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("Data does not exist.");
        }

        if (doctorDatabase.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code: " + doctor.getCode() + " is duplicate");
        }

        doctorDatabase.put(doctor.getCode(), doctor);
        return true;
    }

    public boolean updateDoctor(Doctor doctor) throws Exception {
        if (doctor == null) {
            throw new Exception("Data does not exist.");
        }

        if (!doctorDatabase.containsKey(doctor.getCode())) {
            throw new Exception("Doctor code does not exist.");
        }

        Doctor existedDoctor = doctorDatabase.get(doctor.getCode());

        if (doctor.getName() != null) {
            existedDoctor.setName(doctor.getName());
        }
        if (doctor.getSpecialization() != null) {
            existedDoctor.setSpecialization(doctor.getSpecialization());
        }
        if (doctor.getAvailability() >= 0) {
            existedDoctor.setAvailability(doctor.getAvailability());
        }

        return true;
    }

    public boolean deleteDoctor(String code) throws Exception {
        if (code == null) {
            throw new Exception("Data does not exist.");
        }

        if (!doctorDatabase.containsKey(code)) {
            throw new Exception("Doctor code does not exist.");
        }
        doctorDatabase.remove(code);
        return true;
    }

    public Map<String, Doctor> searchDoctor(String input) throws Exception {
        if (input == null) {
            throw new Exception("Data does not exist.");
        }

        Map<String, Doctor> result = new HashMap<>();
        for (Doctor doctor : doctorDatabase.values()) {
            if (doctor.getName().toLowerCase().contains(input.toLowerCase())
                    || doctor.getSpecialization().toLowerCase().contains(input.toLowerCase())) {
                result.put(doctor.getCode(), doctor);
            }
        }

        return result;
    }
}
