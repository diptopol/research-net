package filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/19/13
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */
@WebFilter(servletNames = "Faces Servlet", urlPatterns = "/rnet/*")
public class SessionFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(SessionFilter.class);
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private String requestedUrl;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        request = (HttpServletRequest) servletRequest;
        response = (HttpServletResponse) servletResponse;
        session = request.getSession(false);


        requestedUrl = request.getRequestURI().toString();
        logger.info("SessionFilter :"+requestedUrl);
        if ((session == null || session.getAttribute("userId") == null) && !requestedUrl.contains("login.xhtml") && !requestedUrl.contains("javax.faces.resource")) {
            response.sendRedirect("login.xhtml");
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
