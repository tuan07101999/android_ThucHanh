package com.example.nguyenviettuan_thithu;

public class Users {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Users(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Users() { }
    private String name;

}
