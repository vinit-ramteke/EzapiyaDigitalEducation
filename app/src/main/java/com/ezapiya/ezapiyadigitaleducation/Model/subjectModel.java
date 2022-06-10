package com.ezapiya.ezapiyadigitaleducation.Model;

public class subjectModel {
    public String id;
    public String classId;
    public String className;
    public String SubjectName;

    public subjectModel() {
    }

    public subjectModel(String id, String classId, String className, String subjectName) {
        this.id = id;
        this.classId = classId;
        this.className = className;
        SubjectName = subjectName;
    }

    public String getId() {
        return id;
    }

    public String getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }
}
