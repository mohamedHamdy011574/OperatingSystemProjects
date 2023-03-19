import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class AG {
	public Vector<Integer> readyQueue = new Vector<Integer>();
	int currentlyProcessing=0;
	Vector<Integer> table = new Vector<Integer>();
	Vector<Integer> timeTable = new Vector<Integer>();
	Map<Integer, Integer> comp_time = new HashMap<Integer, Integer>();
	int bursttime[], arrivaltime[], priority[], quantum[], n, remainingQuantum[];
	int exc_t[],arr[];
	int t=0;
	
	Map<Integer, ArrayList<Integer>> histroy = new HashMap<Integer, ArrayList<Integer>>();
	
	
	AG (int burst[], int arrivaltime[], int priority[], int quantum[], int remainingQuantum[], int n ,int ex[])
	{  
		this.bursttime=burst;
		this.arrivaltime=arrivaltime;
		this.arr=arrivaltime;
		this.priority=priority;
		this.quantum=quantum;
		this.remainingQuantum=remainingQuantum;
		this.n=n;

		
		
		for(int i=1;i<quantum.length;i++) {
			ArrayList<Integer> processHistory = new ArrayList<Integer>();
			processHistory.add(quantum[i]);
			
			histroy.put(i, processHistory);
			
		}
		

		
		this.exc_t=ex;
		timeTable.add(t);

	}
	
	int waitingTime[]= new int [n+1], turnarountime[]= new int [n+1],avgwaiting[]= new int [n+1],avgturnaround[]= new int [n+1];
	
	int i=1;


	

	void FCFS (int p)
	{

		
		double q= remainingQuantum[p]*0.25;
		q=Math.ceil(q);		
		remainingQuantum[p]=(int) (remainingQuantum[p]-q);
		
		for (Map.Entry<Integer, ArrayList<Integer>> entry : histroy.entrySet()) {
			
			if(p == entry.getKey()) {
				entry.getValue().add(remainingQuantum[p]);
			}

		}

		//bursttime[currentlyProcessing]-=q;
		
		if(bursttime[p]<q)
		{
			q-=(q-bursttime[p]);
		}
		bursttime[p]-=q;
		
		//if(bursttime[currentlyProcessing]<=0)
		if(bursttime[p]<=0)
		{
			quantum[p]=0;
		//	history
			remainingQuantum[p]=0;
			
			for (Map.Entry<Integer, ArrayList<Integer>> entry : histroy.entrySet()) {
				
				if(p == entry.getKey()) {
					entry.getValue().add(remainingQuantum[p]);
				}

			}
			currentlyProcessing=0;
		}
		//System.out.print("FCFS DONE   ");
		t+=(int)q;
		table.add(p);
		timeTable.add(t);
		comp_time.put(p,t);
		if(i<=n&&arrivaltime[i]<=t)
		{
			readyQueue.add(i);
			i++;
		}
	}
	
	boolean NPP(int p)
	{
		boolean flag=false;

		int less = currentlyProcessing;

		for(int i=0; i<readyQueue.size(); i++)
		{

			if(priority[currentlyProcessing]>priority[readyQueue.get(i)])
			{
				flag=true;
				if(priority[readyQueue.get(i)]<priority[less])
					less=readyQueue.get(i);
			}
		}
		if(flag==false)
		{
//			double q= Math.ceil(remainingQuantum[p]*0.50)-(int) Math.ceil(remainingQuantum[p]*0.25);
			double q=Math.ceil(remainingQuantum[p]*0.25);

			remainingQuantum[p]-=q;
			
			for (Map.Entry<Integer, ArrayList<Integer>> entry : histroy.entrySet()) {
				
				if(p == entry.getKey()) {
					entry.getValue().add(remainingQuantum[p]);
				}

			}

			//bursttime[currentlyProcessing]-=q;
			if(bursttime[currentlyProcessing]<q)
			{
				q-=(q-bursttime[currentlyProcessing]);
			}
			bursttime[currentlyProcessing]-=q;

			if(bursttime[currentlyProcessing]<=0)
			{
				quantum[currentlyProcessing]=0;
				remainingQuantum[currentlyProcessing]=0;
				
				for (Map.Entry<Integer, ArrayList<Integer>> entry : histroy.entrySet()) {
					
					if(p == entry.getKey()) {
						entry.getValue().add(remainingQuantum[currentlyProcessing]);
					}

				}
				
				currentlyProcessing=0;
			}
			t+=(int)q;
			table.add(p);
			timeTable.add(t);
			comp_time.put(p,t);
			if(i<=n&&arrivaltime[i]<=t)
			{
				readyQueue.add(i);
				i++;
			}
			
		}
		else
		{
			readyQueue.add(currentlyProcessing);

			remainingQuantum[currentlyProcessing]=quantum[currentlyProcessing]+(int) Math.ceil(remainingQuantum[currentlyProcessing]/2);
     		quantum[currentlyProcessing]=remainingQuantum[currentlyProcessing];
			
			for (Map.Entry<Integer, ArrayList<Integer>> entry : histroy.entrySet()) {
				
				if(p == entry.getKey()) {
					entry.getValue().add(remainingQuantum[currentlyProcessing]);
				}

			}
     		
     		for(int j=0; j<readyQueue.size(); j++)
			{
				if(readyQueue.get(j)==less)
					readyQueue.remove(j);
				
			}
			currentlyProcessing=less;
			
		}
		//System.out.print("NPP DONE   ");
		return flag;
	}
	
	boolean SJF(int p)
	{
		boolean flag=false;
		
		int less = currentlyProcessing;
		
		for(int i=0; i<readyQueue.size(); i++)
		{
			if(bursttime[currentlyProcessing]>bursttime[readyQueue.get(i)])
			{
				flag=true;
				if(bursttime[readyQueue.get(i)]<bursttime[less])
					less=readyQueue.get(i);
			}
		}
		
		if(flag==false)
		{
			//bursttime[currentlyProcessing]-=remainingQuantum[currentlyProcessing];
			if(bursttime[p]<remainingQuantum[currentlyProcessing])
			{
				remainingQuantum[currentlyProcessing]-=(remainingQuantum[currentlyProcessing]-bursttime[currentlyProcessing]);
				
				for (Map.Entry<Integer, ArrayList<Integer>> entry : histroy.entrySet()) {
					
					if(p == entry.getKey()) {
						entry.getValue().add(remainingQuantum[currentlyProcessing]);
					}

				}
			}
			bursttime[p]-=remainingQuantum[currentlyProcessing];
			
			table.add(p);
			t+=remainingQuantum[currentlyProcessing];
			timeTable.add(t);
			comp_time.put(p,t);
			if(i<=n&&arrivaltime[i]<=t)
			{
				readyQueue.add(i);
				i++;
			}
			if(bursttime[currentlyProcessing]<=0)
			{
				quantum[currentlyProcessing]=0;
				remainingQuantum[currentlyProcessing]=0;
				
				for (Map.Entry<Integer, ArrayList<Integer>> entry : histroy.entrySet()) {
					
					if(p == entry.getKey()) {
						entry.getValue().add(remainingQuantum[currentlyProcessing]);
					}

				}
			}
			if(bursttime[currentlyProcessing]!=0 && remainingQuantum[currentlyProcessing]==0)
			{
				readyQueue.add(currentlyProcessing);
				remainingQuantum[currentlyProcessing]=remainingQuantum[currentlyProcessing]*2;
				
				for (Map.Entry<Integer, ArrayList<Integer>> entry : histroy.entrySet()) {
					
					if(p == entry.getKey()) {
						entry.getValue().add(remainingQuantum[currentlyProcessing]);
					}

				}
			}
			currentlyProcessing=0;
		}
		else
		{
			readyQueue.add(currentlyProcessing);
			remainingQuantum[currentlyProcessing]=quantum[currentlyProcessing]+remainingQuantum[currentlyProcessing];
			quantum[currentlyProcessing]=remainingQuantum[currentlyProcessing];

			for (Map.Entry<Integer, ArrayList<Integer>> entry : histroy.entrySet()) {
				
				if(p == entry.getKey()) {
					entry.getValue().add(remainingQuantum[currentlyProcessing]);
				}

			}
			
			for(int j=0; j<readyQueue.size(); j++)
			{		
				if(readyQueue.get(j)==less)
					readyQueue.remove(j);
			}
			currentlyProcessing=less;
		}
		//System.out.print("SJF DONE   ");
		return flag;
	}
	public void schedule()
	{
		
		while(readyQueue.size()!=0 || i==1)
		{	
			boolean check = false;
			if(i<=n&&arrivaltime[i]<=t)
			{
				for (int o=0; o<readyQueue.size(); o++)
				{
					if(readyQueue.get(o)==i)
					{
						check=true;
						break;
					}
				}
			}
			if(i<=n&&check==false&&arrivaltime[i]<=t)
			{
				readyQueue.add(i);
				i++;
			}

			if(currentlyProcessing==0)
			{
				currentlyProcessing=readyQueue.get(0);
				readyQueue.remove(0);

			}
			

			FCFS(currentlyProcessing);
			if(currentlyProcessing==0)
			{
				continue;
			}
			
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 		
			
			// second 25% Non preemptive priority
			if(NPP(currentlyProcessing) ||currentlyProcessing==0 )
			{
				continue;
			}
			
			//currentlyProcessing=readyQueue.get(0);
	
			
// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 	
			
			// rest of the quantum time
			SJF(currentlyProcessing);
		}
		print();
		
	}
	
	public void print()
	{	
		
		/*for (int k=0; k<table.size(); k++)
		{
			System.out.print(table.get(k));
			System.out.print("  ");
		}*/
		
		for (int k=0; k<timeTable.size(); k++)
		{
			if(k<table.size())
			{
				System.out.print("P"+ table.get(k)+ "-->");
			}
						
		}
		System.out.println();
		int avg_wait=0; int avg_turnaround=0;
		
		for (int k=1; k<=n; k++)
		{//waitingTime[]= new int [n+1], turnarountime[]=
			int wait=comp_time.get(k)-exc_t[k]- arr[k];
			int turn=comp_time.get(k)- arr[k];
			System.out.print("waiting time P"+k+" = "+wait);
			avg_wait+=wait;
			System.out.println("  turnaround time P"+k+" = "+turn);
			avg_turnaround+=turn;
		//	System.out.println("waiting time P"+table.get(k)+" = "+comp_time.get(k));
			//System.out.print("  ");
		}
		//Vector<Integer> ordered = new Vector<Integer>();
		avg_wait/=n;
		avg_turnaround/=n;
		System.out.println("Average waiting time = "+avg_wait);
		System.out.println("Average Turnaround time = "+avg_turnaround);
		
		System.out.println("");
		System.out.println("History of the Quantum: ");
		for (Map.Entry<Integer, ArrayList<Integer>> entry : histroy.entrySet()) {
			
			System.out.print("p"+entry.getKey()+"  ");
			System.out.print(entry.getValue());
			System.out.println("");
		}
	}		
}

