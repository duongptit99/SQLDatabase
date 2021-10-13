package com.example.sql_lite;

public class Student {

    private String idStudent;
    private String name;
    private String sex;
    private String iClass;
    private String pointMath;
    private String pointPhysic;
    private String pointChemistry;

    public Student() {

    }


    public String getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(String idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getiClass() {
        return iClass;
    }

    public void setiClass(String iClass) {
        this.iClass = iClass;
    }

    public String getPointMath() {
        return pointMath;
    }

    public void setPointMath(String pointMath) {
        this.pointMath = pointMath;
    }

    public String getPointPhysic() {
        return pointPhysic;
    }

    public void setPointPhysic(String pointPhysic) {
        this.pointPhysic = pointPhysic;
    }

    public String getPointChemistry() {
        return pointChemistry;
    }

    public void setPointChemistry(String pointChemistry) {
        this.pointChemistry = pointChemistry;
    }

    public Student(String idStudent, String name, String sex, String iClass, String pointMath, String pointPhysic, String pointChemistry) {
        this.idStudent = idStudent;
        this.name = name;
        this.sex = sex;
        this.iClass = iClass;
        this.pointMath = pointMath;
        this.pointPhysic = pointPhysic;
        this.pointChemistry = pointChemistry;
    }

    public Student(String name, String sex, String iClass, String pointMath, String pointPhysic, String pointChemistry) {
        this.name = name;
        this.sex = sex;
        this.iClass = iClass;
        this.pointMath = pointMath;
        this.pointPhysic = pointPhysic;
        this.pointChemistry = pointChemistry;
    }

}
