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
    private String designationName;

    public Designation() {
    }

    public Designation(Long designationId, String designationName) {
        this.designationId = designationId;
        this.designationName = designationName;
    }

    public Long getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Long designationId) {
        this.designationId = designationId;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }
}
