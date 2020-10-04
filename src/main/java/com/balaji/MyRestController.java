package com.balaji;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
 

 
@Controller
@RequestMapping("/cricket")
public class MyRestController {
	
	@RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String welcome() {//Welcome page, non-rest
		System.out.println("I am in welcome");
        return "Welcome to RestTemplate Example.";
    }
 
	@RequestMapping(value = "/alien", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Alien getAlien() {//throws JsonProcessingException {
		System.out.println("I am in Alien");
    	Alien a1 = new Alien();
    	a1.setAlienId(1);
    	a1.setAlienName("Balaji");
    	a1.setAlienPoints(100);
    	 //ObjectMapper mapper = new ObjectMapper();
         //Converting the Object to JSONString
         
        
        //return mapper.writeValueAsString(a1); 
    	return a1;
    }

 
    // http://localhost:8081/SpringMVC-REST/cricket/getiplteam/MI
 
    /**
     * Returns full-form of the IPL team in STRING format, based on the input arguments(iplcode)
     *
     * @param iplcode
     * @return
     */
    @RequestMapping(value="/getiplteam/{iplcode}", method=RequestMethod.GET)
    @ResponseBody
    public String getIPLTeam(@PathVariable String iplcode) {
 
        if(null != iplcode && !"".equalsIgnoreCase(iplcode)){
 
            if("MI".equalsIgnoreCase(iplcode)){
                return "Mumbai Indians";
            }
            else if("DD".equalsIgnoreCase(iplcode)){
                return "Delhi Daredevils";
            }
            else{
                return "Chennai Super Kings";
            }
        }
        else{
            return "Enter correct IPL team code";
        }
    }
 
    // http://localhost:8081/SpringMVC-REST/cricket/getplayer/1
 
    /**
     * Returns Player OBJECT, based on the player id
     *
     * @param id
     * @return
     */
    @RequestMapping(value="/getplayer/{id}", method=RequestMethod.GET)
    @ResponseBody
    public Player getPlayer(@PathVariable String id) {
 
        // create an object of type Player
        Player player = new Player();
 
        if(null != id && id.equalsIgnoreCase("1")){
            player.setId(1);
            player.setName("Sachin Tendulkar");
            player.setMatches("200");
        }
        else{
            player.setId(000);
            player.setName("Unknown Player");
            player.setMatches("000");
        }
        return player;
    }
 
    // http://localhost:8081/SpringMVC-REST/cricket/createplayer
 
    @RequestMapping(value="/createplayer", method=RequestMethod.POST)
    @ResponseBody
    public String createOrSavePlayer(@RequestBody Player player) {
        // insert new record into database and return primary id ~ playerId
        int playerId = 0;
        String playerInfo = "New Player created/inserted with player id " + ++playerId;
        return playerInfo;
    }
}
