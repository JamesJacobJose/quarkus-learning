package division;

import java.sql.Timestamp;

import javax.persistence.Entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity(name = "divisions")
public class DivisionEntity extends PanacheEntity{

    public Long organizationId;
    public String code;
    public String name;
    public String shortName;
    public String taxIdentifier;
    public String details;
    public String notes;
    public String createdBy;
    public String updatedBy;
    public Timestamp createdAt;
    public Timestamp updatedAt;
    
}
