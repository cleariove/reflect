package charactor;

public class Hero
{
    public String name;
    public float hp;
    public int damage;
    public int id;
    private String description;

    static String copyRight;

    static
    {
        System.out.println("初始化copyRight");
        copyRight = "版权由riot公司所有";
        System.out.println(copyRight);
    }

    @Override
    public String toString()
    {
        return "Hero{" +
                "name='" + name + '\'' +
                ", hp=" + hp +
                ", damage=" + damage +
                ", id=" + id +
                ", description='" + description + '\'' +
                '}';
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name,String ddd)
    {
        this.name = name;
        System.out.println(ddd);
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public void attack(Hero h)
    {
        System.out.println(this.name + " attack " + h.name);
    }
}