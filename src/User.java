public class User implements Comparable<User>{
    private String name;
    private int age;

    public User() {
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public int compareTo(User obj) {
        return Integer.compare(this.age, obj.age);
    }

    public static class UserBuilder {
        private User user;

        public UserBuilder() {
            user = new User();
        }

        public UserBuilder setName(String name) {
            this.user.setName(name);
            return this;
        }

        public UserBuilder setAge(int age) {
            this.user.setAge(age);
            return this;
        }

        public User build() {
            return user;
        }
    }
}
