package dddspring;

import java.util.Calendar;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class FooterInterceptor implements HandlerInterceptor {

  @Autowired
  BuildProperties buildProperties;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {

    request.getSession().setAttribute("version", buildProperties.getVersion());
    request.getSession().setAttribute("appName", buildProperties.getName());
    request.getSession().setAttribute("appYear", Calendar.getInstance().get(Calendar.YEAR));

    request.getSession().setAttribute("userName", "Jean Alexandre");
    request.getSession().setAttribute("user", "jean.dobre");
    request.getSession().setAttribute("role", "Administrador");
    request.getSession().setAttribute("avatar", "https://avatar-management--avatars.us-west-2.prod.public.atl-paas.net/6153601bc7bea40069dc8e5e/0958ea6d-f79e-4287-83a2-dddcac83ac22/48");
        
    return true;
  }

}
