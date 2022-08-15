package za.ac.cput.domain;

/*
ContactType.java
 entity for the ContactType
 Author: Kamaludien Sonday (218168128)
 Date: 10 April 2022
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class ContactType {
    @Id
    @Column(name = "contact_type_id")
    private String contactTypeId;
    private String name;
    private boolean urgent;
    private String description;

    private ContactType(Builder builder){
        this.contactTypeId = builder.contactTypeId;
        this.name = builder.name;
        this.urgent = builder.urgent;
        this.description = builder.description;
    }

    protected ContactType(){};

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


    @Override
    public String toString() {
        return "ContactType{" +
                "contactTypeId='" + contactTypeId + '\'' +
                ", name='" + name + '\'' +
                ", urgent=" + urgent +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactType that = (ContactType) o;
        return urgent == that.urgent && Objects.equals(contactTypeId, that.contactTypeId) && Objects.equals(name, that.name) && Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactTypeId, name, urgent, description);
    }
}