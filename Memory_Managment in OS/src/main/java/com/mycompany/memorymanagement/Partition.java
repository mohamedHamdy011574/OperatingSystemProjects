package com.mycompany.memorymanagement;

import java.util.*;
import java.util.ArrayList;

public class Partition {
    // name of partition
    String partitionName;
    // size of partition
    int PartitionSize;
    // array that will put on it not added process
    ArrayList<Process> processesNotAdded = new ArrayList<>();
    // state of partition will be process if partition put processs on it and if process not added it will be by defult ExternalFragment
    String state = "ExternalFragment";

    public Partition() {
    }

    public Partition(String partitionName, int PartitionSize) {
        this.partitionName = partitionName;
        this.PartitionSize = PartitionSize;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public int getPartitionSize() {
        return PartitionSize;
    }

    public void setPartitionSize(int PartitionSize) {
        this.PartitionSize = PartitionSize;
    }

    public void setPartitionName(String partitionName) {
        this.partitionName = partitionName;
    }

    public String getPartitionName() {
        return partitionName;
    }

    //// frist fit if user make frist fit frist location will hold the size of partition
/// if we call compact and then frist fit the location will be naumber of last partition
    ArrayList<Partition> firstFit(ArrayList<Process> processes, ArrayList<Partition> Partitions, int location) {
        boolean flag = true;
        for (int i = 0; i < processes.size(); i++) {
            int j = 0;
            while (flag) {
                if (processes.get(i).getProcessSize() <= Partitions.get(j).getPartitionSize()) {
                    if (Partitions.get(j).getPartitionSize() - processes.get(i).getProcessSize() > 0) {
                        String name;
                        //int n = Partitions.size();
                        name = "P" + location++;
                        int size = Partitions.get(j).getPartitionSize() - processes.get(i).getProcessSize();
                        Partitions.add(j + 1, new Partition(name, size));
                        Partitions.get(j).setState(processes.get(i).getProcessName());
                        Partitions.get(j).setPartitionSize(processes.get(i).getProcessSize());
                        flag = false;
                    } else {
                        Partitions.get(j).setState(processes.get(i).getProcessName());
                    }
                } else {
                    if (j == Partitions.size() - 1) {
                        flag = false;
                        processesNotAdded.add(processes.get(i));
                    }
                }
                j++;
            }
            flag = true;
        }
        return Partitions;
    }

    // search for smallest partition that will fit this process
    int searchBest(ArrayList<Partition> Partitions, int processSize) {
        int targetPartition = -1;
        int minDifference = 10000;
        for (int i = 0; i < Partitions.size(); i++) {
            if ((Partitions.get(i).getPartitionSize() - processSize) < minDifference && (Partitions.get(i).getPartitionSize() - processSize) >= 0) {
                minDifference = Partitions.get(i).getPartitionSize() - processSize;
                targetPartition = i;

            }
        }
        return targetPartition;
    }

    // search for large partition that will fit this process
    int searchWorest(ArrayList<Partition> Partitions, int processSize) {
        int targetPartition = -1;
        int maxDifference = 0;
        for (int i = 0; i < Partitions.size(); i++) {
            if (Partitions.get(i).getPartitionSize() - processSize > 0
                    && Partitions.get(i).getPartitionSize() - processSize > maxDifference) {
                maxDifference = Partitions.get(i).getPartitionSize() - processSize;
                targetPartition = i;
            }
        }
        return targetPartition;
    }

    //// best fit if user make best fit frist location will hold the size of partition
    /// if we call compact and then best fit the location will be naumber of last partition
    ArrayList<Partition> bestFit(ArrayList<Process> processes, ArrayList<Partition> Partitions, int location) {

        for (int i = 0; i < processes.size(); i++) {
            int j = searchBest(Partitions, processes.get(i).getProcessSize());

            if (j != -1) {
                if (Partitions.get(j).getPartitionSize() - processes.get(i).getProcessSize() >= 0) {
                    String name;
                    int n = Partitions.size();
                    name = "P" + location++;
                    int size = Partitions.get(j).getPartitionSize() - processes.get(i).getProcessSize();
                    // make new partition because we have space in partition
                    if (Partitions.get(j).getPartitionSize() - processes.get(i).getProcessSize() != 0) {
                        Partitions.add(j + 1, new Partition(name, size));
                    }

                    Partitions.get(j).setState(processes.get(i).getProcessName());
                    Partitions.get(j).setPartitionSize(processes.get(i).getProcessSize());
                }
                Partitions.get(j).setPartitionSize(processes.get(i).getProcessSize());
            } else {
                processesNotAdded.add(processes.get(i));
            }
        }
        return Partitions;
    }

    ArrayList<Partition> worstFit(ArrayList<Process> processes, ArrayList<Partition> Partitions, int location) {
        for (int i = 0; i < processes.size(); i++) {
            int j = searchWorest(Partitions, processes.get(i).getProcessSize());
            if (j != -1) {
                String name = "p" + location++;
                int size = Partitions.get(j).getPartitionSize() - processes.get(i).getProcessSize();
                // make new partition only if substraction not equal 0
                if (Partitions.get(j).getPartitionSize() - processes.get(i).getProcessSize() != 0) {
                    Partitions.add(j + 1, new Partition(name, size));
                }
                Partitions.get(j).setState(processes.get(i).getProcessName());
                Partitions.get(j).setPartitionSize(processes.get(i).getProcessSize());
            } else {
                processesNotAdded.add(processes.get(i));
            }
        }
        return Partitions;
    }

    ArrayList<Partition> compact(ArrayList<Partition> partitions, int selection) {
        ArrayList<Partition> compact = new ArrayList<>();
        ArrayList<Partition> result = new ArrayList<>();
        String processNumber = "";
        int PartitionSize = partitions.size();
        int newSize = 0;
        for (int i = 0; i < partitions.size(); i++) {
            if (partitions.get(i).getState().equals("ExternalFragment")) {
                newSize += partitions.get(i).getPartitionSize();
            } else {
                compact.add(partitions.get(i));
            }
        }
        compact.add(new Partition("p" + PartitionSize, newSize));
        for (int i = 0; i < compact.get(compact.size() - 1).getPartitionName().length(); i++) {
            if (compact.get(compact.size() - 1).getPartitionName().charAt(i) >= 48
                    && compact.get(compact.size() - 1).getPartitionName().charAt(i) <= 57) {
                processNumber += compact.get(compact.size() - 1).getPartitionName().charAt(i);
            }
        }
        int j = Integer.parseInt(processNumber) + 1;
        if (selection == 1) {
            result = firstFit(processesNotAdded, compact, j);
        } else if (selection == 2) {
            result = bestFit(processesNotAdded, compact, j);
        } else if (selection == 3) {
            result = worstFit(processesNotAdded, compact, j);
        }
        return result;
    }

    void processNotAdded() {

        for (int i = 0; i < processesNotAdded.size(); i++) {
            System.out.println(processesNotAdded.get(i).getProcessName() + " can not be allocated ");
        }
    }
}