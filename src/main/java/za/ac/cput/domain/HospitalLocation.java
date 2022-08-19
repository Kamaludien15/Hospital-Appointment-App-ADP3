/* HospitalLocation.java
 Entity for the HospitalLocation
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class HospitalLocation implements Serializable {

    //-----Variables-----
    @Id
    @Column(name ="hospital_location_id")
    private String hospitalLocationId;

    @OneToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "hospital_id")
    private Hospital hospital;

    @OneToOne
    @JoinColumn(name = "location_id", referencedColumnName = "location_id")
    private Location location;

    //-----Constructor-----
    private HospitalLocation(HospitalLocation.Builder builder) {
        this.hospitalLocationId = builder.hospitalLocationId;
        this.hospital = builder.hospital;
        this.location = builder.location;
    }

    protected HospitalLocation() {}

    //-----Getter and Setters-----

    public String getHospitalLocationId() {
        return hospitalLocationId;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public Location getLocation() {
        return location;
    }

    //-----Builder-----
    public static class Builder{
        private String hospitalLocationId;
        private Hospital hospital;
        private Location location;

        public HospitalLocation.Builder setHospitalLocationId(String hospitalLocationId) {
            this.hospitalLocationId = hospitalLocationId;
            return this;
        }

        public HospitalLocation.Builder setHospital(Hospital hospital) {
            this.hospital = hospital;
            return this;
        }

        public HospitalLocation.Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public HospitalLocation.Builder copy(HospitalLocation HospitalLocation){
            this.hospitalLocationId = HospitalLocation.hospitalLocationId;
            this.hospital = HospitalLocation.hospital;
            this.location = HospitalLocation.location;

            return this;
        }

        public HospitalLocation build(){
            return new HospitalLocation(this);
        }

    }

    //-----ToString-----
    @Override
    public String toString() {
        return "HospitalLocation{" +
                "hospitalLocationId='" + hospitalLocationId + '\'' +
                ", hospital=" + hospital +
                ", location=" + location +
                '}';
    }

    //-----Equals----
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HospitalLocation that = (HospitalLocation) o;
        return hospitalLocationId.equals(that.hospitalLocationId) && hospital.equals(that.hospital) && location.equals(that.location);
    }

    //-----Hashcode----
    @Override
    public int hashCode() {
        return Objects.hash(hospitalLocationId, hospital, location);
    }
}
