package year2019;

/**
 * @package year2019
 * @Author: likun
 * @Date: 2019/4/10
 */
public class BuilderDemo {

    private String name;

    private Integer age;

    private String agentName;

    public static class Builder {

        private String name;

        private Integer age;

        private String agentName;

        public Builder(String name,Integer age) {
            this.name = name;
            this.age = age;
        }

        public Builder agentName(String agentName){
            this.agentName = agentName;
            return this;
        }

        public BuilderDemo build() {
            return new BuilderDemo(this);
        }
    }

    private BuilderDemo(Builder builder) {
        name = builder.name;
        age = builder.age;
        agentName = builder.agentName;
    }


}
