package org.chintanpatel.springbootapp.employee;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.chintanpatel.springbootapp.department.Department;
import org.chintanpatel.springbootapp.designation.Designation;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Long employeeId;

    @NotEmpty(message = "Please Provide First Name")
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty(message = "Please Provide Middle Name")
    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @NotEmpty(message = "Please Provide Last Name")
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotEmpty(message = "Please Provide Address")
    @Column(name = "address", nullable = false)
    private String address;

    @NotEmpty(message = "Please Provide Gender")
    @Column(name = "gender", nullable = false)
    private String gender;

    @NotEmpty(message = "Please Provide Programming Skill")
    @Column(name = "programming_skill", nullable = false)
    private String[] programmingSkill;

    @Email(message = "Please Provide Valid Email")
    @NotEmpty(message = "Please Provide Email")
    @Column(name = "email", nullable = false)
    private String email;

    @NotEmpty(message = "Please Provide Mobile Number")
    @Column(name = "mobile", nullable = false)
    private String mobile;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Please Provide Birth Date")
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;

    @NotEmpty(message = "Please Provide Language Known")
    @Column(name = "language_known", nullable = false)
    private String[] languageKnown;

    @NotEmpty(message = "Please Provide User Name")
    @Column(name = "user_name", nullable = false)
    private String userName;

    @Size(min = 8, max = 16, message = "Please Provide Password of 8 to 16 Characters")
    @NotEmpty(message = "Please Provide Password")
    @Column(name = "password", nullable = false)
    private String password;

    @Valid
    @ManyToOne
    @NotNull(message = "Please Provide Department")
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

    @Valid
    @ManyToOne
    @NotNull(message = "Please Provide Designation")
    @JoinColumn(name = "designation_id", nullable = false)
    private Designation designation;

    public Employee() {
    }

    public Employee(Long employeeId, String firstName, String middleName, String lastName, String address, String gender, String[] programmingSkill, String email, String mobile, LocalDate birthDate, String[] languageKnown, String userName, String password, Department department, Designation designation) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.address = address;
        this.gender = gender;
        this.programmingSkill = programmingSkill;
        this.email = email;
        this.mobile = mobile;
        this.birthDate = birthDate;
        this.languageKnown = languageKnown;
        this.userName = userName;
        this.password = password;
        this.department = department;
        this.designation = designation;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String[] getProgrammingSkill() {
        return programmingSkill;
    }

    public void setProgrammingSkill(String[] programmingSkill) {
        this.programmingSkill = programmingSkill;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String[] getLanguageKnown() {
        return languageKnown;
    }

    public void setLanguageKnown(String[] languageKnown) {
        this.languageKnown = languageKnown;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Designation getDesignation() {
        return designation;
    }

    public void setDesignation(Designation designation) {
        this.designation = designation;
    }
}
