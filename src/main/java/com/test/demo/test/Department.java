package com.test.demo.test;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private Long id;
    private Long parentId;
    private String name;
    private String stage;
    private List<Department> children = new ArrayList<>();

    public Department(Long id, Long parentId, String name, String stage) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.stage = stage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }

    public List<Department> getChildren() {
        return children;
    }

    public void setChildren(List<Department> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", parentId=" + parentId +
                ", name='" + name + '\'' +
                ", stage='" + stage + '\'' +
                ", children=" + children +
                '}';
    }
}
