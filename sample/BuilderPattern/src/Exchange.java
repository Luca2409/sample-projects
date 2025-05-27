public class Exchange {

    private final String name;

    private final Integer age;

    private final Integer height;

    public Exchange(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.height = builder.height;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public Integer getHeight() {
        return height;
    }

    public static class Builder {
        private String name;
        private Integer age;
        private Integer height;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder age(Integer age) {
            this.age = age;
            return this;
        }

        public Builder height(Integer height) {
            this.height = height;
            return this;
        }

        public Exchange build() {
            return new Exchange(this);
        }
    }

}
