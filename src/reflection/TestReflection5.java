package reflection;

import charactor.Hero;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TestReflection5
{
    public static void main(String[] args)
    {
        List<String> s = readFile("src/hero.conf");
        Hero h1 = createHero(s.get(0),s.get(1));
        Hero h2 = createHero(s.get(2),s.get(3));
        attack(h1,h2);
    }

    public static List<String> readFile(String path)
    {
        List<String> s = new ArrayList<>();
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(path))))
        {
            String str = null;
            while (( str = bufferedReader.readLine()) != null)
            {
                s.add(str);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        return s;
    }

    public static Hero createHero(String clazz,String name)
    {
        Hero h = null;
        try
        {
            Class c = Class.forName(clazz);
            Constructor constructor = c.getConstructor();
            h = (Hero) constructor.newInstance();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        try
        {
            Method m = h.getClass().getMethod("setName", String.class,String.class);
            m.invoke(h,name,"111");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return h;
    }

    public static void attack(Hero h1, Hero h2)
    {
        System.out.print(h1.name);
        try
        {
            Method m = h1.getClass().getMethod("attack", Hero.class);
            m.invoke(h1,h2);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
