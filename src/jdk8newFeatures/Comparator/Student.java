package jdk8newFeatures.Comparator;


import java.util.Arrays;
import java.util.List;

public class Student {

    private String name;
    private int age;
    private long homeDistance;
    private double weight;
    private School school;

    public Student() {
    }

    public Student(String name, int age, long homeDistance, double weight, School school) {
        this.name = name;
        this.age = age;
        this.homeDistance = homeDistance;
        this.weight = weight;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public long getHomeDistance() {
        return homeDistance;
    }

    public double getWeight() {
        return weight;
    }

    public School getSchool() {
        return school;
    }


    public static List<Student> getStudentList(){
        Student s1 = new Student("Sam",18,3455,60.75,new School(101,"A"));
        Student s2 = new Student("Dam",17,5455,56.75,new School(105,"B"));
        Student s3 = new Student("Aam",16,1455,43.75,new School(106,"E"));
        Student s4 = new Student("Wam",15,9455,68.75,new School(108,"S"));
        List<Student> list = Arrays.asList(s1,s2,s3,s4);
        return list;
    }
}