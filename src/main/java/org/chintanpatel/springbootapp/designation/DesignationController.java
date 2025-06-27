package org.chintanpatel.springbootapp.designation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class DesignationController {

    private final DesignationService designationService;

    public DesignationController(DesignationService designationService) {
        this.designationService = designationService;
    }

    @GetMapping("/designations/listDesignation")
    public String listDesignation(Model model) {
        List<Designation> designationList = designationService.getAllDesignationList();
        model.addAttribute("designationList", designationList);
        return "designation/designation-list";
    }

    @GetMapping("/designations/showDesignationForm")
    public String showDesignationForm(Model model) {
        Designation designation = new Designation();
        model.addAttribute("designation", designation);
        return "designation/designation-form";
    }

    @PostMapping("/designations/insertOrUpdateDesignation")
    public String insertOrUpdateDesignation(@Valid @ModelAttribute("designation") Designation designation, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "designation/designation-form";
        }
        designationService.addDesignation(designation);
        return "redirect:/designations/listDesignation";
    }

    @GetMapping("/designations/manageDesignation/{designationId}")
    public String manageDesignation(@PathVariable Long designationId, Model model){
        if (designationId != null){
            Designation designation = designationService.getDesignationById(designationId);
            model.addAttribute("designation", designation);
        }
        return "designation/designation-form";
    }

    @GetMapping("/designations/deleteDesignation/{designationId}")
    public String deleteDesignation(@PathVariable Long designationId){
        if (designationId != null){
            designationService.deleteDesignationById(designationId);
        }
        return "redirect:/designations/listDesignation";
    }
}
