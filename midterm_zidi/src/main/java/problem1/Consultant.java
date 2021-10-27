package problem1;

public abstract class Consultant implements IEmployees {
    protected Double consultingRate;
    protected Integer contractualNumberOfConsultingHours;
    protected Integer actualNumberOfConsultingHours;


    public Consultant(Double consultingRate, Integer contractualNumberOfConsultingHours, Integer actualNumberOfConsultingHours) {
        this.consultingRate = consultingRate;

        this.contractualNumberOfConsultingHours = contractualNumberOfConsultingHours;
        this.actualNumberOfConsultingHours = actualNumberOfConsultingHours;
    }

    public Double getConsultingRate() {
        return consultingRate;
    }

    public Integer getContractualNumberOfConsultingHours() {
        return contractualNumberOfConsultingHours;
    }

    public Integer getActualNumberOfConsultingHours() {
        return actualNumberOfConsultingHours;
    }

    public Integer getBaseProductivity() {
        int baseProductivity = (this.actualNumberOfConsultingHours - this.contractualNumberOfConsultingHours)/100;
        return baseProductivity;
    }

    public Double getEstimateBaseProductivity() {
        int baseProductivity = this.getBaseProductivity();
        Double estimateBaseProductivity = baseProductivity * this.getConsultingRate();
        return estimateBaseProductivity;
    }


    public Double estimateProductivity() {
        Double consultingR = this.getEstimateBaseProductivity() * this.getConsultingRate();
        return consultingR;
    }
}
