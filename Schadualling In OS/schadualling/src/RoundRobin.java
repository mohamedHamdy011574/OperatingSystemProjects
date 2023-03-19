import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class RoundRobin {

    private ArrayList<Process> processes;
    private Queue<Process>queue;
    private int a; //arrival time
    private int d;//context switching
    private int clock;
    private Process working;


    private int quantum;
    int cQ;

    public RoundRobin(ArrayList<Process>processes,int cQ){

        this.processes = processes;
        this.cQ = cQ;

        quantum = cQ;

        queue = new LinkedList<Process>();
        a = processes.get(0).getArrival_time();
        d = processes.get(0).getBurst_time();
        clock = a;

        sim();

    }


    private void contxtSwitch(){



            int time_remained = working.getBurst_time() - (clock - working.getEnterTime()); // time remained by working process in cpu


            working.setTime_executed((working.getBurst_time() - time_remained) + working.getTime_executed());

            working.setBurst_time(time_remained); // new burst time


            queue.add(working);
            working = queue.poll();
            working.setEnterTime(clock);
            
            System.out.print(working.getName()+"-->");
            
            d = clock + working.getBurst_time();
            quantum += cQ;



    }

    private void arrival(Process arrived){

       //no process in cpu
        if(working == null){
            working = arrived;
            working.setEnterTime(clock);
            System.out.print(working.getName()+"-->");

            d = clock+working.getBurst_time();


        }
        else {


            queue.add(arrived);


        }


    }




    private void departure(){

        working.setTurnaroundTime(clock - working.getArrival_time());
        working.setWaiting(working.getTurnaroundTime()-(working.getBurst_time()+working.getTime_executed()));

        if(!queue.isEmpty()) {
            working = queue.poll();
            working.setEnterTime(clock);
            System.out.print(working.getName()+"-->");

            d = clock+working.getBurst_time();
            quantum = clock+cQ;
        }
        else d = -1;




    }

    private void sim(){


        int arrivalCounter = 0;

        System.out.println("order");
        while (true){




            //System.out.println(a+" : "+d+" : "+quantum);

            if(clock == a){

                arrival(processes.get(arrivalCounter));
                arrivalCounter++;
                if(arrivalCounter == processes.size())
                    a =-1;
                else  a = processes.get(arrivalCounter).getArrival_time();

            }
            else if(clock == d) {

                departure();

            }
            if(clock == quantum) {
                contxtSwitch();
            }


            if(a == -1 && d == -1)
                break;

            if((a<d || d == -1)&&(a<quantum) && (a !=-1))
                clock = a;
            else if((d<a || a==-1)&&(d<quantum) && (d!=-1)) {
                clock = d;

            }
            else {


                clock = quantum;

            }





            //System.out.print(working.getName()+"---->");


        }



        System.out.println();


        print();


    }

    private void print(){
        double totalW = 0; // total weight
        double totalT = 0; // total turnaround time
        for(Process p : processes){
            p.print();
            totalT += p.getTurnaroundTime();
            totalW += p.getWaiting();
        }


        System.out.println("average waiting : " + totalW/processes.size());
        System.out.println("average turnaround time : " + totalT/processes.size());

    }
}
