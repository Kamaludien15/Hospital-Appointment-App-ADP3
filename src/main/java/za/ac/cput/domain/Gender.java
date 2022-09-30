package za.ac.cput.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Rhegan Albert Fortuin
 * 219273693
 * Gender entity
 * 14 August 2022
 */

@Entity
public class Gender {
    //variables
    @Id
    @Column(name = "gender_id")
    private String genderID;
    private String name;
    private String description;
    private String sex;

    //builder constructor
    public Gender(genderBuilder builder) {
        this.genderID = builder.genderID;
        this.name = builder.name;
        this.description = builder.description;
        this.sex = builder.sex;
    }

    //constructor
    protected Gender() {
    }

    //getters
    public String getGenderID() {
        return genderID;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSex() {
        return sex;
    }

    //toString
    @Override
    public String toString() {
        return "gender{" +
                "genderID='" + genderID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    //Equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gender that = (Gender) o;
        return genderID.equals(that.genderID) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(sex, that.sex);
    }

    //Hashcode
    @Override
    public int hashCode() {
        return Objects.hash(genderID, name, description, sex);
    }

    //builder class
    public static class genderBuilder {
        private String genderID;
        private String name;
        private String description;
        private String sex;

        public genderBuilder setGenderID(String genderID) {
            this.genderID = genderID;
            return this;
        }

        public genderBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public genderBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public genderBuilder setSex(String sex) {
            this.sex = sex;
            return this;
        }

        @Override
        public String toString() {
            return "genderBuilder{" +
                    "genderID='" + genderID + '\'' +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }

        public genderBuilder copy(Gender gender) {
            this.genderID = gender.genderID;
            this.name = gender.name;
            this.description = gender.description;
            this.sex = gender.sex;

            return this;
        }

        public Gender build() {
            return new Gender(this);
        }
    }
}
