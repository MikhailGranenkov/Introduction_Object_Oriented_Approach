package Lectures.Lecture1.Ex005;


// Этот код представляет класс Magician, который моделирует мага в какой-то игровой среде. Давайте разберем его по частям:

// Поля класса:
// private static int number и private static Random r: статические поля, общие для всех объектов класса. number хранит количество созданных экземпляров класса, а r представляет генератор случайных чисел.
// private String name, private int hp, private int maxHp, private int mana, private int maxMana: поля объекта, представляющие имя мага, его текущее и максимальное количество здоровья (hp), маны (mana) и максимальное количество маны (maxMana).
// Блок инициализации:
// static {...}: статический блок инициализации, который выполняется при первой загрузке класса. Здесь инициализируются статические поля number и r.
// Конструкторы:
// public Magician(String name, int hp, int mana): конструктор, который принимает имя мага, его здоровье и количество маны в качестве параметров и инициализирует соответствующие поля объекта.
// public Magician(): конструктор без параметров, который создает мага с случайными значениями здоровья и маны, а также увеличивает счетчик number.
// Методы:
// public int Attack(): метод, представляющий атаку мага. Генерирует случайное значение урона и уменьшает количество маны на 80% этого урона. Возвращает урон, нанесенный атакой.
// public String getInfo(): метод, возвращающий информацию о маге (имя, здоровье, мана и тип).
// public void healed(int Hp): метод, который увеличивает здоровье мага на указанное количество, но не превышает максимальное значение здоровья.
// public void GetDamage(int damage): метод, который уменьшает здоровье мага на указанное количество урона.
// Этот класс моделирует базовое поведение мага, его способность атаковать, получать урон и восстанавливать здоровье.


import java.util.Random;

public class Magician {
    private static int number;
    private static Random r;

    private String name;
    private int hp;
    private int maxHp;

    private int mana;
    private int maxMana;

    static {
        Magician.number = 0;
        Magician.r = new Random();
    }

    public Magician(String name, int hp, int mana) {
        this.name = name;
        this.hp = hp;
        this.maxHp = hp;
        this.mana = mana;
        this.maxMana = mana;
    }

    public Magician() {
        this(String.format("Hero_Magician #%d", ++Magician.number),
                Magician.r.nextInt(100, 200),
                Magician.r.nextInt(50, 150));
    }

    public int Attack() {
        int damage = Magician.r.nextInt(20, 30);
        this.mana -= (int)(damage * 0.8);
        if (mana < 0) return 0;
        else return damage;
    }

    public String getInfo() {
        return String.format("Name: %s  Hp: %d Enegry:  %d Type: %s",
                this.name, this.hp, this.mana, this.getClass().getSimpleName());
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