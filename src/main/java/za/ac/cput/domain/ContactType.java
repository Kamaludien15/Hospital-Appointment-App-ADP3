package za.ac.cput.domain;

public class ContactType {
    private String contactTypeId;
    private String name;
    private boolean urgent;
    private String description;

    private ContactType(Builder builder){
        this.contactTypeId = builder.contactTypeId;
        this.name = builder.name;
        this.urgent = builder.urgent;
    }

    public String getContactTypeId() {
        return contactTypeId;
    }

    public String getName() {
        return name;
    }

    public boolean isUrgent() {
        return urgent;
    }

    public String getDescription() {
        return description;
    }

    public static class Builder{
        private String contactTypeId;
        private String name;
        private boolean urgent;
        private String description;

        public Builder setContactTypeId(String contactTypeId){
            this.contactTypeId = contactTypeId;
            return this;
        }
        public Builder setName(String name){
            this.name = name;
            return this;
        }
        public Builder setUrgent(boolean urgent){
            this.urgent = urgent;
            return this;
        }
        public Builder setDescription(String description){
            this.description = description;
            return this;
        }
        public Builder copy( ContactType contactType){
            this.contactTypeId = contactType.contactTypeId;
            this.name = contactType.name;
            this.urgent = contactType.urgent;
            this.description = contactType.description;
            return this;
        }
        public ContactType build(){
            return new ContactType (this);
        }
    }
}