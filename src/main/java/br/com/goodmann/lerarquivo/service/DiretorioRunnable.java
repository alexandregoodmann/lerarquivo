package br.com.goodmann.lerarquivo.service;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.goodmann.lerarquivo.model.Resumo;

public class DiretorioRunnable implements Runnable {

	private static final Logger log = LoggerFactory.getLogger(DiretorioRunnable.class);

	private ObjectMapper mapper = new ObjectMapper();
	private String classPath = System.getProperty("user.dir");
	private File dirIN = new File(classPath + "/data/in");
	private String dirOUT = classPath + "/data/out";
	private String dirERR = classPath + "/data/err";

	@Override
	public void run() {

		File file = null;

		while (true) {
			try {

				// verifica novo arquivo a cada intervalo
				Thread.sleep(1000);

				// processa o primeiro arquivo encontrado
				file = this.getFile();
				if (file != null) {

					log.info("[ARQUIVO ENCONTRADO] :" + file.getPath());

					// Processa arquivo
					LerArquivo ler = new LerArquivo(file);
					Resumo resumo = ler.lerArquivo();

					// Gera arquivo saida
					File out = new File(this.dirOUT, "out_" + file.getName());
					String json = mapper.writeValueAsString(resumo);
					FileUtils.writeStringToFile(out, json, "UTF-8");

					// move o arquivo para pasta out
					FileUtils.moveFile(file, new File(dirOUT, file.getName()));
					log.info("[ARQUIVO PROCESSADO] :" + out.getPath());
				}
			} catch (Exception e) {
				log.error("[ERRO AO PROCESSAR ARQUIVO] : " + file.getName(), e);
				try {
					FileUtils.moveFile(file, new File(dirERR, file.getName()));
				} catch (IOException e1) {
					log.error("[ERRO AO MOVER ARQUIVO] : " + file.getName(), e);
				}
			}
		}
	}

	private File getFile() {
		File file = null;
		if (dirIN.listFiles().length > 0) {
			file = dirIN.listFiles()[0];
		}
		return file;
	}

}
