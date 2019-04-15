package com.gupaoedu.vip.pattern.proxy.dynamicproxy.gpproxy;

import javax.naming.Name;
import javax.tools.*;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * 用来生成源代码
 * 这个类的主要功能是生成代理类
 */
public class GPProxy {

    public static final String ln = "\r\n";
    public static final String tab = "\t";

    public static Object newProxyInstance(GPClassLoader loader,Class[] interfaces,GPInvocationHandle h){


        try {
            //1、动态生成源代码
            String src = generateSrc(interfaces);
            //2、Java文件输出到磁盘
            String filePath = GPProxy.class.getResource("").getPath();
            File file = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(file);
            fw.write(src);
            fw.flush();
            fw.close();
            //3、编译java文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable it = manager.getJavaFileObjects(file);
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null,null,it);
            task.call();
            manager.close();
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandle.class);

            System.out.println(src);

            return c.newInstance(h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 生成代理类源码
      * @param interfaces
     * @return
     */
    private static String generateSrc(Class[] interfaces) {
        StringBuffer sb = new StringBuffer();
        sb.append("package com.gupaoedu.vip.pattern.proxy.dynamicproxy.gpproxy;" + ln);
        sb.append("import com.gupaoedu.vip.pattern.proxy.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        sb.append("public final class $Proxy0 extends GPProxy implements " +interfaces[0].getName() + "{" +ln);
            sb.append(tab + "private GPInvocationHandle h;" + ln);
            sb.append(tab + "public $Proxy0(GPInvocationHandle h){" + ln);
                sb.append(tab + tab + "this.h = h;" + ln);
            sb.append(tab + "}" + ln);

            for (Method m : interfaces[0].getMethods()){
                sb.append(tab + "public " + m.getReturnType() +" " + m.getName() + "(){" + ln);
                    sb.append(tab+tab + "try{" + ln);
                        sb.append(tab + tab +tab + "Method m = " +interfaces[0].getName() + ".class.getMethod(\"" + m.getName()+"\",new Class[]{});" + ln);
                        sb.append(tab+tab+tab +"this.h.invoke(this,m,null);" + ln);

                    sb.append(tab+tab + "}catch(Throwable e){" + ln);
                        sb.append(tab+tab+tab + "e.printStackTrace();" + ln);
                    sb.append(tab+tab + "}" +ln);


                sb.append(tab + "}" + ln);
            }



        sb.append("}" + ln);

        return sb.toString();
    }

}
