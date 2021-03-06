package uk.ac.cam.cl.dtg.teaching;

import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;

import org.jboss.resteasy.plugins.guice.GuiceResteasyBootstrapServletContextListener;

import com.google.inject.Module;

@WebListener
public class GuiceResteasyBootstrapServletContextListenerV3 extends
		GuiceResteasyBootstrapServletContextListener {
	@Override
	protected List<? extends Module> getModules(ServletContext context) {
		return Arrays.asList(new Module[] { new ApplicationModule() });
	}
}
