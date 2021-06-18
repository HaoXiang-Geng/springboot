package com.atgenghx.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;


@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return "helloworld";
    }

    /**
     * 2、通过HttpServletRequest接收
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/addUser")
    public void addUser(HttpServletRequest request, HttpServletResponse response)throws IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获取请求行的相关信息
        out.println("getMethod:" + request.getMethod() + "<br/>");
        out.println("getQueryString:" + request.getQueryString() + "<br/>");
        out.println("getProtocol:" + request.getProtocol() + "<br/>");
        out.println("getContextPath" + request.getContextPath() + "<br/>");
        out.println("getPathInfo:" + request.getPathInfo() + "<br/>");
        out.println("getPathTranslated:" + request.getPathTranslated() + "<br/>");
        out.println("getServletPath:" + request.getServletPath() + "<br/>");
        out.println("getRemoteAddr:" + request.getRemoteAddr() + "<br/>");
        out.println("getRemoteHost:" + request.getRemoteHost() + "<br/>");
        out.println("getRemotePort:" + request.getRemotePort() + "<br/>");
        out.println("getLocalAddr:" + request.getLocalAddr() + "<br/>");
        out.println("getLocalName:" + request.getLocalName() + "<br/>");
        out.println("getLocalPort:" + request.getLocalPort() + "<br/>");
        out.println("getServerName:" + request.getServerName() + "<br/>");
        out.println("getServerPort:" + request.getServerPort() + "<br/>");
        out.println("getScheme:" + request.getScheme() + "<br/>");
        out.println("getRequestURL:" + request.getRequestURL() + "<br/>");
    }

    @ResponseBody
    @RequestMapping("/taskflux_source")
    public void report(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer url =request.getRequestURL();
        System.out.println(url);
        String part=request.getQueryString();
        String[] str=part.split("&");
        System.out.println(Arrays.toString(str));
        jdbc jd=new jdbc();
        jd.report(part);
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println("return success");
    }



    @ResponseBody
    @CrossOrigin
    @RequestMapping("/selecttaskflux_source")
    public void slereport(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        jdbc jd=new jdbc();
        ArrayList<String> arr= jd.douyinurl();
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.println(arr.toString());
    }


}
