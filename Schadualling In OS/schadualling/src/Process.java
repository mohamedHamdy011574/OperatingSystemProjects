public class Process {

    private String name;
    private int burst_time;
    private int arrival_time;
    private int time_executed;
    private int waiting;
    
    ///from arrival to complete the process
    private int turnaroundTime;
    private int priority;
    private int enterTime;
    
    private int quantum;
    private int remaningQuantum;
    
    public int quareter = 0;

    public Process(String name,int burst_time,int arrival_time,int priority){
        this.name = name;
        this.burst_time = burst_time;
        this.arrival_time = arrival_time;
        this.priority = priority;
        
        this.time_executed = 0;
        this.waiting = 0;
        this.turnaroundTime = 0;
    }
    public Process(String name,int burst_time,int arrival_time){
        this.name = name;
        this.burst_time = burst_time;
        this.arrival_time = arrival_time;
        
        this.time_executed = 0;
        this.waiting = 0;
        this.turnaroundTime = 0;


    }
    
    public Process(String name,int burst_time,int arrival_time,int priority, int quantum){
        this.name = name;
        this.burst_time = burst_time;
        this.arrival_time = arrival_time;
        this.priority = priority;
        this.quantum = quantum;
        
        this.time_executed = 0;
        this.waiting = 0;
        this.turnaroundTime = 0;


    }


    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setTime_executed(int time_executed) {
        this.time_executed = time_executed;
    }

    public void setWaiting(int waiting) {
        this.waiting = waiting;
    }

    public int getArrival_time() {
        return arrival_time;
    }

    public int getWaiting() {
        return waiting;
    }

    public int getTime_executed() {
        return time_executed;
    }

    public void setEnterTime(int enterTime) {
        this.enterTime = enterTime;
    }

    public int getEnterTime() {
        return enterTime;
    }

    public int getBurst_time() {
        return burst_time;
    }

    public String getName() {
        return name;
    }

    public void setBurst_time(int burst_time) {
        this.burst_time = burst_time;
    }

    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }

    public int getTurnaroundTime() {
        return turnaroundTime;
    }
    
    public int getQuantumNumber() {
    	return quantum;
    }
    
    public void setQuantumNumber(int quantum) {
    	this.quantum = quantum;
    }
    
    public int getRemaningQuantumNumber() {
    	return remaningQuantum;
    }
    
    public void setRemaningQuantumNumber(int remaningQuantum) {
    	this.remaningQuantum = remaningQuantum;
    }
    
    public void print(){

        System.out.print("process name : "+name);
        System.out.print("   waiting time : "+waiting);
        System.out.println("   tarnaround time : "+turnaroundTime);

    }


}
