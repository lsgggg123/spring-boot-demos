package filters.pre

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

/**
 * Created by liushun on 2017/1/11.
 *
 */
class TestPreFilter extends ZuulFilter {

    @Override
    public int filterOrder() {
        return 50000;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        def context = RequestContext.getCurrentContext()
        def parameter = context.getRequest().getParameter("token")
        if (parameter == null || parameter.length() == 0) {
            def response = context.getResponse()
            response.setContentType("application/json")
            PrintWriter out = response.getWriter();
            out.print("{\"code\":0, \"message\":\"validate token failed ！\"}");
            out.flush();
        }
        context.set("javaPreFilter-ran", true);
        return null;
    }
}
