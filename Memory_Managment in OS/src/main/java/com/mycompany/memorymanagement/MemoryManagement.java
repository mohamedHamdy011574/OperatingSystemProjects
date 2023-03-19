package com.mycompany.memorymanagement;

import java.util.ArrayList;
import java.util.Scanner;

public class MemoryManagement {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
           //FOR array if process that take it from user
        ArrayList<Process> processes = new ArrayList<>();
          //for array of partition that take it from user
        ArrayList<Partition> partitions = new ArrayList<>();
        System.out.println("Enter number of partition : ");
        int numOfPartition = input.nextInt();
        int partitionSize, processSize;
        String partitionName, processName;
        for (int i = 0; i < numOfPartition; i++) {
            System.out.println("Enter name of partition and size : ");
            partitionName = input.next();
            partitionSize = input.nextInt();
            Partition partition = new Partition(partitionName, partitionSize);
            partitions.add(partition);
        }
        System.out.println("Enter number of process : ");
        int numOfProcess = input.nextInt();
        for (int i = 0; i < numOfProcess; i++) {
            System.out.println("Enter name of process and size : ");
            processName = input.next();
            processSize = input.nextInt();
            Process process = new Process(processName, processSize);
            processes.add(process);
        }
         // object that call function from it
        Partition partitionExc = new Partition();
       // this array will put on it return of function like best and worest and best and make print on it 
        ArrayList<Partition> ps = new ArrayList<>();
       ///array that take return from compact
        ArrayList<Partition> compactPs = new ArrayList<>();
        System.out.println("1 - first fit :");
        System.out.println("2 - best fit :");
        System.out.println("3 - worstfit:");
        System.out.println("Select the policy you want to apply:");
        int selection = input.nextInt();

        if (selection == 1) {
            ps = partitionExc.firstFit(processes, partitions,partitions.size());
            for (int i = 0; i < ps.size(); i++) {
                System.out.println(partitions.get(i).getPartitionName() + "\t\t " + "(" + partitions.get(i).getPartitionSize() + "KB)" + "\t\t " + partitions.get(i).getState());
            }
            partitionExc.processNotAdded();
        } else if (selection == 2) {
            ps = partitionExc.bestFit(processes, partitions,partitions.size());
            for (int i = 0; i < ps.size(); i++) {
                System.out.println(partitions.get(i).getPartitionName() + "\t\t " + "(" + partitions.get(i).getPartitionSize() + "KB)" + "\t\t " + partitions.get(i).getState());
            }
            partitionExc.processNotAdded();

        } else if (selection == 3) {
            ps = partitionExc.worstFit(processes, partitions,partitions.size());
            for (int i = 0; i < ps.size(); i++) {
                System.out.println(partitions.get(i).getPartitionName() + "\t\t " + "(" + partitions.get(i).getPartitionSize() + "KB)" + "\t\t " + partitions.get(i).getState());
            }
            partitionExc.processNotAdded();
        }
        System.out.print("Do you want to compact ? 2 NO . 1 YES :");
        int selection2 = input.nextInt();
        if (selection2 == 1) {
            compactPs = partitionExc.compact(partitions, selection);
            for (int i = 0; i < compactPs.size(); i++) {
                System.out.println(compactPs.get(i).getPartitionName() + "\t\t " + "(" + compactPs.get(i).getPartitionSize() + "KB)" + "\t\t " + compactPs.get(i).getState());
            }
        }

    }

}

