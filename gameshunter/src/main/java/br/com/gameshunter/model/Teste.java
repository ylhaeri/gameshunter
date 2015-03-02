package br.com.gameshunter.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Persistence;

public class Teste {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String fileName;
	@Lob
	private byte[] image;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public byte[] getImagem() {
		return image;
	}

	public void setImagem(byte[] image) {
		this.image = image;
	}

	public byte[] readImageOldWay(File file) throws IOException {
		InputStream is = new FileInputStream(file);
		long length = file.length();
		if (length > Integer.MAX_VALUE) {
			System.out.println("File too large");
		}

		byte[] bytes = new byte[(int) length];
		int offset = 0;
		int numRead = 0;
		while (offset < bytes.length && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
			offset += numRead;
		}

		is.close();
		if (offset < bytes.length) {
			throw new IOException("Could not completely read file " + file.getName());
		}
		return bytes;
	}

	public static void main(String[] args) throws IOException {

		EntityManager em = Persistence.createEntityManagerFactory("gameshunter").createEntityManager();

		Teste teste = em.find(Teste.class, 9);
		FileOutputStream fos = new FileOutputStream(new File("D:/arara.txt"));

		fos.close();
		fos.write(teste.getImagem());
	}
}