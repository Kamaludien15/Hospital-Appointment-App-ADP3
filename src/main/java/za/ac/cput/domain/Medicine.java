/*
 * Medicine.java
 * Entity for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Medicine {
    @Id
    @Column(name ="medicine_id")
    private String medicineID;
    private String medicineName;
    private String volume;
    private String dosage;
    private String price;

    protected Medicine() {}

    private Medicine(Builder builder) {
        this.medicineID = builder.medicineID;
        this.medicineName = builder.medicineName;
        this.volume = builder.volume;
        this.dosage = builder.dosage;
        this.price = builder.price;
    }

    public String getMedicineID() {
        return medicineID;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public String getVolume() {
        return volume;
    }

    public String getDosage() {
        return dosage;
    }

    public String getPrice() {
        return price;
    }

    public static class Builder {
        private String medicineID, medicineName, volume, dosage, price;

        public Builder setMedicineID(String medicineID) {
            this.medicineID = medicineID;
            return this;
        }

        public Builder setMedicineName(String medicineName) {
            this.medicineName = medicineName;
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
            this.medicineName = medicine.medicineName;
            this.volume = medicine.volume;
            this.dosage = medicine.dosage;
            this.price = medicine.price;
            return this;
        }

        public Medicine build() {
            return new Medicine(this);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return medicineID.equals(medicine.medicineID) && medicineName.equals(medicine.medicineName) && volume.equals(medicine.volume) && dosage.equals(medicine.dosage) && price.equals(medicine.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(medicineID, medicineName, volume, dosage, price);
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "medicineID='" + medicineID + '\'' +
                ", medicineName='" + medicineName + '\'' +
                ", volume='" + volume + '\'' +
                ", dosage='" + dosage + '\'' +
                ", price='" + price + '\'' +
                '}';
    }
}
