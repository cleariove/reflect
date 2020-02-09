package reflection;

import charactor.Hero;

public class TestReflection
{
    public static void main(String[] args)
    {
        String className = "charactor.Hero";
        Class class3 = new Hero().getClass();//这两种方式不会导致静态属性初始化
        Class class2 = Hero.class;
        try
        {
            Class class1 = Class.forName(className);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
