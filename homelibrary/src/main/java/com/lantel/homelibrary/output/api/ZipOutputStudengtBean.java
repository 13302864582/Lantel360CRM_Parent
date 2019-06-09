package com.lantel.homelibrary.output.api;

import java.util.List;

public class ZipOutputStudengtBean {
   private List<OutputBean.DataBean.ListBean> outputList;

    private List<StudentBean.DataBean.ListBean> studentList;

    private int StudentError;
    private String StudentMess;

    private int OutputError;
    private String OutputMess;
    private int total;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<OutputBean.DataBean.ListBean> getOutputList() {
        return outputList;
    }

    public void setOutputList(List<OutputBean.DataBean.ListBean> outputList) {
        this.outputList = outputList;
    }

    public List<StudentBean.DataBean.ListBean> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<StudentBean.DataBean.ListBean> studentList) {
        this.studentList = studentList;
    }

    public int getStudentError() {
        return StudentError;
    }

    public void setStudentError(int studentError) {
        StudentError = studentError;
    }

    public String getStudentMess() {
        return StudentMess;
    }

    public void setStudentMess(String studentMess) {
        StudentMess = studentMess;
    }

    public int getOutputError() {
        return OutputError;
    }

    public void setOutputError(int outputError) {
        OutputError = outputError;
    }

    public String getOutputMess() {
        return OutputMess;
    }

    public void setOutputMess(String outputMess) {
        OutputMess = outputMess;
    }
}
