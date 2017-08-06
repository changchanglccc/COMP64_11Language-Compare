import java.util.*;

public class Symptom_check {
    static Set<Integer> influenza = new HashSet<Integer>();
    static Set<Integer> aids = new HashSet<Integer>();
    static Set<Integer>hepatitis_C= new HashSet<Integer>();
    static Set<Integer>pregnancy= new HashSet<Integer>();

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

        hepatitis_C.add(15);
        hepatitis_C.add(6);
        hepatitis_C.add(16);
        hepatitis_C.add(1);
        hepatitis_C.add(17);
        hepatitis_C.add(18);
        hepatitis_C.add(19);
        hepatitis_C.add(20);

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



    public static void main(String[] args){
        Symptom_check symptom_check=new Symptom_check();

        System.out.println("1.fever         |     2.chills           |      3.cough         |   4.sore throat         |       5.runny	       |     6.muscle aches\n7.headaches     |     8.fatigue"
                + "          |	    9.vomiting      |	10.diarrhea           | 	  11.rash	       |    12.night sweats\n13.mouth ulcers | 14.swollen lymphNodes  |      15.tired        |"
                + "	16.joint pain         |       17.nausea        |    18.stomach pain\n19.itchy skin   |      20.dark urine     |  21.food aversions   |   22.mood swings        |" +
                "  23.abdominal bloating |    24.frequent urination\n25.sore breasts |   26.light bleeding    |   27.missed period   |  28.high body temperature");
        System.out.print("\n");
        System.out.println("======================================= Input (end with 0) =====================================");
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
        getIndexOfInfluenza(input);
        getIndexOfAIDS(input);
        getIndexOfHepatitis_C(input);
        getIndexOfPregnancy(input);
        ArrayList<String> results=diagnose(indexs_map);
        System.out.println("YOU MAY HAVE :");
        for(int i=0;i<results.size();i++){
            System.out.println(results.get(i));
        }

    }

    static HashMap<String,Integer> indexs_map = new HashMap<String,Integer>();

    public static void getIndexOfInfluenza(ArrayList<Integer> symptoms){
       int index=0;
       for(int i=0;i<symptoms.size();i++){
           if(influenza.contains(symptoms.get(i))){
               index+=3;
           }else{
               index-=1;
           }
       }

       indexs_map.put("influenza",index);
    }

    public static void getIndexOfAIDS(ArrayList<Integer> symptoms){
        int index=0;
        for(int i=0;i<symptoms.size();i++){
            if(aids.contains(symptoms.get(i))){
                index+=3;
            }else{
                index-=1;
            }
        }

        indexs_map.put("aids",index);
    }

    public static void getIndexOfHepatitis_C(ArrayList<Integer> symptoms){
        int index=0;
        for(int i=0;i<symptoms.size();i++){
            if(hepatitis_C.contains(symptoms.get(i))){
                index+=3;
            }else{
                index-=1;
            }
        }

        indexs_map.put("hepatitis_C",index);
    }

    public static void getIndexOfPregnancy(ArrayList<Integer> symptoms){
        int index=0;
        for(int i=0;i<symptoms.size();i++){
            if(pregnancy.contains(symptoms.get(i))){
                index+=3;
            }else{
                index-=1;
            }
        }

        indexs_map.put("pregnancy",index);
    }

    public static ArrayList<String> diagnose(HashMap<String,Integer> index_table){
        ArrayList<String> mostPossibleList= new ArrayList<String>();    //some diseases have the same biggest index
        Object[] index_values=index_table.values().toArray();
        int largest=(int)index_values[0];
        //get biggest index
        for(int i=1;i<index_values.length;i++){
            if((int)index_values[i]>largest)
                largest=(int)index_values[i];
        }
        //get related disease name
        String[] disease_names={"influenza","aids","hepatitis_C","pregnancy"};
        for(int i=0;i<index_table.size();i++){
            if(index_table.get(disease_names[i])==largest){
                mostPossibleList.add(disease_names[i]);
            }
        }

        return mostPossibleList;
    }

}
