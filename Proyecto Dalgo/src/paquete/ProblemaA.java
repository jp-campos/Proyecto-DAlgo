package paquete;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemaA {

	public boolean cumpleCondicion(int[] numeros, int apuntadorI, int apuntadorF) {
		boolean cumple = false;
		int[] contendor = Arrays.copyOfRange(numeros, apuntadorI, apuntadorF);
		int contador = 0;
		for (int i = 0; i < contendor.length && contador < 2; i++) {
			if (i!=0 && contendor[i-1]>contendor[i]) {
				contador++;
			}
		}
		if (contador <= 1) {
			cumple = true;
		}
//		System.out.println("Contendor "+Arrays.toString(contendor)+" es "+ cumple);
		return cumple; 
	}
	public int subArregloAsc (int n, int[] numeros)
	{
		int longitudParcial = 0;
		int longitudFinal = 0;
		int apuntadorInicio = 0;
		int apuntadorFinal = 0;
		boolean brek = true;
		for (int i = 1; i <= numeros.length && brek; i++) {
//			System.out.println("I es "+ i);
			int[] contendor = Arrays.copyOfRange(numeros, apuntadorInicio, apuntadorFinal+1);
//			System.out.println("Arreglo entrante "+ Arrays.toString(contendor));
			
			if (i != numeros.length-1) {
				if (cumpleCondicion(numeros, apuntadorInicio, apuntadorFinal+1) ) {
					
					longitudParcial = longitudParcial + 1;
					if (longitudParcial > longitudFinal) {
						apuntadorFinal = i;
						longitudFinal = longitudParcial;
					}
				}
				else if (!cumpleCondicion(numeros, apuntadorInicio, apuntadorFinal+1)) {
//					System.out.println("Entro "+ numeros);
					longitudParcial = 0;
					apuntadorInicio = i;
					apuntadorFinal = i;
					brek = false;
				}
			}
			else if (i == numeros.length-1) {
				if (cumpleCondicion(numeros, apuntadorInicio, apuntadorFinal) ) {
//					System.out.println("Este arreglo entro al if == si esta last "+ Arrays.toString(contendor));
					longitudParcial = longitudParcial + 1;
					if (longitudParcial > longitudFinal) {
						apuntadorFinal = i;
						longitudFinal = longitudParcial;
					}
				}
				else if (!cumpleCondicion(numeros, apuntadorInicio, apuntadorFinal)) {
//					System.out.println("Entro "+ numeros);
					longitudParcial = 0;
					apuntadorInicio = i;
					apuntadorFinal = i;
					brek = false;
				}
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