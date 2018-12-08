package paquete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemaB {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ProblemaB instancia = new ProblemaB();
		try ( 
			InputStreamReader is= new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
		) { 
			String line = br.readLine();
				
			while(line!=null && line.length()>0 && !"0 0".equals(line)) {
				
				
				String[] numeros = line.split(" ");
				int n = Integer.parseInt(numeros[0]);
				int capitalInicial = Integer.parseInt(numeros[1]);
//				System.out.println(n+" "+capitalInicial);
				
				line = br.readLine();
				String[] dataStr = line.split(" ");
				int[] rA = Arrays.stream(dataStr).mapToInt(f->Integer.parseInt(f)).toArray();
//				System.out.println(Arrays.toString(rA));

				line = br.readLine();
				String[] dataStri = line.split(" ");
				int[] rB = Arrays.stream(dataStri).mapToInt(f->Integer.parseInt(f)).toArray();
//				System.out.println(Arrays.toString(rB));
			
				line = br.readLine();
				System.out.println(maximoCapital(n,capitalInicial, rA,rB));
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public static int maximoCapital (int n, int inicialCapital, int[] rA, int[] rB)
	{
		int max = inicialCapital;
		for (int i = 0; i < n; i++) {
			System.out.println("rA en "+i+" es "+rA[i]);
			System.out.println("rB en "+i+" es "+rB[i]);
			System.out.println("El mayor es "+java.lang.Math.max(rA[i], rB[i]));
			int maxR = java.lang.Math.max(rA[i], rB[i]);
			System.out.println("El maxGanado es "+nuevoCapital(max, maxR));
			max = nuevoCapital(max, maxR);
		}

		return max; 
	}
	
	public static int nuevoCapital(int capitalInvertido, int bolsaValor) {
		int ganancia = capitalInvertido*((1+bolsaValor)/100);
		int nuevoCapital = capitalInvertido + ganancia;
		return nuevoCapital;
	}
	

}