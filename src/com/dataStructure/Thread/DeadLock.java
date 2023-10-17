package com.dataStructure.Thread;


/**
 * 简单的死锁例子
 * @author 小风微灵
 *
 */
public class DeadLock extends Thread{


    public DeadLock(String name){
        super(name);
    }

    public void run() {

        while(true){
            if("天使彦".equals(Thread.currentThread().getName())){
                /**
                 * 简单初步地预防死锁现象：
                 */
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized ("遥控器") {
                    System.out.println("天使彦拿到遥控器，准备去拿电池！");
                    synchronized ("电池") {
                        System.out.println("天使彦拿到遥控器和电池，吹着空调爽歪歪.....！");
                        break;
                    }
                }


            }else if("葛小伦".equals(Thread.currentThread().getName())){
                synchronized ("电池") {
                    System.out.println("葛小伦拿到电池，准备去拿遥控器！");
                    synchronized ("遥控器") {
                        System.out.println("葛小伦拿到遥控器和电池，吹着空调爽歪歪.....！");
                        break;
                    }
                }

            }
        }
    }
    public static void main(String[] args) {

        DeadLock yan=new DeadLock("天使彦");
        yan.start();
        DeadLock gxl=new DeadLock("葛小伦");
        gxl.start();
    }

}