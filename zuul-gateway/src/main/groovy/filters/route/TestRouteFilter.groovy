package filters.route

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

/**
 * Created by liushun on 2017/1/11.
 *
 */
class TestRouteFilter extends ZuulFilter {
    @Override
    String filterType() {
        return "route"
    }

    @Override
    int filterOrder() {
        return 5000
    }

    @Override
    boolean shouldFilter() {
        return false
    }

    @Override
    Object run() {
        RequestContext.getCurrentContext().set("javaRouteFilter-ran", true);
        try {
            RequestContext.getCurrentContext().getResponse().sendRedirect("http://www.baidu.com");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
