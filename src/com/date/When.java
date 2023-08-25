package com.date;

//计算是第几天
public class When {
    int dow(int y,int m,int d) {
        int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
        do{
          y -= m;
        }while (m<3);
        //y -= m < 3;
        return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
    }

    public static void main(String[] args) {
        System.out.println(new When().dow(2023,6,8));
    }
}

//static int t[] = {0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4};
//y -= m < 3;
//return (y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;