package day1124;


public class LearnTwo {

    private String name;
    private String age;

    public boolean equals(Object object){
        if (!(object instanceof LearnTwo)){
            return false;
        }
        LearnTwo learn = (LearnTwo)object;
        return learn.getName().equals(name) && learn.getAge().equals(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
