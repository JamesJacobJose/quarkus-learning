package division;

import java.sql.Timestamp;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.Data;

@RegisterForReflection
@Data
public class Division {
    
    private Long id;
    private Long organizationId;
    private String code;
    private String name;
    private String shortName;
    private String taxIdentifier;
    private String details;
    private String notes;
    private String createdBy;
    private String updatedBy;
    private Timestamp createdAt;
    private Timestamp updatedAt;

}
