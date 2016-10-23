package web.controller;  
  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  
import java.util.logging.Logger;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.codehaus.jackson.map.ObjectMapper;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam; 
import org.springframework.web.servlet.ModelAndView;

import com.kapp.pojo.User;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.web.bind.annotation.RequestMethod;

import service.DisplayService;
import service.UserManagerService;  
  
@Controller
@RequestMapping(value = "/rest", method = RequestMethod.GET)

public class DisplayController {  
    private Logger logger = Logger.getLogger(DisplayController.class.getName());  
      
    @Autowired  
    private DisplayService displayService;
    
    @Resource(name="userManager")
    private UserManagerService userManagerService;
      
      
    @RequestMapping("/display/html")  
    public ModelAndView helloWorldHTML() {  
        String message = displayService.getHelloWorld();  
        logger.info(message);  
        return new ModelAndView("greetingHTML", "message", message);  
    }  
    
    @RequestMapping("/display/jsp")  
    public ModelAndView helloWorldJSP() {  
//        String message = displayService.getHelloWorld();  
//        logger.info(message);  
    	List<User> userList = this.userManagerService.getAllUser();
        
//        request.setAttribute("userlist", userList);
    	
        return new ModelAndView("greetingJSP", "userList", userList);  
    }
    
    @RequestMapping("/display/demojqueryjsp")  
    public ModelAndView showDemoJSP() {  
    	
    	List<User> userList = this.userManagerService.getAllUser();
    	
        return new ModelAndView("demo", "userList", userList);
    }
    
    @RequestMapping("/display/showjspangularjs")  
    public ModelAndView showJSPAngularJS() {  
    	
    	List<User> userList = this.userManagerService.getAllUser();
    	
        return new ModelAndView("demo_angularjs", "userList", userList);
    }
      
    @RequestMapping(value="/display/random")  
    public @ResponseBody String displayJson() throws Exception{  
        int randomValue = displayService.getRandomNumber();  
        Map<String,Object> map = new HashMap<String,Object>();  
        map.put("randomValue", randomValue);  
        ObjectMapper objectMapper = new ObjectMapper();    
        String result = objectMapper.writeValueAsString(map);    
        return result;  
    }  
      
    @RequestMapping(value="/display/user",produces={"application/json;charset=UTF-8"})  
    public @ResponseBody List<User> displayUser() throws Exception{  
        User user = displayService.getUser();  
        List<User> users = new ArrayList<User>();  
        users.add(user);  
        return users;   
    }
    
    @RequestMapping(value="/display/getallusers")
    public @ResponseBody String getAllUsersJson() throws Exception{  
    	String returnJSON = null;
    	List<User> userList = this.userManagerService.getAllUser();
    	JSONArray jsonArray = new JSONArray();
    	JSONObject userEntry = null;
    	for(User user:userList) {
    		userEntry = new JSONObject();
    		userEntry = JSONObject.fromObject(user);
    		userEntry.discard("birthday");
    		jsonArray.add(userEntry);
    	}
    	returnJSON = jsonArray.toString();
    	
        return returnJSON;
    }
    
    @RequestMapping(value="/display/getuser")
    public @ResponseBody String getUserJson(@RequestParam String userIdJSONStr, HttpServletRequest httpRequest) throws Exception{
    	String returnJSON = null;
    	
    	JSONObject userIdJSONObj = JSONObject.fromObject(userIdJSONStr);
    	String userId = userIdJSONObj.getString("userId");
    	User user = this.userManagerService.getUser(userId);
    	JSONObject userEntry = JSONObject.fromObject(user);
    	returnJSON = userEntry.toString();
    	
        return returnJSON;
    }
      
}