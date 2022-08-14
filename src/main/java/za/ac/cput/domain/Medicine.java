/*
 * Medicine.java
 * Entity for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.domain;

public class Medicine {
    private String medicineID, volume, dosage, price;

    private Medicine(Builder builder) {
        this.medicineID = builder.medicineID;
        this.volume = builder.volume;;
        this.dosage = builder.dosage;
        this.price = builder.price;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public void setMedicineID(String medicineID) {
        this.medicineID = medicineID;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineID='" + medicineID + '\'' +
                ", volume='" + volume + '\'' +
                ", dosage='" + dosage + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public static class Builder {
        private String medicineID, volume, dosage, price;

        public Builder setMedicineID(String medicineID) {
            this.medicineID = medicineID;
            return this;
        }

        public Builder setVolume(String volume) {
            this.volume = volume;
            return this;
        }

        public Builder setDosage(String dosage) {
            this.dosage = dosage;
            return this;
        }

        public Builder setPrice(String price) {
            this.price = price;
            return this;
        }

        public Builder copy(Medicine medicine) {
            this.medicineID = medicine.medicineID;
            this.volume = medicine.volume;
            this.dosage = medicine.dosage;
            this.price = medicine.price;
            return this;
        }

        public Medicine build() {
            return new Medicine(this);
        }
    }
}
