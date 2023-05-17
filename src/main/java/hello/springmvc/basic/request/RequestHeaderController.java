package hello.springmvc.basic.request;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

@Slf4j
@RestController
public class RequestHeaderController {
    /**
     * HttpServletRequest
     * HttpServletResponse
     * HttpMethod : HTTP 메서드를 조회한다. org.springframework.http.HttpMethod
     * Locale : Locale 정보를 조회한다.
     * @RequestHeader MultiValueMap<String, String> headerMap
     * 모든 HTTP 헤더를 MultiValueMap 형식으로 조회한다.
     * @RequestHeader("host") String host
     * 특정 HTTP 헤더를 조회한다.
     * 속성
     * 필수 값 여부: required
     * 기본 값 속성: defaultValue
     * @CookieValue(value = "myCookie", required = false) String cookie
     * 특정 쿠키를 조회한다.
     * 속성
     * 필수 값 여부: required
     * 기본 값: defaultValue
     */
    @RequestMapping("/headers")
    public String headers(HttpServletRequest request,
                          HttpServletResponse response,
                          HttpMethod httpMethod,
                          Locale locale,
                          @RequestHeader MultiValueMap<String,String> headerMap,
                          @RequestHeader("host") String host,
                          @CookieValue(value="myCookie",required = false) String cookie,
                          HttpSession httpSession){

        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("host={}", host);
        log.info("MyCookie={}", cookie);
        log.info("Session={}", httpSession);


        return "ok";
    }

    @RequestMapping("/multimap/user/{userId}")
    public String multiValueMap(@PathVariable String userId,
            @RequestParam(value = "basket",required = false)List<String> basketId){
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        List<String> add = new ArrayList<>(basketId);
        for (String tt : add) {
            map.add(userId,tt);
        }

        //[value1,value2]
        List<String> values = map.get(userId);
        for (String value : values) {
            System.out.println("value = " + value);
        }
        return "ID: "+userId + "의 찜 목록 = " + values.toString();
    }
}
