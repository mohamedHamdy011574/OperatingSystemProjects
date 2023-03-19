import java.util.ArrayList;


/**
 * Shortest job first (pr-emptive)
 */
public class SJF {

    private ArrayList<Process>processes;
    private ArrayList<Process>queue;
    private int a; //for arrival event
    private int d; //for departure event
    private int clock;//advance at event
    private Process working; //process in cpu

    public SJF(ArrayList<Process>processes){
        this.processes = processes;

        a  = processes.get(0).getArrival_time();  //  0
        d = processes.get(0).getBurst_time();    ///    7

        queue  = new ArrayList<Process>();
        clock = a;   						//    	0
        working = null;

        simulation();

    }



    private void arrival(Process arrived){ // p1 arr=0 Brust=7 

        //cpu is idle

        if(working == null){
            working = arrived; // cpu is working now  p1
            System.out.print(working.getName()+"---->");  //  p1
            working.setEnterTime(clock);                   // 0
            working.setWaiting(clock - working.getTime_executed()-working.getArrival_time()); //  0
            d = clock + working.getBurst_time();  //expected departure           // 0+7
        }

        //cpu is working
        else{

            //determine which process should be in queue
            int time_remained = working.getBurst_time() - (clock - working.getEnterTime()); // time remained by working process in cpu
                                  // 7 - 2 -0 =5  ||4-(4-2)=2  || 1-(5-4)=0
           
            //if arrive burst time is less than time remained for running process
            if(time_remained > arrived.getBurst_time()){ // 5 >4 || 2>=1 ||

               working.setTime_executed(working.getBurst_time() - time_remained);//2 || 2
                working.setBurst_time(time_remained); // new burst time // 5 || 2
                queue.add(working);  // p1 || p2
               
                working = arrived;    //   p2 || p3
                
                System.out.print(working.getName()+"---->");  // p2 || p3
                working.setEnterTime(clock);  // 2 || 4
                working.setWaiting(clock - working.getTime_executed()-working.getArrival_time()); // 2-0-2=0 || 0
                d = clock + arrived.getBurst_time(); //  2 + 4 = 6 || 4+1=5

            }else{
                queue.add(arrived); // add arrived to queue // p3
            }
        }


    }

    private Process min(){
        int minimum = 10000000;
        Process newP = null;
        for(Process p : queue){
            if(p.getBurst_time() < minimum) {
                newP = p;
                minimum = p.getBurst_time();
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

            working = min(); //return minimum burst time in queue  p1=5||p2=2||p4=4
            System.out.print(working.getName()+"---->"); // p2
            working.setEnterTime(clock);       // 5
            working.setWaiting(clock - working.getTime_executed()-working.getArrival_time());//5-2-2=1
            queue.remove(working); //  p2

            d = clock + working.getBurst_time(); // 5+2=7

        }


    }


    private void simulation(){

        int arrivalCounter = 0;

        String name = null;
        System.out.println("order");
        while(true){



            if(clock == d){   // 0 == 7 ||  2==7 || 4==7 || 5==5 || 5==7
                departure();
            }
            else {

                arrival(processes.get(arrivalCounter)); // 0 || 1 || 2
                // new arrival event will happen

                if(arrivalCounter+1 == processes.size()){ // 1==4 || 2 == 4 || 3==4 ||3==4
                    a = -1;
                }

                else
                	a = (processes.get(++arrivalCounter).getArrival_time());   

            }


            if(a==-1){
                clock = d;
            }
            else if(d == -1){
                clock = a;
            }
            else if(a<=d){    // 2<7 || 4 < 6 || 5<=5 || 5<7
                clock = a;   /// 2   || 4     || 5    || 5
            }
            else {
                clock = d;
            }

            if(a == -1 && d == -1)
                break;

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
