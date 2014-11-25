package br.com.gameshunter.schedule;
import org.springframework.scheduling.annotation.Scheduled;

public class Arara {

	@Scheduled(fixedDelay = 100000)
	public void teste() {
		System.out.println("Evento de 1 em 1 minuto");
	}
}