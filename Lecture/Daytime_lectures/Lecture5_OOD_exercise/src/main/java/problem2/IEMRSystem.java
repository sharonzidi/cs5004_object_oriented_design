package problem2;

import java.time.LocalDate;
import java.util.List;

public interface IEMRSystem {

  /**
   * Check whether or not the EMRSystem is empty.
   * Returns true if empty, false otherwise.
   * @return true if empty, false otherwise.
   */
  Boolean isEmpty();

  /**
   * Count the number of PatientEMR in the EMRSystem.
   * Returns the number of PatientEMR in the EMRSystem.
   * @return number of PatientEMR in the EMRSystem.
   */
  Integer size();

  /**
   * Add a PatientEMR to the EMRSystem.
   * @param patientEMR - the patient to add.
   * Returns a new IEMRSystem with the patient added.
   * @return a new IEMRSystem with the patient added.
   */
  IEMRSystem add(PatientEMR patientEMR);

  /**
   * Remove a specified PatientEMR from the EMRSystem.
   * @param patientEMR - the patient to remove.
   * Returns a new IEMRSystem with the patient removed.
   * @return a new IEMRSystem with the patient removed.
   */
  IEMRSystem remove(PatientEMR patientEMR) throws PatientEMRNotFoundException;

  /**
   * Check for a specified PatientEMR in the EMRSystem.
   * @param patientEMR - the patient to check.
   * Returns true if the patient can be found, false otherwise.
   * @return true if the patient can be found, false otherwise.
   */
  Boolean contains(PatientEMR patientEMR);

  /**
   * Find and return all EMRPatients from the EMRSystem who have the same diagnosis.
   * @param diagnosis - the specified diagnosis to find.
   * Returns all EMRPatients from the EMRSystem who have the same diagnosis.
   * @return all EMRPatients from the EMRSystem who have the same diagnosis.
   */
  List<PatientEMR> findDiagnosis(String diagnosis);

  /**
   * Find and return all EMRPatients from the EMRSystem who have visited the same specified medical
   * facility on the same specified date.
   * @param facility - the specified facility to find.
   * @param date - the date to find.
   * Returns all EMRPatients from the EMRSystem who have visited the same specified medical
   * facility on the same specified date.
   * @return all EMRPatients from the EMRSystem who have visited the same specified medical
   * facility on the same specified date.
   */
  List<PatientEMR> findFacilityNDate(String facility, LocalDate date);
  /**
   * Find and return all EMRPatients from the EMRSystem who have visited the same specified medical
   * practitioners on the same date.
   * @param practitioner - the specified practitioner to find.
   * @param date - the date to find.
   * Returns all EMRPatients from the EMRSystem who have visited the same specified medical
   * practitioners on the same date.
   * @return all EMRPatients from the EMRSystem who have visited the same specified medical
   * practitioners on the same date.
   */
  List<PatientEMR> findPractitionersNDate(Name[] practitioner, LocalDate date);
  /**
   * Get a PatientEMR from the EMRSystem based upon the PatientEMR’s unique identifier,
   * medicalRecordNumber.
   * @param medicalRecordNumber - the unique identifier to find.
   * Returns the specified patient with his/her medical record info.
   * @return the specified patient with his/her medical record info.
   */
  PatientEMR getPatient(String medicalRecordNumber) throws
      InvalidMedicalRecordNumberException, PatientEMRNotFoundException;
}
