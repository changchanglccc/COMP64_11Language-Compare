#include <stdio.h>
#include <string.h>
typedef struct Disease_Database{
	char* disease;
	char symptoms[5][15];
	int no;
}Disease_Database;

int main()
{
	Disease_Database diseases[4];
	char list_of_symptoms[18][20]={"Fever","Cough","Sore throat","Headaches","tiredness","Muscle aches","Chills","Rash","Joint pain","Stomach pain","Nausea","Dark urine","Itchy skin","Mood swings","Food aversions","Sore breasts","Abdominal bloating","A missed period"};
	char user_input[14][20];
	char choice;
	int i,j,k,c,count,symptoms_no;
	//interface
	//Database initialization
	diseases[0].disease="Influenza";
	strcpy(diseases[0].symptoms[0],"Fever");
	strcpy(diseases[0].symptoms[1],"Cough");
	strcpy(diseases[0].symptoms[2],"Sore throat");
	strcpy(diseases[0].symptoms[3],"Headaches");
	strcpy(diseases[0].symptoms[4],"tiredness");
	diseases[0].no=0;
	diseases[1].disease="AIDS";
	strcpy(diseases[1].symptoms[0],"Muscle aches");
	strcpy(diseases[1].symptoms[1],"Chills");
	strcpy(diseases[1].symptoms[2],"Rash");
	strcpy(diseases[1].symptoms[3],"tiredness");
	strcpy(diseases[1].symptoms[4],"Sore throat");
	diseases[1].no=0;
	diseases[2].disease="Hepatitis C";
	strcpy(diseases[2].symptoms[0],"Joint pain");
	strcpy(diseases[2].symptoms[1],"Stomach pain");
	strcpy(diseases[2].symptoms[2],"Nausea");
	strcpy(diseases[2].symptoms[3],"Dark urine");
	strcpy(diseases[2].symptoms[4],"Itchy skin");
	diseases[2].no=0;
	diseases[3].disease="Pregnancy";
	strcpy(diseases[3].symptoms[0],"Mood swings");
	strcpy(diseases[3].symptoms[1],"Food aversions");
	strcpy(diseases[3].symptoms[2],"Abdominal bloating");
	strcpy(diseases[3].symptoms[3],"Sore breasts");
	strcpy(diseases[3].symptoms[4],"A missed period");
	diseases[3].no=0;
	printf("\n No of symtoms you want to enter:");
	scanf("%d",&symptoms_no);

	printf("List of symptoms.\n");
	for(i=0;i<18;i++){
			printf("\n%d.)%s",(i+1),list_of_symptoms[i]);
	}
	choice='y';
	count=0;
	printf("\n");
	do{
		printf("Enter your symptoms no.");
		scanf("%d",&c);
		if(c>14){
		   printf("\n Please enter no from the list.");
		   continue;
		}
		strcpy(user_input[count],list_of_symptoms[(c-1)]);
		count++;
	}while(count<symptoms_no);
	printf("\n Your Selection.");
	for(i=0;i<count;i++){
			printf("\n%d.)%s",i,user_input[i]);
	}
	//
	int counter=0;
	for(i=0; i < count; i++){//problem
		for(j=0; j <4; j++){
			for(k=0; k <5;k++){
				if(strcmp(user_input[i],diseases[j].symptoms[k])==0){
					diseases[j].no++;	
					break;
				}
				counter++;
			}

		}
	}
	printf("\nNo of times Counter run: %d",counter);
	printf("\nChances of the folling disease :");
	for(i=0;i<4;i++){
		printf("\n%s = %d%c",diseases[i].disease,(diseases[i].no*20),37);
	}
	return 0;
}
