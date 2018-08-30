package vn.shippo.delivery.filter;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;

public class DemoAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger logger = LogManager.getLogger(DemoAuthenticationFilter.class);

    private static final String HEADER_TOKEN = "Authorization";

    private static final String OAUTH_SERVICE_URL = "http://192.168.2.253/oauthservice/me";

    private static final String REQUEST_ATTR_DO_NOT_CONTINUE = "MyAuthenticationFilter-doNotContinue";

//    private UserService userService;
//
//    @Autowired
//    public DemoAuthenticationFilter( UserService userService){
//
//        this.userService = userService;
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {


        /** check the request true or false*/
        if (request instanceof HttpServletRequest == false) {
            filterChain.doFilter(request, response);
            return;
        }

        String accessToken = request.getHeader(HEADER_TOKEN);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[] { MediaType.APPLICATION_JSON }));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set(HEADER_TOKEN, accessToken);

        // HttpEntity<String>: To get result as String.
        HttpEntity<String> entity = new HttpEntity<String>(headers);

        // RestTemplate
        RestTemplate restTemplate = new RestTemplate();

        //send y/c with method GET and info Headers
        ResponseEntity<String> respon = restTemplate.exchange(OAUTH_SERVICE_URL,
                HttpMethod.GET, entity, String.class);

        String result = respon.getBody();
        logger.info("result response: " +result);

        //get user's role by userid from

        filterChain.doFilter(request, response);

    }

}
