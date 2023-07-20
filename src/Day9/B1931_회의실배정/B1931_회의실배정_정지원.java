package Day9.B1931_회의실배정;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B1931_회의실배정_정지원 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int count = 0;
		ArrayList<Time> times = new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			times.add(new Time(sc.nextInt(), sc.nextInt()));
		}
		
		Collections.sort(times, (t1, t2)-> (t1.end==t2.end ? (t1.start>t2.start ? 1 : -1) : (t1.end > t2.end)? 1 : -1));
		
		long endTime = 0;
		for(int i=0;i<n;i++) {
			if(endTime>times.get(i).start) {
				continue;
			}
			else {
				
				count++;
				endTime = times.get(i).end;
			}
		}
		
		
		System.out.println(count);
	}
}

class Time{
	Time(int s, int e){
		start = s;
		end = e;
	}
	long start;
	long end;
}