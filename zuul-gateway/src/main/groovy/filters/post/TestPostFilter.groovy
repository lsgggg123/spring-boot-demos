package filters.post

import com.netflix.zuul.ZuulFilter
import com.netflix.zuul.context.RequestContext

/**
 * Created by liushun on 2017/1/11.
 *
 */
class TestPostFilter extends ZuulFilter {

    @Override
    public int filterOrder() {
        return 50000;
    }

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext.getCurrentContext().set("javaPostFilter-ran", true);
        return null;
    }
}
