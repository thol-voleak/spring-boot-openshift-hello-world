package hello;

/**
 * User: Andrey
 * Date: 2016-08-21
 * Time: 00:12
 */
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpServletRequest;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.Properties;
import java.lang.*;


@RestController
public class GreetingController {

    private static final String template = "Hello world from, %s!";
    private final AtomicLong counter = new AtomicLong();
       
    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @RequestMapping(method = RequestMethod.GET, path = "/healthz", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Greeting.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public String getHealthz() throws Exception {
        Thread.sleep(60000);
        return "ok from voleak";
    }
    
    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @RequestMapping(method = RequestMethod.POST, path = "/test", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Greeting.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public String getTest(){
        String message = "{\"status\":\"F\",\"errorCode\":\"S00001\",\"message\":\"S00001.Pls Run this Function with Crond !\",\"serviceId\":null,\"step\":null,\"khmer\":null,\"S00001\":null,\"requestId\":\"2018072600002555\",\"messageKh\":\"S00001.Pls Run this Function with Crond !\",\"dataGateway\":null,\"data\":null,\"onlyMessage\":\"Success\"}";
        //String message = "{\"status\":\"T\",\"errorCode\":\"E00026,\"message\":\"E00026. System Encourage Level Not Invoke !\",\"serviceId\":null,\"step\":null,\"khmer\":null,\"requestId\":\"1531976169924\",\"data\":null,\"onlyMessage\":\"System Encourage Level Not Invoke\"}";
        return message;
    }
    
    
    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @RequestMapping(method = RequestMethod.GET, path = "/", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue = "Andy")
    })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Greeting.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) throws Exception{
        //return new Greeting(counter.incrementAndGet(), String.format(template, name));
        //Thread.sleep(60000);
        return new Greeting();
    }
    
    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @RequestMapping(method = RequestMethod.POST, path = "/db", produces = "application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = Greeting.class),
            @ApiResponse(code = 401, message = "Unauthorized"),
            @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    public String getCon(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting().testConn();
    }
    

}
