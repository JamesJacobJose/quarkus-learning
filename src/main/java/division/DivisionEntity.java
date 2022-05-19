package division;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity(name = "divisions")
public class DivisionEntity extends PanacheEntity{

    @Id
    @Column(nullable = false)
    private long id;

    @Column(name = "organization_id", nullable = false)
    private long organizationId;

    @Column(nullable = false)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column(name = "short_name", nullable = false)
    private String shortName;

    @Column(name = "tax_identifier", nullable = false)
    private String taxIdentifier;

    @Column(nullable = false)
    private String details;

    @Column(nullable = false)
    private String notes;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy;

    @Column(name = "created_at", nullable = false)
    private Timestamp createdAt;

    @Column(name = "updated_at", nullable = false)
    private Timestamp updatedAt;
    
}
