package br.com.gameshunter.exemplos;

import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.startup.Tomcat;

public class EmbeddedServer implements Runnable {

	private Tomcat tomcat;
	private Thread serverThread;

	public EmbeddedServer(int port, String contextPath) throws ServletException {
		tomcat = new Tomcat();
		tomcat.setPort(port);
		tomcat.setBaseDir("target/tomcat");
		tomcat.addWebapp(contextPath,
				new File("src/main/webapp").getAbsolutePath());
		serverThread = new Thread(this);
	}

	public void start() {
		serverThread.start();
		while (tomcat.getServer().getState() != LifecycleState.STARTED) {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			continue;
		}
		System.out.println("Servidor iniciado!!!");
	}

	public void run() {
		try {
			tomcat.start();
		} catch (LifecycleException e) {
			throw new RuntimeException(e);
		}
		tomcat.getServer().await();
	}

	public void stop() {
		try {
			tomcat.stop();
			tomcat.destroy();
			deleteDirectory(new File("target/tomcat/"));
		} catch (LifecycleException e) {
			throw new RuntimeException(e);
		}
	}

	void deleteDirectory(File path) {
		if (path == null)
			return;
		if (path.exists()) {
			for (File f : path.listFiles()) {
				if (f.isDirectory()) {
					deleteDirectory(f);
					f.delete();
				} else {
					f.delete();
				}
			}
			path.delete();
		}
	}
}