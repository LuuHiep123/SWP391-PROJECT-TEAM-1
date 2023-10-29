/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import java.util.Date;

public class SubjectDTO {

    private String Subject_ID;
    private String Subject_Name;
    private String Exam_Code;
    private String Form;

    public SubjectDTO(String Subject_ID, String Subject_Name, String Exam_Code, String Form) {
        this.Subject_ID = Subject_ID;
        this.Subject_Name = Subject_Name;
        this.Exam_Code = Exam_Code;
        this.Form = Form;
    }

    public String getSubject_ID() {
        return Subject_ID;
    }

    public void setSubject_ID(String Subject_ID) {
        this.Subject_ID = Subject_ID;
    }

    public String getSubject_Name() {
        return Subject_Name;
    }

    public void setSubject_Name(String Subject_Name) {
        this.Subject_Name = Subject_Name;
    }

    public String getExam_Code() {
        return Exam_Code;
    }

    public void setExam_Code(String Exam_Code) {
        this.Exam_Code = Exam_Code;
    }

    public String getForm() {
        return Form;
    }

    public void setForm(String Form) {
        this.Form = Form;
    }

}
