package br.com.gameshunter.util;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;

public class WindowsShell {

	private static final Logger log = Logger.getLogger(WindowsShell.class
			.getName());

	public void executeCommand(final String... inputs) throws IOException {

		final ArrayList<String> commands = new ArrayList<String>();
		commands.add("c:/windows/system32/cmd.exe");
		commands.add("/c");
		for (String x : inputs) {
			commands.add(x);
		}
		BufferedReader br = null;
		BufferedReader br2 = null;

		try {
			final ProcessBuilder p = new ProcessBuilder(commands);
			final Process process = p.start();
			final InputStream is = process.getInputStream();
			final InputStream es = process.getErrorStream();
			final InputStreamReader isr = new InputStreamReader(is);
			final InputStreamReader isr2 = new InputStreamReader(es);

			br = new BufferedReader(isr);
			br2 = new BufferedReader(isr2);

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("Retorno do comando = [" + line + "]");
			}

			while ((line = br2.readLine()) != null) {
				System.out.println("Retorno do comando = [" + line + "]");
			}

		} catch (IOException ioe) {
			log.severe("Erro ao executar comando shell" + ioe.getMessage());
			throw ioe;
		} finally {
			secureClose(br);
			secureClose(br2);
		}
	}

	private void secureClose(final Closeable resource) {
		try {
			if (resource != null) {
				resource.close();
			}
		} catch (IOException ex) {
			log.severe("Erro = " + ex.getMessage());
		}
	}
}