package oopmodel;

import java.util.Objects;

public abstract class ModelClass {
    private int id;
    private String name;

    public ModelClass(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public ModelClass(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModelClass that)) return false;
        return id == that.id && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return "ModelClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
