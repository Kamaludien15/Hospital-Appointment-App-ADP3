package za.ac.cput.domain;

<<<<<<< HEAD
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

=======
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
/**
 *
 * Rhegan Albert Fortuin
 * 219273693
<<<<<<< HEAD
 * Gender entity
 * 14 August 2022
 *
 */

@Entity
public class Gender {
    //variables
    @Id
    @Column(name = "gender_id")
=======
 * Patient entity
 * 07 April 2022
 *
 */

public class Gender {
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    private String genderID;
    private String name;
    private String description;
    private String sex;

    //builder constructor
    public Gender(genderBuilder builder){
        this.genderID = builder.genderID;
        this.name = builder.name;
        this.description = builder.description;
        this.sex = builder.sex;
    }

<<<<<<< HEAD
    //constructor
    protected Gender() {}

    //getters
=======
    //setters and getters
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    public String getGenderID() {
        return genderID;
    }

<<<<<<< HEAD
=======
    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    public String getName() {
        return name;
    }

<<<<<<< HEAD
=======
    public void setName(String name) {
        this.name = name;
    }

>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    public String getDescription() {
        return description;
    }

<<<<<<< HEAD
=======
    public void setDescription(String description) {
        this.description = description;
    }

>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    public String getSex() {
        return sex;
    }

<<<<<<< HEAD
    //toString
=======
    public void setSex(String sex) {
        this.sex = sex;
    }

>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    @Override
    public String toString() {
        return "gender{" +
                "genderID='" + genderID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

<<<<<<< HEAD
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

=======
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
    //builder class
    public static class genderBuilder{
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

<<<<<<< HEAD
        public genderBuilder copy(Gender gender){
=======
        public Gender.genderBuilder copy(Gender gender){
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
            this.genderID = gender.genderID;
            this.name = gender.name;
            this.description = gender.description;
            this.sex = gender.sex;

            return this;
        }

<<<<<<< HEAD
        public Gender build(){
=======
        public Gender Builder(){
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
            return new Gender(this);
        }
    }
}
