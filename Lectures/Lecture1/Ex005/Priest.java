package Lectures.Lecture1.Ex005;


// Этот код представляет класс Priest, который моделирует священника в какой-то игровой среде. Давайте разберем его по частям:

// Поля класса:
// private static final String HERO_PRIEST_D = "Hero_Priest #%d": константа, представляющая формат имени священника.
// private static int number и private static Random r: статические поля, общие для всех объектов класса. number хранит количество созданных экземпляров класса, а r представляет генератор случайных чисел.
// private String name, private int hp, private int maxHp, private int elixir, private int maxElixir: поля объекта, представляющие имя священника, его текущее и максимальное количество здоровья (hp), эликсира (elixir) и максимальное количество эликсира (maxElixir).
// Блок инициализации:
// static {...}: статический блок инициализации, который выполняется при первой загрузке класса. Здесь инициализируются статические поля number и r.
// Конструкторы:
// public Priest(String name, int hp, int elixir): конструктор, который принимает имя священника, его здоровье и количество эликсира в качестве параметров и инициализирует соответствующие поля объекта.
// public Priest(): конструктор без параметров, который создает священника с случайными значениями здоровья и эликсира, а также увеличивает счетчик number.
// Методы:
// public int Attack(): метод, представляющий атаку священника. Генерирует случайное значение урона и уменьшает количество эликсира на 80% этого урона. Возвращает урон, нанесенный атакой.
// public String getInfo(): метод, возвращающий информацию о священнике (имя, здоровье, эликсир и тип).
// public void healed(int Hp): метод, который увеличивает здоровье священника на указанное количество, но не превышает максимальное значение здоровья.
// public void GetDamage(int damage): метод, который уменьшает здоровье священника на указанное количество урона.


import java.util.Random;

public class Priest {
    private static final String HERO_PRIEST_D = "Hero_Priest #%d";
    private static int number;
    private static Random r;

    private String name;
    private int hp;
    private int maxHp;

    private int elixir;
    private int maxElixir;

    static {
        Priest.number = 0;
        Priest.r = new Random();
    }

    public Priest(String name, int hp, int elixir) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.elixir = elixir;
        this.maxElixir = elixir;
    }

    public Priest() {
        this(String.format(HERO_PRIEST_D, ++Priest.number),
        Priest.r.nextInt(100, 200),
        Priest.r.nextInt(50, 150));
    }

    public int Attack() {
        int damage = Priest.r.nextInt(20, 30);
        this.elixir -= (int)(damage * 0.8);
        if (elixir < 0) return 0;
        else return damage;
    }

    public String getInfo() {
        return String.format("Name: %s  Hp: %d Elixir:  %d Type: %s",
                this.name, this.hp, this.elixir, this.getClass().getSimpleName());
    }
    
    public void healed(int Hp) {
        this.hp = Hp + this.hp > this.maxHp ? this.maxHp : Hp + this.hp;
    }

    public void GetDamage(int damage) {
        if (this.hp - damage > 0) {
            this.hp -= damage;
        }
        // else { die(); }
    }
}
