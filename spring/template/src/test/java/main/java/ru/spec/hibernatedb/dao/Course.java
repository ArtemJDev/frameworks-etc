package template.src.test.java.main.java.ru.spec.hibernatedb.dao;

public class Course {

    private int id;
    private String title;
    private int length;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", length=" + length +
            ", description='" + description + '\'' +
            '}';
    }
}
