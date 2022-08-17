package za.ac.cput.domain;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

public class Gender {
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

    //setters and getters
    public String getGenderID() {
        return genderID;
    }

    public void setGenderID(String genderID) {
        this.genderID = genderID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "gender{" +
                "genderID='" + genderID + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

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

        public Gender.genderBuilder copy(Gender gender){
            this.genderID = gender.genderID;
            this.name = gender.name;
            this.description = gender.description;
            this.sex = gender.sex;

            return this;
        }

        public Gender Builder(){
            return new Gender(this);
        }
    }
}
