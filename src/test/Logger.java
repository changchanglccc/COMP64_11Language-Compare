package test;

import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.io.FileWriter;
import java.io.IOException;

public aspect Logger {
//	private File loggingFile = new File("/Users/chongli/Github/6411Lab2-testAspectJ/src/Log.txt");

	String file = "";
	
	pointcut accessors(Symptom_check c): call(ArrayList<String> diagnose(HashMap<String,Integer>))&& target(c);
	pointcut collectDiagnoseInfo(Symptom_check c):call(void getScoreOfInfluenza(ArrayList<Integer>))&& target(c)
	||call(void getScoreOfAIDS(ArrayList<Integer>))&& target(c)
	||call(void getScoreOfHepatitis_C(ArrayList<Integer>))&& target(c)
	||call(void getScoreOfPregnancy(ArrayList<Integer>))&& target(c);
	
	before(Symptom_check c): accessors(c) {
		System.out.println("> Before call: " + thisJoinPoint);
		String log = "> Before call: " + thisJoinPoint + new Date().toString();
		c.writeLog(log,c.loggingFile);
	}
	after(Symptom_check c): accessors(c){
		System.out.println("> After call: " + thisJoinPoint);
		String log = "> After call: " + thisJoinPoint + new Date().toString();
		c.writeLog(log,c.loggingFile);
	}
	
	before(Symptom_check c):collectDiagnoseInfo(c){
		System.out.println("> before collecting diagnose information: " + thisJoinPoint);
		String log = "> before collecting diagnose information: " + thisJoinPoint + new Date().toString();
		c.writeLog(log, c.loggingFile);
	}
	
	before(Symptom_check c):execution(ArrayList<String> diagnose(HashMap<String,Integer>)) && this(c){
		System.out.println("> Before executed: " + thisJoinPoint);
		String log = "> Before executed: " + thisJoinPoint + new Date().toString();
		c.writeLog(log,c.loggingFile);
	}
	after(Symptom_check c): execution(ArrayList<String> diagnose(HashMap<String,Integer>)) && this(c){
		System.out.println("> After executed: " + thisJoinPoint);
		String log = "> After executed: " + thisJoinPoint + new Date().toString();
		c.writeLog(log,c.loggingFile);
	}

}
