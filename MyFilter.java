import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by donuric on 7/15/2017.
 */
@WebFilter(filterName = "MyFilter")
public class MyFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        System.out.println("Hello filter-1 before");
      // chain.doFilter(req, resp);
        System.out.println("After filter-1  ");
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
