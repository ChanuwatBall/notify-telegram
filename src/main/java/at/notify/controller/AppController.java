package at.notify.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import at.notify.dto.ResultPhotoDTO;
import at.notify.dto.SendMessageResDTO;
import at.notify.dto.SendPhotoResDTO;
import at.notify.service.HttpService;
import at.notify.service.TelegramService;

@Controller
@RequestMapping("app/api")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class AppController {
    
    private static final String TELEGRAM_API_URL = "https://api.telegram.org/bot";

    @Autowired 
    private TelegramService telegramService;

    @Autowired 
    private HttpService httpService;

	private MessageSource messageSource;
	public AppController(MessageSource messageSource) {
		this.messageSource = messageSource;
	} 


    @Value("${telegram.bot.token}")
    private String botToken;
   
    @GetMapping("/")
    public String test(){
        return "Test !";
    }

    @GetMapping("/send-message") 
    public ResponseEntity<SendMessageResDTO> sendMessage(@RequestParam String chatId, @RequestParam String message) throws Exception {
        telegramService.sendMessage(chatId, message);
        SendMessageResDTO messageres  = new SendMessageResDTO();
        Map<String, String> params = Map.of(
            "chat_id", chatId,
            "text", message
        );

        String reqUrl = TELEGRAM_API_URL+botToken+"/sendMessage";
        HttpService service = new HttpService();                    
        String response =  service.sendGetRequest(reqUrl, params);
        System.out.println("params: "+params);
        System.out.println("response: "+response);

        ObjectMapper objectMapper = new ObjectMapper(); 
        try { 
            messageres = objectMapper.readValue(response, SendMessageResDTO.class); 
        } catch (Exception e) {
            e.printStackTrace();
        }
       
        // return "Message sent successfully!";
		return new ResponseEntity<SendMessageResDTO>(messageres, HttpStatus.OK);
    }



    @PostMapping("/send-photo") 
    public ResponseEntity<SendPhotoResDTO> sendPhoto(@RequestParam String chatId ,@RequestHeader Map<String, String> headers) throws Exception {
       
        SendPhotoResDTO messageres  = new SendPhotoResDTO();
        Map<String, String> params = Map.of(
            "chat_id", chatId 
        );
        
        String  body = "{ \"photo\": \""+headers.get("photo")+"\" }";

        String reqUrl = TELEGRAM_API_URL+botToken+"/sendPhoto";
        HttpService service = new HttpService();         
        // String body = "{}";
        String response =  service.sendPostRequest(reqUrl, body.toString(), params);
        System.out.println("params: "+params);
        System.out.println("response: "+response);

        ObjectMapper objectMapper = new ObjectMapper(); 
        try { 
            messageres = objectMapper.readValue(response, SendPhotoResDTO.class); 
        } catch (Exception e) {
            e.printStackTrace();
        }

		return new ResponseEntity<SendPhotoResDTO>(messageres, HttpStatus.OK);
    }
     
}
