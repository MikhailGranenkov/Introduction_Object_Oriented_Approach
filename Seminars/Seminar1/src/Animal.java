public abstract class Animal {
   private String name;
   private int age;
    public abstract void voice();
    public abstract void test();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!name.equals("murzik")){
            this.name = name;
        }else {
            System.out.println("Такое имя задать нельзя!!!!");
        }

    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
