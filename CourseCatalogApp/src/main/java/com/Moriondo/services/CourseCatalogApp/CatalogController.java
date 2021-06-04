package com.Moriondo.services.CourseCatalogApp;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CatalogController {

    @Autowired
    private EurekaClient client;

    @RequestMapping("/")
    public String getCatalogHome(){
        String courseAppMessage ="";
        //String courseAppURL = "http://localhost:8080/";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-App",false);
        RestTemplate restTemplate = new RestTemplate();
        String courseAppURL =instanceInfo.getHomePageUrl();
        courseAppMessage = restTemplate.getForObject(courseAppURL,String.class);
        return ("Welcome to the Course Catalog "+courseAppMessage);
    }

    @RequestMapping("/catalog")
    public String getCatalog(){
        String courses = "";
        //String courseAppURL = "http://localhost:8080/courses";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-App",false);
        RestTemplate restTemplate = new RestTemplate();
        String courseAppURL =instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL+"/courses";
        courses = restTemplate.getForObject(courseAppURL,String.class);

        return ("This is are our courses: "+courses);
    }

    @RequestMapping("/firstcourse")
    public String getSpecificCatalog(){
        Course course;
        //String courseAppURL = "http://localhost:8080/1";
        InstanceInfo instanceInfo = client.getNextServerFromEureka("course-App",false);
        RestTemplate restTemplate = new RestTemplate();
        String courseAppURL =instanceInfo.getHomePageUrl();
        courseAppURL = courseAppURL +"/1";
        course = restTemplate.getForObject(courseAppURL, Course.class);
        return ("First course is : "+course.getCoursename());
    }
}
