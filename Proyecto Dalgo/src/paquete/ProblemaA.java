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

public class ProblemaA {

	public int subArregloAsc (int n, int[] numeros)
	{
		int longitudParcial = 0;
		int longitudFinal = 0;
		int apuntadorInicio = 0;
		int apuntadorFinal = 0;
		int contador = 0;
		for (int i = 0; i < n ; i++) {
			if (i+1==n && contador<2) {
				longitudParcial++;
				if (longitudParcial > longitudFinal) {
					longitudFinal = longitudParcial;
				}
				apuntadorFinal = i;
			}
			if (contador < 2 && i+1<n) {
				if ( numeros[i]>numeros[i+1]) {
					contador ++;
					longitudParcial++;
					if (longitudParcial > longitudFinal) {
						longitudFinal = longitudParcial;
					}
					apuntadorFinal = i;
				}
				else if (numeros[i] <= numeros[i+1]) {
					longitudParcial++;
					if (longitudParcial > longitudFinal) {
						longitudFinal = longitudParcial;
					}
					apuntadorFinal = i;
				}
			}
			else if (contador>=2) {
				longitudParcial = 0;
				apuntadorInicio = i;
				apuntadorFinal = i;
				contador = 0;
			}
		}
		
		return longitudFinal; 
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
//				System.out.println("Arreglo entrante "+ Arrays.toString(numeros));

				
				System.out.println(instancia.subArregloAsc(n, numeros)); 
				
			
				line = br.readLine();
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		

	}
}