package egonet;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class testTotal {

	public void globaltest(String filename) {
	Set<Integer> seen = new HashSet<Integer>();
	Scanner sc;
	try {
		sc = new Scanner(new File(filename));
	} catch (Exception e) {
		e.printStackTrace();
		return;
	}
	while (sc.hasNextInt()) {
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		if (!seen.contains(v1)) {
			seen.add(v1);
		}
		if (!seen.contains(v2)) {
			seen.add(v2);
		}
	}
	System.out.println(seen.size() + "here");
	int hun = 0;
	int count = 0;
	for(int element : seen) {
		if(element % 100 == 0) {
			System.out.println(element + " " + hun + " " + count);
		}
		if(hun == 100) {
			count++;
			hun = 0;
		}
		hun++;
	}
	}
	
}