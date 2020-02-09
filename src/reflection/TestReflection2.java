package reflection;

import charactor.Hero;

import java.lang.reflect.Constructor;

public class TestReflection2
{
    public static void main(String[] args)
    {
        try
        {
            String className = "charactor.Hero";
            Class clazz = Class.forName(className);
            Constructor constructor = clazz.getConstructor();
            Hero h = (Hero) constructor.newInstance();
            h.name = "green";
            System.out.println(h);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
