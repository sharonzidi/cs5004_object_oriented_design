package problem2;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

/*
 * Class PatientEMR contains demographic information and medical record of a patient,
 * relevant for the EMRSystem.
 */
public class PatientEMR {
  private String medicalRecordNumber;
  private Name patientsName;
  private LocalDate dateOfBirth;

  private LocalDate dateOfLastVisit;
  private String visitedMedicalFacility;
  private Name [] visitedMedicalPractitioners;

  private Float heightDuringLastVisit;
  private Float weightDuringLastVisit;
  private String diagnosis;
  private String [] prescribedMedication;

  /*
   * Constructor for PatientEMR
   * @param medicalRecordNumber - String, representing a unique number assigned to every patient
   * @param patientsName - Name, storing information about patient's name
   * @param dateOfBirth - LocalDate, storing information about patient's date of birth
   * @param dateOfLastVisit - LocalDate, storing information about patient's last visit
   * @param visitedMedicalFacility - String, storing information about the medical facility patient visited last
   * @param visitedMedicalPractitioners - array of Name, storing information about medical practitioners visited
   * during the last visit
   * @param heightDuringLastVisit - Float, representing height in centimeters (e.g, 6'00'' ~ 200 cm)
   * @param weightDuringLastVisit - Float, representing weight in pounds
   * @param diagnosis - String, representing patient's diagnosis
   * @param prescribedMedication - array of String, representing medication prescribed to the patient during the last
   * visit
   */
  public PatientEMR(String medicalRecordNumber, Name patientsName, LocalDate dateOfBirth, LocalDate dateOfLastVisit,
                    String visitedMedicalFacility, Name[] visitedMedicalPractitioners, Float heightDuringLastVisit,
                    Float weightDuringLastVisit, String diagnosis, String[] prescribedMedication) {
    this.medicalRecordNumber = medicalRecordNumber;
    this.patientsName = patientsName;
    this.dateOfBirth = dateOfBirth;
    this.dateOfLastVisit = dateOfLastVisit;
    this.visitedMedicalFacility = visitedMedicalFacility;
    this.visitedMedicalPractitioners = visitedMedicalPractitioners;
    this.heightDuringLastVisit = heightDuringLastVisit;
    this.weightDuringLastVisit = weightDuringLastVisit;
    this.diagnosis = diagnosis;
    this.prescribedMedication = prescribedMedication;
  }

  public String getMedicalRecordNumber() {
    return medicalRecordNumber;
  }

  public void setMedicalRecordNumber(String medicalRecordNumber) {
    this.medicalRecordNumber = medicalRecordNumber;
  }

  public Name getPatientsName() {
    return patientsName;
  }

  public void setPatientsName(Name patientsName) {
    this.patientsName = patientsName;
  }

  public LocalDate getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(LocalDate dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  public LocalDate getDateOfLastVisit() {
    return dateOfLastVisit;
  }

  public void setDateOfLastVisit(LocalDate dateOfLastVisit) {
    this.dateOfLastVisit = dateOfLastVisit;
  }

  public String getVisitedMedicalFacility() {
    return visitedMedicalFacility;
  }

  public void setVisitedMedicalFacility(String visitedMedicalFacility) {
    this.visitedMedicalFacility = visitedMedicalFacility;
  }

  public Name[] getVisitedMedicalPractitioners() {
    return visitedMedicalPractitioners;
  }

  public void setVisitedMedicalPractitioners(Name[] visitedMedicalPractitioners) {
    this.visitedMedicalPractitioners = visitedMedicalPractitioners;
  }

  public Float getHeightDuringLastVisit() {
    return heightDuringLastVisit;
  }

  public void setHeightDuringLastVisit(Float heightDuringLastVisit) {
    this.heightDuringLastVisit = heightDuringLastVisit;
  }

  public Float getWeightDuringLastVisit() {
    return weightDuringLastVisit;
  }

  public void setWeightDuringLastVisit(Float weightDuringLastVisit) {
    this.weightDuringLastVisit = weightDuringLastVisit;
  }

  public String getDiagnosis() {
    return diagnosis;
  }

  public void setDiagnosis(String diagnosis) {
    this.diagnosis = diagnosis;
  }

  public String[] getPrescribedMedication() {
    return prescribedMedication;
  }

  public void setPrescribedMedication(String[] prescribedMedication) {
    this.prescribedMedication = prescribedMedication;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof PatientEMR)) return false;
    PatientEMR that = (PatientEMR) o;
    return Objects.equals(getMedicalRecordNumber(), that.getMedicalRecordNumber()) &&
        Objects.equals(getPatientsName(), that.getPatientsName()) &&
        Objects.equals(getDateOfBirth(), that.getDateOfBirth()) &&
        Objects.equals(getDateOfLastVisit(), that.getDateOfLastVisit()) &&
        Objects.equals(getVisitedMedicalFacility(), that.getVisitedMedicalFacility()) &&
        Arrays.equals(getVisitedMedicalPractitioners(), that.getVisitedMedicalPractitioners()) &&
        Objects.equals(getHeightDuringLastVisit(), that.getHeightDuringLastVisit()) &&
        Objects.equals(getWeightDuringLastVisit(), that.getWeightDuringLastVisit()) &&
        Objects.equals(getDiagnosis(), that.getDiagnosis()) &&
        Arrays.equals(getPrescribedMedication(), that.getPrescribedMedication());
  }

  @Override
  public int hashCode() {
    int result = Objects.hash(getMedicalRecordNumber(), getPatientsName(), getDateOfBirth(),
        getDateOfLastVisit(), getVisitedMedicalFacility(), getHeightDuringLastVisit(),
        getWeightDuringLastVisit(), getDiagnosis());
    result = 31 * result + Arrays.hashCode(getVisitedMedicalPractitioners());
    result = 31 * result + Arrays.hashCode(getPrescribedMedication());
    return result;
  }

  @Override
  public String toString() {
    return "PatientEMR{" +
        "medicalRecordNumber='" + medicalRecordNumber + '\'' +
        ", patientsName=" + patientsName +
        ", dateOfBirth=" + dateOfBirth +
        ", dateOfLastVisit=" + dateOfLastVisit +
        ", visitedMedicalFacility='" + visitedMedicalFacility + '\'' +
        ", visitedMedicalPractitioners=" + Arrays.toString(visitedMedicalPractitioners) +
        ", heightDuringLastVisit=" + heightDuringLastVisit +
        ", weightDuringLastVisit=" + weightDuringLastVisit +
        ", diagnosis='" + diagnosis + '\'' +
        ", prescribedMedication=" + Arrays.toString(prescribedMedication) +
        '}';
  }
}
