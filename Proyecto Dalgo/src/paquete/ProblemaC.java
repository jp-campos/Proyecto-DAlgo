package paquete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * @author Juan Pablo Campos
 * @author Santiago Beltrán
 *
 */

public class ProblemaC {

	
	
	public int voe(int n, int[] sensores)
	{

		int a = sensores[0]; 
		int b = sensores[1];
		
		for (int i = 2; i < sensores.length; i+= 2) {
			
			int c = sensores[i]; 
			int d = sensores [i+1]; 
			
			
			if (a > d || b < c) {
			    
				continue; 
			}
			else {
				a = Math.max(a, c);
				b = Math.min(b, d); 
				
			}
		}

		return (a+b)/2; 
	}
	
	

		
	
	
	public static void main(String[] args) {
		

		ProblemaC instancia = new ProblemaC();
		try ( 
			InputStreamReader is= new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
		) { 
			String line = br.readLine();
				
			while(line!=null && line.length()>0 && !"0".equals(line)) {
				
				
				int n = Integer.parseInt(line); 
				
				line = br.readLine();
				
				final String [] dataStr = line.split(" ");
				final int[] numeros = Arrays.stream(dataStr).mapToInt(f->Integer.parseInt(f)).toArray();
				
				
				
				System.out.println(instancia.voe(n, numeros)); 
			 
				
			
				line = br.readLine();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

		

	}

}
