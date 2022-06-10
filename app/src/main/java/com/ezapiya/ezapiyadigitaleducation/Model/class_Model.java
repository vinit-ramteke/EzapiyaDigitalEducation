package com.ezapiya.ezapiyadigitaleducation.Model;

public class class_Model {
    private String id;
    private String className;

    public class_Model() {
    }
    public class_Model(String id, String className) {
        this.id = id;
        this.className = className;
    }

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
