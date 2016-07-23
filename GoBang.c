#include <stdio.h>
#include <stdlib.h>
void showGo(int go[][15]);
typedef struct Hand{
	int x;
	int y;
} hand;
int play_sum[15][15] = {{0}}, ai_sum[15][15] = {{0}};
void showHand(hand * a);
hand a[8] = { {-1,0}, {-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1}};
int main()
{
	int go[15][15] = {{0}};
	int player_x=1, player_y=1;
	showHand(a);
	showGo(go);
	do{
		printf("----------------------------------------\n");
		scanf("%d%d", &player_x, &player_y);
		printf("----------------------------------------\n");
		go[player_x-1][player_y-1] = 1;
		showGo(go);
	}while(player_x<16&&player_y<16);
	//show(go);
	return 0;
}
void showGo(int go[][15])
{
	int i=0, j=0;

	for (i=0;i<15;i++)
	{
			for (j=0;j<15;j++)
			{
				printf("%d", go[i][j]);
				printf("\t");
			}
		printf("\n\n");
	}
}
void showHand(hand * a)
{
	int i = 0;
	for (i=0; i<8;i++)
	{
		printf("%d %d\t", a[i].x, a[i].y);
	}
	printf("\n");
}
