package br.com.gameshunter.schedule;
import org.springframework.scheduling.annotation.Scheduled;

public class AraraScheduled {

	@Scheduled(fixedDelay = 3000000)
	public void teste() {
		System.out.println("Evento de 30 em 30 minuto");
	}
}