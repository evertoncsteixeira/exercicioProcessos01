package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class RedesController {
	public RedesController() {
		super();
	}
	
	public String ip ( String os) {
		String processo = "";
		if (os.contains("Windows")) {
			 processo = "ipconfig";
		} else {
			processo = "ifconfig";
		}
		 try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream(); 
			    InputStreamReader leitor = new InputStreamReader(fluxo);
			    BufferedReader buffer = new BufferedReader(leitor);
			    String linha = buffer.readLine();
			    String adaptador = "";
			    StringBuffer bufferAdap = new StringBuffer();
			    while (linha != null) {
			    	if (linha.contains("Adaptador")) {
			    		adaptador = linha;
			    	}
			    	if (linha.contains("IPv4")) {
			    		bufferAdap.append(adaptador);
			    		bufferAdap.append(linha);
			    		bufferAdap.append(" ");
			    	}
			    			    	
			    	linha = buffer.readLine();
			    }
			    
			    os = bufferAdap.toString();
			    buffer.close();
			    leitor.close();
			    fluxo.close();
			 } catch (IOException e) {
				
				e.printStackTrace();
			}
		return os;
	}
	
	public String ping ( String os) {
		String processo = "";
		if (os.contains("Windows")) {
			 processo = "ping -n 10 www.google.com";
		} else {
			processo = "ping www.google.com";
		}
		 try {
				Process p = Runtime.getRuntime().exec(processo);
				InputStream fluxo = p.getInputStream(); 
			    InputStreamReader leitor = new InputStreamReader(fluxo);
			    BufferedReader buffer = new BufferedReader(leitor);
			    String linha = buffer.readLine();
			    StringBuffer bufferAdap = new StringBuffer();
			    while (linha != null) {
			    	if (os.contains("Windows")) {
			    		if (linha.contains("dia = ")) {
			    			bufferAdap.append(linha.substring(linha.lastIndexOf("=")+1,linha.length()).trim());
			    			bufferAdap.append(" ");
			    		}
			    	   	System.out.println(linha);
			    	   	linha = buffer.readLine();
			    	} else {
			    		if (linha.contains("dia = ")) {
			    			bufferAdap.append(linha.substring(linha.lastIndexOf("=")+1,linha.length()).trim());
			    			bufferAdap.append(" ");
			    		}
			    	   	System.out.println(linha);
			    	   	linha = buffer.readLine();
			    	}
			    }
			    
			    os = bufferAdap.toString();
			    buffer.close();
			    leitor.close();
			    fluxo.close();
			 } catch (IOException e) {
				
				e.printStackTrace();
			}
		return os;
	}
}
