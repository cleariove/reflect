package reflection;

import charactor.ADHero;
import charactor.Hero;

import java.io.*;
import java.lang.reflect.Constructor;
import java.nio.Buffer;

public class TestReflection3
{
    public static void main(String[] args)
    {
        ADHero h = (ADHero) getHero();
        h.physicAttack();
    }

    public static Hero getHero()
    {
        File file = new File("src/hero.conf");
//        字节流文件读取
//        try
//        {
//            InputStream fis = new FileInputStream("src/hero.conf");
//            byte[] s = new byte[(int) file.length()];
//            fis.read(s);
//            fis.close();
//            for(byte b:s)
//                System.out.println((char)b);
//
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }

//        字符流文件读取
        String name = null;
        try
        {
            BufferedReader bf = new BufferedReader(new FileReader(file));
            name = bf.readLine();
            bf.close();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        Hero h = null;
        try
        {
            Class c = Class.forName(name);
            Constructor constructor = c.getConstructor();
            h = (Hero) constructor.newInstance();
            h.name = "vanye";
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return h;
    }
}
