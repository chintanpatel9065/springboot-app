package org.chintanpatel.springbootapp.designation;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "tbl_designation")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "designation_id", nullable = false)
    private Long designationId;

    @NotEmpty(message = "Please Provide Designation Type")
    @Column(name = "designation_type", nullable = false)
    private String designationType;

    public Designation() {
    }

    public Designation(Long designationId, String designationType) {
        this.designationId = designationId;
        this.designationType = designationType;
    }

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public String getDesignationType() {
        return designationType;
    }

    public void setDesignationType(String designationType) {
        this.designationType = designationType;
    }
}
