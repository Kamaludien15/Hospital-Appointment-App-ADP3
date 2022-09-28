/* HospitalLocation.java
 Entity for the HospitalLocation
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.entity;

public class HospitalLocation {

    //-----Variables-----
    private String hospitalID;
    private String locationID;

    //-----Constructor-----
    public HospitalLocation(HospitalLocation.Builder builder) {
        this.hospitalID = builder.hospitalID;
        this.locationID = builder.locationID;
    }

    //-----Getter and Setters-----

    public String getHospitalID() {
        return hospitalID;
    }

    public void setHospitalID(String hospitalID) {
        this.hospitalID = hospitalID;
    }

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    //-----ToString-----

    @Override
    public String toString() {
        return "HospitalLocation{" +
                "hospitalID='" + hospitalID + '\'' +
                ", locationID='" + locationID + '\'' +
                '}';
    }

    //-----Builder-----
    public static class Builder{
        private String hospitalID;
        private String locationID;

        public HospitalLocation.Builder setHospitalID(String hospitalID) {
            this.hospitalID = hospitalID;
            return this;
        }

        public HospitalLocation.Builder setLocationID(String locationID) {
            this.locationID = locationID;
            return this;
        }


        public HospitalLocation.Builder copy(HospitalLocation HospitalLocation){
            this.hospitalID = HospitalLocation.hospitalID;
            this.locationID = HospitalLocation.locationID;

            return this;
        }

        public HospitalLocation build(){

            return new HospitalLocation(this);

        }

    }
}
