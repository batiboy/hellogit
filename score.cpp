#include <iostream>
#include <stdio.h>
#include <string>
#include <iomanip>
#include <algorithm>
#include <sstream>
using namespace std;

struct Student
{
	string name;
	string sex;
	double score;
}   stu[100];

bool comp(Student x, Student y)
{
	return x.score > y.score;
}

int main()
{

	freopen("score.csv", "r", stdin);

	int i = 0;
	string line;
	getline(cin, line);
	string name, gender, score;
	
	while (getline(cin, line))
	{
		stringstream ss(line);
		getline(ss, name, ',');
		stu[i].name = name;

	        getline(ss, gender, ',');
		gender.erase(0,1);
		stu[i].sex = gender;
			
		getline(ss, score, ',');
		score.erase(0,1);		
		stu[i].score = stod(score);

		i++;
	}

	int a = 0;
	double sum = 0;
	while (stu[a].name != "\0")
	{
		sum += stu[a].score;
		a++;
	}
	double aver = 0;
	aver = sum / a;
	cout << fixed << setprecision(1);
	cout << "所有学生的平均分：" << aver << endl;
	double sum1 = 0;
	double sum2 = 0;
	int m = 0;
	int f = 0;
	for(int y = 0; y < a; ++y)
	{
		if (stu[y].sex == "Male")
		{
			sum1 += stu[y].score;
			m++;
		}
		else if (stu[y].sex == "Female")
		{
			sum2 += stu[y].score;
			f++;
		}
	}
	double aver1 = 0;
	double aver2 = 0;
	aver1 = sum1 / m;
	aver2 = sum2 / f;
	cout << fixed << setprecision(1);
	cout << "所有男学生的平均分：" << aver1 << endl;
	cout << "所有女学生的平均分：" << aver2 << endl;
	sort(stu, stu + a, comp);
	Student P;
	for (int k = 1; k < a; k++)
	{
		for (int i = 1; i < a; i++)
		{
			if (stu[i - 1].score == stu[i].score)
			{
				if (stu[i - 1].name > stu[i].name)
				{
					P = stu[i - 1];
					stu[i - 1] = stu[i];
					stu[i] = P;
				}
			}
		}
	}
	for (int i = 0; i < a; i++)
	{
		cout << stu[i].name << " " << stu[i].sex << " " << stu[i].score << endl;
	}	
        return 0;
}
