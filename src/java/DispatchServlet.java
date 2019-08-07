import com.pro.util.annotation.RequestMapping;
import com.pro.util.utils.AnnotationUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class DispatchServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //解决url中的中文字符乱码的问题
        req.setCharacterEncoding("UTF-8");
        //获取url中的ServletPath
        String reqContextPath = req.getServletPath();
        System.out.println(reqContextPath);

        //获得com.pro.controller包中含有controller注解的类
        List<Class<?>> controllers = AnnotationUtil.getControllers("com.pro.controller");

        List<String> valueList = new ArrayList<>();
        //获得有RequestMapping注解的方法
        for (Class<?> cls : controllers) {
            Method[] methods = cls.getMethods();
            for (Method method : methods) {
                RequestMapping annotation = method.getAnnotation(RequestMapping.class);
                if (annotation != null) {
                    String value = annotation.value();//找到RequestMapping的注入value值
                    valueList.add(value);
                    if(value.equals(reqContextPath)){
                        try {
                            method.invoke(cls.newInstance(), req, resp);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

        if(!valueList.contains(reqContextPath)){
            resp.setStatus(404);
        }
    }
}
