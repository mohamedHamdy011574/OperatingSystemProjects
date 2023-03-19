import java.util.*;

public class exec {

    static ArrayList<Process>processes = new ArrayList<Process>(); //for sjf
    static ArrayList<Process>processes2 = new ArrayList<Process>(); //for priority
    static ArrayList<Process>processes3 = new ArrayList<Process>();//round robin

    
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("# of processes");
        int n = sc.nextInt();
        
    	int[] bursttime = new int[n+1];
    	int[] arrivaltime = new int[n+1];
    	int[] Priority = new int[n+1];
    	int[] quantum = new int[n+1];
    	int[] remainingQuantum = new int[n+1];
    	int[] ex = new int[n+1];
    	
        for(int i =0;i<n;i++){
            System.out.print("process name : ");
            String name = sc.next();
            System.out.print("Burst time : ");
            int burst = sc.nextInt();
            System.out.print("arrival time : ");
            int arrival = sc.nextInt();
            System.out.print("priority : ");
            int priority = sc.nextInt();
            System.out.print("AG Quantum : ");
            int Quantum = sc.nextInt();
            
            processes.add(new Process(name,burst,arrival));
            processes2.add(new Process(name,burst,arrival,priority));
            processes3.add(new Process(name,burst,arrival));
            

            bursttime[i+1] = burst; 
            ex[i+1] = burst;
        	arrivaltime[i+1] = arrival;
        	Priority[i+1] = priority;
        	quantum[i+1] = Quantum; 
            remainingQuantum[i+1]= Quantum;



        }


        System.out.print("Round robin Time Quantum : ");
        int quntaum = sc.nextInt();


        processes.sort(Comparator.comparing(Process::getArrival_time));
        processes2.sort(Comparator.comparing(Process::getArrival_time));
        processes3.sort(Comparator.comparing(Process::getArrival_time));


        System.out.println();
        System.out.println();
        System.out.println("shortest job first: ");
         SJF sim = new SJF(processes);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("priority: ");
        Priority priority = new Priority(processes2);


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("round robin: ");
        RoundRobin RR = new RoundRobin(processes3,quntaum);
        
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("AG: ");
        AG ag = new AG(	bursttime, arrivaltime, Priority, quantum,remainingQuantum, n ,ex);
        ag.schedule();
    }



}
