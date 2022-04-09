/* Location.java
 Entity for the Location
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.entity;

public class Location {

    //-----Variables-----
    private String locationID;
    private String streetName;
    private int streetNum;
    private String suburb;
    private int postalCode;

    //-----Constructor-----
    public Location(Location.Builder builder) {
        this.locationID = builder.locationID;
        this.streetName = builder.streetName;
        this.streetNum = builder.streetNum;
        this.suburb = builder.suburb;
        this.postalCode = builder.postalCode;
    }

    //-----Getter and Setters-----

    public String getLocationID() {
        return locationID;
    }

    public void setLocationID(String locationID) {
        this.locationID = locationID;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public int getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(int streetNum) {
        this.streetNum = streetNum;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
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

}
