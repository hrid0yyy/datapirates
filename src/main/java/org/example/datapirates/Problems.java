package org.example.datapirates;

import javafx.scene.control.Button;

public class Problems {
    int ProblemID;
    String ProblemName, ProblemType, ProblemDescription;

    Problems(int ProblemID, String ProblemName,String ProblemType,String ProblemDescription) {
        this.ProblemID = ProblemID;
        this.ProblemName = ProblemName;
        this.ProblemType = ProblemType;
        this.ProblemDescription = ProblemDescription;
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

