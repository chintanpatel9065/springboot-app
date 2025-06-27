package org.chintanpatel.springbootapp.designation;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service("designationService")
public class DesignationService {

    private final DesignationRepository designationRepository;

    public DesignationService(DesignationRepository designationRepository) {
        this.designationRepository = designationRepository;
    }

    public void addDesignation(Designation designation){
        designationRepository.save(designation);
    }

    public List<Designation>getAllDesignationList(){
        return designationRepository.findAll();
    }

    public Designation getDesignationById(Long designationId){
        return designationRepository.findById(designationId).orElse(null);
    }

    public void deleteDesignationById(Long designationId){
        designationRepository.deleteById(designationId);
    }
}
