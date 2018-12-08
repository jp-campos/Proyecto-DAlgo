package paquete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemaA {

	
	public int subArregloAsc (int n, int [ ]numeros)
	{
	

		
		return 0; 
	}
	
	
	
	public static void main(String[] args) {
		
		ProblemaA instancia = new ProblemaA();
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
				
				
				System.out.println(instancia.subArregloAsc(n, numeros)); 
				
			
				line = br.readLine();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}
}
