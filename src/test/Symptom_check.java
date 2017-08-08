package test;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Symptom_check {
     Set<Integer> influenza = new HashSet<Integer>();
     Set<Integer> aids = new HashSet<Integer>();
     Set<Integer>hepatitis_C= new HashSet<Integer>();
     Set<Integer>pregnancy= new HashSet<Integer>();
    
    public File loggingFile = new File("/Users/chongli/Github/6411Lab2-testAspectJ/src/Log.txt");
    
    public Symptom_check(){
        influenza.add(1);
        influenza.add(2);
        influenza.add(3);
        influenza.add(4);
        influenza.add(5);
        influenza.add(6);
        influenza.add(7);
        influenza.add(8);
        influenza.add(9);
        influenza.add(10);

        aids.add(1);
        aids.add(2);
        aids.add(11);
        aids.add(12);
        aids.add(6);
        aids.add(4);
        aids.add(8);
        aids.add(13);
        aids.add(14);
        aids.add(29);

        hepatitis_C.add(15);
        hepatitis_C.add(6);
        hepatitis_C.add(16);
        hepatitis_C.add(1);
        hepatitis_C.add(17);
        hepatitis_C.add(18);
        hepatitis_C.add(19);
        hepatitis_C.add(20);
        hepatitis_C.add(30);
        hepatitis_C.add(31);

        pregnancy.add(21);
        pregnancy.add(22);
        pregnancy.add(23);
        pregnancy.add(24);
        pregnancy.add(8);
        pregnancy.add(25);
        pregnancy.add(26);
        pregnancy.add(17);
        pregnancy.add(27);
        pregnancy.add(28);
    }

    static HashMap<String,Integer> indexs_map = new HashMap<String,Integer>();

    
    public static void main(String[] args){
        Symptom_check symptom_check=new Symptom_check();
        
        
        
        System.out.println("******************************  Welcome to our diagnose system ***********************************");
        System.out.println();
        System.out.println("	1.fever		|	2.chills	|	3.cough		|	4.sore throat	|	5.runny		|	6.muscle aches	\n	7.headaches	|	8.fatigue"
                + "	|	9.vomiting	|	10.diarrhea	|	11.rash		|	12.night sweats	\n	13.mouth ulcers	|	14.swollen lymphNodes	|	15.tired	|"
                + "	16.joint pain	|	17.nausea	|	18.stomach pain		\n	19.itchy skin	|	20.dark urine	|	21.food aversions	|	22.mood swings	|" +
                "	23.abdominal bloating	|	24.frequent urination\n	25.sore breasts	|	26.light bleeding	|	27.missed period	|	28.high body temperature"
                + "|	29.rapid weight loss	|	30.yellow eyes	|	31.weakness		|");
        System.out.print("\n");
        System.out.println("====================== Entry your symptoms, use ' ' to sperate (end with 0) (e.g.: 1 2 0) ===================================");
        int flag=0;
        ArrayList<Integer> input = new ArrayList<Integer>();
        Scanner scanner =new Scanner(System.in);
        do {
            flag=Integer.parseInt(scanner.next());
            if(flag!=0){
                input.add(flag);
            }
        }while (flag!=0);
        System.out.print("\n");
        System.out.println("=========================================== Result ==============================================");
        
        //diagnose checking
        symptom_check.getScoreOfInfluenza(input);
        symptom_check.getScoreOfAIDS(input);
        symptom_check.getScoreOfHepatitis_C(input);
        symptom_check.getScoreOfPregnancy(input);
        
        ArrayList<String> results = symptom_check.diagnose(indexs_map);
        System.out.println("YOU MAY HAVE :");
        for(int i=0;i<results.size();i++){
        	String log = "The result is: " + results.get(i);
        	symptom_check.writeLog(log,symptom_check.loggingFile);
            System.out.println(results.get(i));
        }
        

    }
    
    
    public  void getScoreOfInfluenza(ArrayList<Integer> symptoms){
       int score=0;
       for(int i=0;i<symptoms.size();i++){
           if(influenza.contains(symptoms.get(i))){
               score += 1;
           }
       }
//       System.err.println("getScoreOfInfluenza"+score);
       String log = "> getScoreOfInfluenza（） is counting: " + new Date().toString();
       writeLog(log,loggingFile);
       indexs_map.put("influenza",score);
    }

    
    public  void getScoreOfAIDS(ArrayList<Integer> symptoms){
        int score=0;
        for(int i=0;i<symptoms.size();i++){
            if(aids.contains(symptoms.get(i))){
            	score+=1;
            }
        }
//        System.err.println("getScoreOfAIDS"+score);
        String log = "> getScoreOfAIDS（） is counting: " + new Date().toString();
        writeLog(log,loggingFile);
        indexs_map.put("aids",score);
    }

    
    public  void getScoreOfHepatitis_C(ArrayList<Integer> symptoms){
        int score=0;
        for(int i=0;i<symptoms.size();i++){
            if(hepatitis_C.contains(symptoms.get(i))){
            	score+=1;
            }
        }
//        System.err.println("getScoreOfHepatitis_C"+score);
        String log = "> getScoreOfHepatitis_C（） is counting: " + new Date().toString();
        writeLog(log,loggingFile);
        indexs_map.put("hepatitis_C",score);
    }
    
    
    public  void getScoreOfPregnancy(ArrayList<Integer> symptoms){
        int score=0;
        for(int i=0;i<symptoms.size();i++){
            if(pregnancy.contains(symptoms.get(i))){
            	score+=1;
            }
        }
//        System.err.println("getScoreOfPregnancy"+score);
        String log = "> getScoreOfPregnancy（） is counting: " + new Date().toString();
        writeLog(log,loggingFile);
        indexs_map.put("pregnancy",score);
    }

    
    public  ArrayList<String> diagnose(HashMap<String,Integer> score_table){	// Calculate the weight and rate of each disease
    	ArrayList<String> diseaseRateList = new ArrayList<String>();
    	
    	int rate1 = (score_table.get("influenza")*100)/10; 
    	int rate2 =	(score_table.get("aids")*100)/10;
    	int rate3 =	(score_table.get("hepatitis_C")*100)/10;
    	int rate4 = (score_table.get("pregnancy")*100)/10;
     	
    	diseaseRateList.add("influenza	" + rate1 + "%");
    	diseaseRateList.add("aids		" + rate2 + "%");
    	diseaseRateList.add("hepatitis_C	" + rate3 + "%");
    	diseaseRateList.add("pregnancy	" + rate4 + "%");
    	
    	return diseaseRateList;
    }

    public void writeLog(String log,File file){
        if(!file.exists())
            return;
        try {
            synchronized (file) {
                FileWriter fileWriter = new FileWriter(file, true);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                bufferedWriter.write(log);
                bufferedWriter.newLine();
                bufferedWriter.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
