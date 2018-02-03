package year2018;

/**
 * 实现Comparable接口作为比较
 * @author likun
 * @date 2018-01-05
 */
public class Day0103 implements Comparable<Day0103>{

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写compareTo方法
     * @param o
     * @return
     */
    @Override
    public int compareTo(Day0103 o) {
        if (this.age > o.age){
            return 1;
        }
        if (this.age < o.age){
            return -1;
        }
        if (this.name.compareTo(o.name)>0){
            return 1;
        }

        if (this.name.compareTo(o.name)<0){
            return -1;
        }
        return 0;
    }
}
