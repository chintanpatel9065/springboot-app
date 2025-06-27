package org.chintanpatel.springbootapp.designation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("designationRepository")
public interface DesignationRepository extends JpaRepository<Designation, Long> {
}