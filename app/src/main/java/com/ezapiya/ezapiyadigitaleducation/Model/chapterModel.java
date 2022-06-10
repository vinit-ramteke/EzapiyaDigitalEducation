package com.ezapiya.ezapiyadigitaleducation.Model;

public class chapterModel {
    public String id;
    public String subjectId;
    public String subjectName;
    public String chapterName;

    public chapterModel() {
    }

    public chapterModel(String id, String subjectId, String subjectName, String chapterName) {
        this.id = id;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
        this.chapterName = chapterName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }
}
