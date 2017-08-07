package test;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;
//import org.apache.log4j.Logger;

public aspect Logger {
//	private File loggingFile = new File("Log.txt");
	private File loggingFile = new File("/Users/chongli/Github/6411Lab2-testAspectJ/src/Log.txt");
//	Log log = new Log();
//	private static final Logger logger = Logger.getLogger(AutoTrace.class);
	String file = "";
	
	pointcut diagnose(): call(ArrayList<String> diagnose(HashMap<String,Integer>));
	pointcut collectDiagnoseInfo():call(void getScoreOfInfluenza(ArrayList<Integer>))
	||call(void getScoreOfAIDS(ArrayList<Integer>))
	||call(void getScoreOfHepatitis_C(ArrayList<Integer>))
	||call(void getScoreOfPregnancy(ArrayList<Integer>));
	
	before():diagnose(){
		System.out.println("> Before call: " + thisJoinPoint);
		String log = "> Before call: " + thisJoinPoint + new Date().toString();
		writeLog(log,loggingFile);
	}
	after():diagnose(){
		System.out.println("> After call: " + thisJoinPoint);
		String log = "> After call: " + thisJoinPoint + new Date().toString();
		writeLog(log,loggingFile);
	}
	
	before():collectDiagnoseInfo(){
		System.out.println("> before collecting diagnpse information: " + thisJoinPoint);
		String log = "> before collecting diagnpse information: " + thisJoinPoint + new Date().toString();
		writeLog(log,loggingFile);
	}
	
	before(): execution(ArrayList<String> diagnose(HashMap<String,Integer>)){
		System.out.println("> Before executed: " + thisJoinPoint);
		String log = "> Before executed: " + thisJoinPoint + new Date().toString();
		writeLog(log,loggingFile);
	}
	after(): execution(ArrayList<String> diagnose(HashMap<String,Integer>)){
		System.out.println("> After executed: " + thisJoinPoint);
		String log = "> After executed: " + thisJoinPoint + new Date().toString();
		writeLog(log,loggingFile);
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
