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
                            String result = (String)method.invoke(cls.newInstance(), req, resp);
                            if (result.contains(":")) {
                                // 使用冒号分割字符串，得到前缀和后缀
                                int index = result.indexOf(":");// 获取冒号的位置
                                String s = result.substring(0, index);// 截取出前缀，表示操作
                                String path = result.substring(index + 1);// 截取出后缀，表示路径
                                if (s.equalsIgnoreCase("r")) {// 如果前缀是r，那么重定向！
                                    resp.sendRedirect(req.getContextPath() + path);
                                } else if (s.equalsIgnoreCase("f")) {
                                    req.getRequestDispatcher(path).forward(req, resp);
                                } else {
                                    throw new RuntimeException("你指定的操作：" + s + "，当前版本还不支持！");
                                }
                            } else {// 没有冒号，默认为转发！
                                req.getRequestDispatcher(result).forward(req, resp);
                            }
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
