//package br.com.gameshunter.main;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class CriaXML {
//
//	public static void cep() {
//
//	}
//
//	public static void main(String[] args) {
//
//		System.out.println("arara");
//		String[] cmd = new String[3];
//		cmd[0] = "mysql";
//		cmd[1] = "-u root";
//		cmd[2] = "-proot gameshunter";
//		Process exec = Runtime.getRuntime().exec(cmd);
//		;
//		int waitFor = exec.waitFor();
//		if (waitFor == 0)
//			System.out.println("Deu certo");
//		else
//			System.out.println("Merda");
//		BufferedReader reader = new BufferedReader(new InputStreamReader(
//				exec.getInputStream()));
//		String line = reader.readLine();
//		while (line != null) {
//
//			System.out.println(line);
//			line = reader.readLine();
//
//		}
//	}
//}
