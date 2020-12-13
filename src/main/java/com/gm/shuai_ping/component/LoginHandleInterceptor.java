package com.gm.shuai_ping.component;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.gm.shuai_ping.util.JwtUtil;
import com.gm.shuai_ping.util.ResultCode;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginHandleInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //不加这个的话，除了拦截器放行的（exclude）请求，那所有的请求就都会被拦截了
        //跨域请求会首先发一个option请求，直接返回正常状态并通过拦截器
        if(request.getMethod().equals("OPTIONS")){
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }
        //response.setCharacterEncoding("utf-8");
        //这个是拿来当没通过拦截器的时候，写响应信息给前端用的
        response.setContentType("application/json;charset=utf-8");
        //这个也是拿来当没通过拦截器的时候，写响应信息给前端用的
        Map<String,Object> map= new HashMap<>();
        //获取token，准备做token的验证
        String token=request.getHeader("token");
        //获取uri，准备做身份的验证
        String uri = request.getRequestURI();
        System.out.println("uri:"+uri);
        String[]  role=uri.split("/");
        System.out.println("截取的字符串role："+role[2]);
        //开始验证
        if(null!=token){
            boolean verity = JwtUtil.verity(token,role[2]); //把token和用户身份都传进去验证
            if(verity){
                System.out.println("token最终验证成功，通过拦截器");
                return true;
            }else { //拦截请求并返回信息给前端
                map.put("code",ResultCode.VERIFYTOKENFILE.getCode());
                map.put("message",ResultCode.VERIFYTOKENFILE.getMessage());
                JSONObject jsonObject = new JSONObject(map);
                response.getWriter().append(jsonObject.toString());
                System.out.println("token验证失败，未通过拦截器");
                return false;
            }
        }
        map.put("code",ResultCode.NOTOKEN.getCode());
        map.put("message",ResultCode.NOTOKEN.getMessage());
        JSONObject jsonObject = new JSONObject(map);
        response.getWriter().append(jsonObject.toString());
        System.out.println("请求中没有token在header中");
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
