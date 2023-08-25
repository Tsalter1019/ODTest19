package jdk8newFeatures.Comparator;


public class School implements Comparable<School>{

    private int code;
    private String sname;

    public School(int code, String sname) {
        this.code = code;
        this.sname = sname;
    }

    public int getCode() {
        return code;
    }

    public String getSname() {
        return sname;
    }

    @Override
    public int compareTo(School o) {
        return 0;
    }
}