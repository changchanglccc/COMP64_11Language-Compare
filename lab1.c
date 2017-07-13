# include <stdio.h>
# include <stdlib.h>

//Bubble Sort for 10 numbers
int main()
{
	int nums[10]; //= {3,2,6,5,7,1,8,9,0,4};
	int i ;
	printf("========Bubble Sort===========\n");
	printf("--Please enter 10 integer numbers --\n");

	for(int i =0; i <10; i++)
	{
		printf("-- The number you type in is :\n");
		scanf("%d",&nums[i]);
		if(i == 10 - 1)
		{
			printf("--Typing end ...\n");
		}
	}
	
	printf("******Start bubble sort******\n");

	//Bubble sort
	int temp = 0;
	for(int i = 0; i < 10; i ++)
	{
		for(int j = i + 1; j < 10; j ++)
		{
			if(nums[i] > nums[j])
			{
				temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
			}
		}	

		//print out for each round
		for(int x = 0; x <10; x ++)
		{
			printf("%d ,",nums[x]);
		}
		printf("\n");
	}

}
