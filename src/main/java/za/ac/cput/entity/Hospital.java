/* Hospital.java
 Entity for the Hospital
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.entity;

public class Hospital {

    //-----Variables-----
    private String hospitalID;
    private String hospitalName;
    private int hospitalCapacity;
    private String hospitalSector;

    //-----Constructor-----
    public Hospital(Hospital.Builder builder) {
        this.hospitalID = builder.hospitalID;
        this.hospitalName = builder.hospitalName;
        this.hospitalCapacity = builder.hospitalCapacity;
        this.hospitalSector = builder.hospitalSector;
    }

    //-----Getter and Setters-----
    public String getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public int getHospitalCapacity() {
        return hospitalCapacity;
    }

    public void setHospitalCapacity(int hospitalCapacity) {
        this.hospitalCapacity = hospitalCapacity;
    }

    public String getHospitalSector() {
        return hospitalSector;
    }

    public void setHospitalSector(String hospitalSector) {
        this.hospitalSector = hospitalSector;
    }

    //-----ToString-----
    @Override
    public String toString() {
        return "Hospital{" +
                "hospitalID='" + hospitalID + '\'' +
                ", hospitalName='" + hospitalName + '\'' +
                ", hospitalCapacity=" + hospitalCapacity +
                ", hospitalSector='" + hospitalSector + '\'' +
                '}';
    }

    //-----Builder-----
    public static class Builder{
        private String hospitalID;
        private String hospitalName;
        private int hospitalCapacity;
        private String hospitalSector;

        public Hospital.Builder setHospitalID(String hospitalID) {
            this.hospitalID = hospitalID;
            return this;
        }

        public Hospital.Builder setHospitalName(String hospitalName) {
            this.hospitalName = hospitalName;
            return this;
        }

        public Hospital.Builder setHospitalCapacity(int hospitalCapacity) {
            this.hospitalCapacity = hospitalCapacity;
            return this;
        }

        public Hospital.Builder setHospitalSector(String hospitalSector) {
            this.hospitalSector = hospitalSector;
            return this;
        }

        public Hospital.Builder copy(Hospital Hospital){
            this.hospitalID = Hospital.hospitalID;
            this.hospitalName = Hospital.hospitalName;
            this.hospitalCapacity = Hospital.hospitalCapacity;
            this.hospitalSector = Hospital.hospitalSector;

            return this;
        }

        public Hospital build(){

            return new Hospital(this);

        }

    }
}
