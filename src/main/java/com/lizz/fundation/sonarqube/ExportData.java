//package com.lizz.fundation.sonarqube;
//
//import cn.hutool.http.HttpUtil;
//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @description: todo
// * @author: lizz
// * @date: 2022/12/13 15:19
// */
//public class ExportData {
//    private static final String USERNAME = "";
//    private static final String PWD = "";
//    private static final String SONARQUBE_URL = "";
//    private static final String SEARCH_PROJECTS_URL = "http://sonar.ops.x6gx.com:9000/api/components/search_projects?ps=100";
//
//    /**
//     * loginCookie
//     *
//     * @return
//     */
//    private String loginCookie() {
//        HttpUtil.post(SONARQUBE_URL);
//    }
//
//    /**
//     *
//     */
//    private void queryProject() {
//        String rs = HttpUtil.get(SEARCH_PROJECTS_URL);
//        JSONObject rsJson = JSON.parseObject(rs);
//        JSONArray projects = rsJson.getJSONArray("components");
//        List<String> projectKeys = new ArrayList<>(projects.size());
//        for (Object project : projects) {
//            JSONObject p = (JSONObject) project;
//            projectKeys.add(p.getString("key"));
//        }
//        System.out.println(JSON.toJSONString(projectKeys));
//    }
//
//    /**
//     * 获取检查结果
//     */
//    private void CheckInfo(String projectKey) {
//
//    }
//}
