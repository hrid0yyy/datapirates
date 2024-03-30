package org.example.datapirates;

import javafx.scene.control.Button;

public class Problems {
    int ProblemID;
    String ProblemName, ProblemType, ProblemDescription, driverCode,output,codeFormat;


    Problems(int ProblemID, String ProblemName,String ProblemType,String ProblemDescription,
             String DriverCode, String output, String codeFormat) {
        this.ProblemID = ProblemID;
        this.ProblemName = ProblemName;
        this.ProblemType = ProblemType;
        this.ProblemDescription = ProblemDescription;
        this.driverCode = DriverCode;
        this.output = output;
        this.codeFormat = codeFormat;
    }

    public void setCodeFormat(String codeFormat) {
        this.codeFormat = codeFormat;
    }

    public String getCodeFormat() {
        return codeFormat;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

    public int getProblemID() {
        return ProblemID;
    }

    public void setProblemID(int problemID) {
        ProblemID = problemID;
    }

    public String getProblemName() {
        return ProblemName;
    }

    public void setProblemName(String problemName) {
        ProblemName = problemName;
    }

    public String getProblemDescription() {
        return ProblemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        ProblemDescription = problemDescription;
    }

    public String getProblemType() {
        return ProblemType;
    }

    public void setProblemType(String problemType) {
        ProblemType = problemType;
    }


}

