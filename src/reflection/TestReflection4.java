package reflection;

import charactor.Hero;

import java.lang.reflect.Field;

public class TestReflection4
{
    public static void main(String[] args)
    {
        Hero h = new Hero();
        h.name = "hahah";
        h.setDescription("11111");
        System.out.println(h);
        try
        {
           Field f =  h.getClass().getDeclaredField("name");
           f.set(h,"123");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(h);
        try
        {
            Field f = h.getClass().getDeclaredField("description");
            f.setAccessible(true);
            f.set(h,"okok");
            Field f1 = h.getClass().getDeclaredField("id");
            f1.setInt(h,1);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        System.out.println(h);
    }
}
