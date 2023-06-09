package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello").addObject("data", "hello!!");

        return mav;
    }

    /**
     * @ResponseBody 가 있으면 뷰 리졸버를 실행하지 않고 메시지 바디에 직접 입력 된다.
     * result : response/hello
     */
    //@ResponseBody
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {
        model.addAttribute("data", "hello!!");
        return "response/hello";
    }

    /**
     * HTTP 바디를 처리하는 파라미터가 없으면
     * 요청 URL 를 참고해 논리 뷰 이름으로 적용한다.
     * 요청 URL "/response/hello"
     * 실행 : templates/response/hello.html
     */
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hello!!");
    }

    /**
     * 참고 메시지
     * @ResponseBody , HttpEntity를 사용하면 뷰템플릿이 아닌 HTTP 바디에 직접 보낼 수 있다.
     */
}
