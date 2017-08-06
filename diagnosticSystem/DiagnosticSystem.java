package diagnosticSystem;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class DiagnosticSystem {
	
	static HashMap<String,String> hm = new HashMap<String, String>();
	static String[] input = null;
	static int flag = 0;
	/*
	 * disease be stored in a hashmap
	 */
	public static void initialization(){ 
		hm.put("Fever", "Influenza");
		hm.put("Cough", "Influenza");
		hm.put("Sore throat", "Influenza");
		hm.put("Headaches", "Influenza");
		hm.put("Tiredness", "Influenza");
		hm.put("Muscle aches", "AIDS");
		hm.put("Chills", "AIDS");
		hm.put("Rash", "AIDS");
		hm.put("Tiredness", "AIDS");
		hm.put("Sore throat", "AIDS");
		hm.put("Joint pain", "Hepatitis C");
		hm.put("Stomach pain", "Hepatitis C");
		hm.put("Nausea", "Hepatitis C");
		hm.put("Dark urine", "Hepatitis C");
		hm.put("Itchy skin", "Hepatitis C");
		hm.put("Mood swings", "Pregnancy");
		hm.put("Food aversions", "Pregnancy");
		hm.put("Abdominal bloating", "Pregnancy");
		hm.put("Sore breasts", "Pregnancy");
		hm.put("A missed period", "Pregnancy");
	}
	public static void main(String[] args){
		initialization();
		//UI
		while(flag == 0){
			System.out.println("========= Welcome to Diagnostic System ===========");
			System.out.println();
			System.out.println("1.Fever		2.Cough		3.Sore throat		4.Headaches		5.Tiredness		6.Muscla aches\n7.Chills	8.Rash"
					+ "		9.Joint pain		10.Stomach pain 	11.Nausea		12.Dark urine\n13.Itchy skin	14.Mood swings	15.Food aversions"
					+ "	16.Abdominal bloating	17.A missed period ");
			System.out.println();
			System.out.println("---- Input your symptoms, use ',' to seperate( For example: Fever,Cough) ----");
			System.out.println("Please enter: (use 0 to exit)");

			Scanner str = new Scanner(System.in);
			
			if(str.nextLine().equals("0") ){
				flag = 1;
				System.out.println("exit.");
			}else{
//				System.out.println(str.nextLine().toString());
				System.out.println("test");
				input = str.nextLine().toString().split(",");
				System.out.println(input);
				for(int i = 0; i < input.length; i ++){
					System.out.println(input[i]);
				}
				System.out.println("Disease rate: \n" + Diagnose(hm,input));
			}
		}
		
		
	}
	
	public static String Diagnose(HashMap<String,String> hm, String[] input){
		int[] count = {0, 0, 0, 0};
		String s = null;
		String result;
		for(int i = 0; i < input.length; i++){
			s = input[i].toString();
			if(hm.get(s).equals("Influenza")){
				count[0] = count[0] + 1;
			}else if(hm.get(s).equals("AIDS")){
				count[1] = count[1] + 1;
			}else if(hm.get(s).equals("Hepatitis C")){
				count[2] = count[2] + 1;
			}else if(hm.get(s).equals("Pregnancy")){
				count[3] = count[3] + 1;
			}
		}
		
		int total = count[0] + count[1] + count[2] + count[3];
		result = "Influenza: " + count[0]/total +" , AIDS: " 
				+ count[1]/total +" , Hepatitis C: " + count[2]/total + " , Pregnancy: " + count[3]/total ;
		return result;
	}
	
	 
}
