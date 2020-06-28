package za.ac.cput.entity;

public class Bursaries {
    private String bursaryName;
    private String bursaryRequirements;

    private Bursaries (Builder builder){

    }

    public String getBursaryName() { return bursaryName;    }

    public String getBursaryRequirements() { return bursaryRequirements; }

    @Override
    public String toString(){
        return "Bursaries{" +
                "Bursary Name='" + bursaryName + '\'' +
                ", Bursary Requirements='" + bursaryRequirements + '\'' +
                '}';
    }

    public static class Builder{
        private String bursaryName;
        private String bursaryRequirements;

        public Builder setBursaryName(String bursaryName) {
            this.bursaryName = bursaryName;
            return this;
        }

        public Builder setBursaryRequirements(String bursaryRequirements) {
            this.bursaryRequirements = bursaryRequirements;
            return this;
        }

        public Bursaries build(){
            return new Bursaries(this);
        }

    }
}
