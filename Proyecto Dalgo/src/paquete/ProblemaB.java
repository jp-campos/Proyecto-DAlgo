package paquete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ProblemaB {


	public int [][] m; 

	public void construirMatriz(int n, int [] A, int [] B)
	{
		m = new int [n][2]; 


		int [][] sel = new int [n][2];



		m[n-1][0] = Math.max(A[n-1], B[n-1]); 
		m[n-1][1] = B[n-1] > 0 ? B[n-1] : 0 ; 

		sel[n-1][0] = Math.max(A[n-1], B[n-1]) == A[n-1] ? A[n-1] : B[n-1]; 
		sel[n-1][1] = B[n-1] > 0 ? B[n-1] : 0 ;



		for (int i = n-2; i > -1; i--) {


			int bi = B[i] > 0 ? B[i] : 0 ; 
			int ai = A[i] > 0 ? A[i] : 0 ;


			int b = bi + m[i+1][0]; 

			int a = ai + m[i+1][1]; 


			sel[i][0] = a>b? ai: bi ; 



			if(i == 0 )
			{
				m[i][0] = a;
				m[i][1] = Math.max(bi  + m[i+1][0], bi  + m[i+1][1]); 
						
						
				
					sel[i][0] = ai; 
					sel[i][1] = bi; 
					
				
				
 
			}else {


				m[i][0] = Math.max(a, b);

				m[i][1] = bi + m[i+1][0]; 

				sel[i][1] = bi; 
			}





		}


		for (int i = 0; i < n; i++) {

			System.out.println(m[i][0] + " " + m[i][1]);
		}

		


	}

	public int maximoCapital (int n, int inicialCapital, int[] rA, int[] rB)
	{
		int max = inicialCapital;

		construirMatriz(n, rA, rB);


		//		for (int i = 0; i < n; i++) {
		//			System.out.println("rA en "+i+" es "+rA[i]);
		//			System.out.println("rB en "+i+" es "+rB[i]);
		//			System.out.println("El mayor es "+java.lang.Math.max(rA[i], rB[i]));
		//			int maxR = java.lang.Math.max(rA[i], rB[i]);
		//			System.out.println("El maxGanado es "+nuevoCapital(max, maxR));
		//			max = nuevoCapital(max, maxR);
		//		}

		return max; 
	}

	public static int nuevoCapital(int capitalInvertido, int bolsaValor) {

		double divi = bolsaValor/(double) 100; 

		double  ganancia = capitalInvertido*(1 + divi);


		return (int) Math.floor(ganancia);
	}



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
				System.out.println(instancia.maximoCapital(n,capitalInicial, rA,rB));
			}
		} catch (IOException e) {

			e.printStackTrace();
		}
	}



}