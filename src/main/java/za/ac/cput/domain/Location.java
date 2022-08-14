/* Location.java
 Entity for the Location
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Location {

    //-----Variables-----
    @Id
    @Column(name ="location_id")
    private String locationID;

    private String streetName;
    private int streetNum;
    private String suburb;
    private int postalCode;

    //-----Constructor-----
    private Location(Location.Builder builder) {
        this.locationID = builder.locationID;
        this.streetName = builder.streetName;
        this.streetNum = builder.streetNum;
        this.suburb = builder.suburb;
        this.postalCode = builder.postalCode;
    }

    protected Location() {}

    //-----Getter and Setters-----
    public String getLocationID() {
        return locationID;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public String getSuburb() {
        return suburb;
    }

    public int getPostalCode() {
        return postalCode;
    }


    //-----Builder-----
    public static class Builder{
        private String locationID;
        private String streetName;
        private int streetNum;
        private String suburb;
        private int postalCode;

        public Location.Builder setLocationID(String locationID) {
            this.locationID = locationID;
            return this;
        }

        public Location.Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Location.Builder setStreetNum(int streetNum) {
            this.streetNum = streetNum;
            return this;
        }

        public Location.Builder setSuburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Location.Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }


        public Location.Builder copy(Location Location){
            this.locationID = Location.locationID;
            this.streetName = Location.streetName;
            this.streetNum = Location.streetNum;
            this.suburb = Location.suburb;
            this.postalCode = Location.postalCode;

            return this;
        }

        public Location build(){

            return new Location(this);

        }

    }

    //-----ToString-----
    @Override
    public String toString() {
        return "Location{" +
                "locationID='" + locationID + '\'' +
                ", streetName='" + streetName + '\'' +
                ", streetNum=" + streetNum +
                ", suburb='" + suburb + '\'' +
                ", postalCode=" + postalCode +
                '}';
    }

    //-----Equals----
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return streetNum == location.streetNum && postalCode == location.postalCode &&
                Objects.equals(locationID, location.locationID) && Objects.equals(streetName, location.streetName) && Objects.equals(suburb, location.suburb);
    }

    //-----Hashcode----
    @Override
    public int hashCode() {
        return Objects.hash(locationID, streetName, streetNum, suburb, postalCode);
    }

}
