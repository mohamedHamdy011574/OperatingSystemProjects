package com.mycompany.memorymanagement;

import java.util.ArrayList;

/**
 *
 * @author Aliaa
 */
public class Process {

    int processSize;
    String processName;

    public Process(String processName, int processSize) {
        this.processName = processName;
        this.processSize = processSize;
    }

    public void setProcessSize(int processSize) {
        this.processSize = processSize;
    }

    public int getProcessSize() {
        return processSize;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public String getProcessName() {
        return processName;
    }
    

}
