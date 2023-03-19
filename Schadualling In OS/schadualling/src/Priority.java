import java.util.ArrayList;

public class Priority {

    private ArrayList<Process> processes;
    private ArrayList<Process>queue;
    private int a; //for arrival event
    private int d; //for departure event
    private int clock;//advance at event
    private Process working; //process in cpu



    public Priority(ArrayList<Process>processes){
        this.processes = processes;

        a  = processes.get(0).getArrival_time();
        d  = processes.get(0).getBurst_time();

        queue  = new ArrayList<Process>();
        clock = a;
        working = null;

        simulation();

    }



    private void arrival(Process arrived){

        //cpu is idle
        if(working == null){
            working = arrived; // cpu is working now
            System.out.print(working.getName()+"---->");
            working.setEnterTime(clock);
            working.setWaiting(clock - working.getTime_executed()-working.getArrival_time());
            d = clock + working.getBurst_time();  //expected departure
        }

        //cpu is working
        else{

            //determine which process should be in queue
            int time_remained = working.getBurst_time() - (clock - working.getEnterTime()); // time remained by working process in cpu

            // System.out.println("time remained");
            //System.out.println(working.getName()+" : "+time_remained);
            //if priority of arrived is less than priority of running process
            if(working.getPriority() > arrived.getPriority()){

                working.setTime_executed(working.getBurst_time() - time_remained);
                working.setBurst_time(time_remained); // new burst time
                queue.add(working); // add process to queue
                
                working = arrived; // add new process to cpu
                
                System.out.print(working.getName()+"---->");
                
                working.setEnterTime(clock);
                working.setWaiting(clock - working.getTime_executed()-working.getArrival_time());

                //System.out.println(working.getName()+" : "+working.getBurst_time());

                d = clock + working.getBurst_time(); // new departure time

            }else{
                queue.add(arrived); // add arrived to queue
            }
        }


    }
    //return minimum priority
    private Process min(){
        int minimum = 10000000;
        Process newP = null;
        for(Process p : queue){
            if(p.getPriority() < minimum) {

                minimum = p.getPriority();
                newP = p;
            }
        }
        return newP;
    }
    private void departure(){
        working.setTurnaroundTime(clock - working.getArrival_time()); //calculate turnaround time

        //no processes in queue
        if(queue.isEmpty()){

            working = null;
            d = -1;

        }
        else {

            working = min(); //return minimum priority in queue
            System.out.print(working.getName()+"---->");
            working.setEnterTime(clock);
            working.setWaiting(clock - working.getTime_executed()-working.getArrival_time());
            queue.remove(working);

            d = clock + working.getBurst_time();

        }
    }
    private void simulation(){

        int arrivalCounter = 0;      
        String name = null;
        System.out.println("order");
        while(true){


            if(clock == d){
                departure();
            }
            else {

                arrival(processes.get(arrivalCounter));
                // new arrival event will happen

                if(arrivalCounter+1 == processes.size()){
                    a = -1;
                }

                else
                    a = processes.get(++arrivalCounter).getArrival_time();

            }


            if(a==-1){
                clock = d;
            }
            else if(d == -1){
                clock = a;
            }
            else if(a<=d){
                clock = a;
            }
            else {
                clock = d;
            }

            if(a == -1 && d == -1)
                break;

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
