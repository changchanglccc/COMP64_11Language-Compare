# include <stdio.h>
# include <stdlib.h>

//Bubble Sort for 10 numbers
int main()
{
	int nums[10]; //= {3,2,6,5,7,1,8,9,0,4};
	int temp;
	printf("========Bubble Sort===========\n");
	printf("--Please enter 10 integer numbers --\n");

	for(int i =0; i <10; i++)
	{
		printf("-- Please enter the %dth value:\n",(1+i));
		scanf("%d",&nums[i]);
	}
	printf("\nTyping End");
	
	printf("******Start bubble sort******\n");

	//Bubble sort
	
	for(int i = 0; i < 10-1; i ++)
	{
		for(int j = 0; j < 10-i-1; j ++)
		{
			if(nums[j] > nums[j+1])
			{
				temp = nums[j];
				nums[j] = nums[j+1];
				nums[j+1] = temp;
			}
		}	

		printf("\nSorted List:\n");
		//print out for each round
		for(int x = 0; x <10; x ++)
		{
			printf("%d ",nums[x]);
		}
		printf("\n");
	}

}
