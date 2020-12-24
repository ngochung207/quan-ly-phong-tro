public class Person {
    private String name;
    private String birth;
    private String id;

    public Person() {
    }

    public Person(String name, String birth, String id) {
        this.name = name;
        this.birth = birth;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
