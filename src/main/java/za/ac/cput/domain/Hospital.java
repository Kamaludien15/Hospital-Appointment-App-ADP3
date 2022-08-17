/* Hospital.java
 Entity for the Hospital
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hospital implements ValueObject{

    //-----Variables-----
    @Id
    @Column(name ="hospital_id")
    private String hospitalID;

    private String hospitalName;
    private int hospitalCapacity;
    private String hospitalSector;

    //-----Constructor-----
    private Hospital(Hospital.Builder builder) {
        this.hospitalID = builder.hospitalID;
        this.hospitalName = builder.hospitalName;
        this.hospitalCapacity = builder.hospitalCapacity;
        this.hospitalSector = builder.hospitalSector;
    }

    protected Hospital() {}

    //-----Getter and Setters-----
    public String getHospitalID() {
        return hospitalID;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public int getHospitalCapacity() {
        return hospitalCapacity;
    }

    public String getHospitalSector() {
        return hospitalSector;
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

    //-----Equals-----
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hospital hospital = (Hospital) o;
        return hospitalCapacity == hospital.hospitalCapacity && hospitalID.equals(hospital.hospitalID) && Objects.equals(hospitalName, hospital.hospitalName) && Objects.equals(hospitalSector, hospital.hospitalSector);
    }

    //-----Hashcode-----
    @Override
    public int hashCode() {
        return Objects.hash(hospitalID, hospitalName, hospitalCapacity, hospitalSector);
    }
}
