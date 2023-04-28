public enum AgeCategory {
    ADULTS(5), TEENAGERS(10), CHILDREN(15);
    private double reductionPercentage;

    AgeCategory(double reductionPercentage) {
        this.reductionPercentage = reductionPercentage;
    }

    public double getReductionPercentage() {
        return reductionPercentage;
    }

    public void setReductionPercentage(double reductionPercentage) {
        this.reductionPercentage = reductionPercentage;
    }

    @Override
    public String toString() {
        return "AgeCategory{" +
                "reductionPercentage=" + reductionPercentage +
                '}';
    }
}
