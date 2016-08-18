package com.mljr.demo.service.controller;

import com.mljr.demo.bean.ResponseDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ASUS on 2016/8/18.
 */
@Api(tags = "_APP")
@Controller
public class AppController {

    @Value("${app.version}")
    String version;
    @Value("${app.buildTime}")
    String buildTime;

    @RequestMapping(value = {"", "/", "/index"}, method = RequestMethod.GET)
    public void index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        StringBuffer buf = new StringBuffer();
        buf.append("<body>").append("<center>").append("MLJR Demo API").append("</center>").append("</body>");
        PrintWriter out = response.getWriter();
        out.print(buf.toString());
        out.close();
    }

    @ResponseBody
    @RequestMapping(value = "/app/version", method = RequestMethod.GET)
    public ResponseDto version(){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("version", version);
        map.put("buildTime", buildTime);
        return ResponseDto.rsOK(map);
    }

}
