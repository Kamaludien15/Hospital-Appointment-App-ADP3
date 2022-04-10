package za.ac.cput.entity;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

public class gender {
    int genderID;
    String name;
    String description;
    String sex;

    public gender(genderBuilder builder){
        this.genderID = builder.genderID;
        this.name = builder.name;
        this.description = builder.description;
        this.sex = builder.sex;
    }

    public int setGenderID(int genderID) {
        this.genderID = genderID;
        return genderID;
    }

    public String setName(String name) {
        this.name = name;
        return name;
    }

    public String setDescription(String description) {
        this.description = description;
        return description;
    }

    public String setSex(String sex) {
        this.sex = sex;
        return sex;
    }

    @Override
    public String toString() {
        return "gender{" +
                "genderID=" + genderID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static class genderBuilder{
        private int genderID;
        private String name;
        private String description;
        private String sex;

        public genderBuilder setGenderID(int genderID) {
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
                    "genderID=" + genderID +
                    ", name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", sex='" + sex + '\'' +
                    '}';
        }

        public gender Builder(){
            return new gender(this);
        }
    }
}
