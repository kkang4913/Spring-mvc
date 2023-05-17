package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Controller : 반환 값이 String -> view 로 인식, 뷰를 찾고 랜더링
 * @RestController : 반환 값으로 view 를 찾는 것이 아니라, HTTP 메시지 바디에 바로 입력
 * 사용 이유: return 문자열 String 그대로 메시지 바디에 바로 입력
 */

/**
 * @Slf4j : 로그 선언 바로 사용할수 있게 해준다.
 */
@Slf4j
@RestController
public class LogTestController {

    //private final Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/log-test")
    public String logTest(){
        String name ="Spring";

        //System.out.println("name = " + name);

        /**
         * 1) TRACE : 추적 레벨은 Debug 보다 훨씬 상세한 정보를 나타낸다.
         * 2) DEBUG : 프로그램을 디버깅하기 위한 정보를 표시한다.
         * 3) INFO  : 상태변경과 같은 정보성 로그를 표시한다.
         * 4) WARN  : 처리 가능한 문제, 향후 시스템 에러의 원인이 될 수 있는 경고성 메시지를 나타낸다.
         * 5) ERROR : 요청을 처리하는 중 오류가 발생한 경우 표시한다.
         *
         * 개발 서버는 debug 출력
         * 운영 서버는 info 출력
         * 시간, 로그 레벨, 프로세스 ID, 쓰레드 명, 클래스명, 로그 메시지
         */
        log.trace("trace log={}",name);
        log.debug("debug log={}",name);
        log.info("info log={}",name);
        log.warn("warn log={}",name);
        log.error("error log={}",name);

        // 로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행, 이런 방식으로 사용하면 안된다.
        // 쓸모없는 리소스를 사용해버린다.
        log.debug("String concat log" + name);
        return "ok";
    }
}
