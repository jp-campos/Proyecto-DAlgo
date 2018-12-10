package paquete;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;


/**
 * 
 * @author Juan Pablo Campos
 * @author Santiago Beltrán
 *
 */

public class ProblemaB {


	

	public ArrayList<Integer> construirMatriz(int n, int [] A, int [] B)
	{
		int [][] m = new int [n][2]; 


		int [][] sel = new int [n][2];

		int bn = B[n-1] > 0 ? B[n-1] : 0 ; 
		int an = A[n-1] > 0 ? A[n-1] : 0 ;

		m[n-1][0] = Math.max(an, bn); 
		m[n-1][1] = bn > 0 ? bn : 0 ; 

		
		sel[0][0] = A[0]; 
		sel[0][1] = B[0]; 
		
		sel[n-1][0] = Math.max(A[n-1], B[n-1]) == A[n-1] ? A[n-1] : B[n-1]; 
		sel[n-1][1] = B[n-1] > 0 ? B[n-1] : 0 ;

		ArrayList<Integer>selA = new ArrayList<>();  
		  
		
		

		for (int i = n-2; i > -1; i--) {


			int bi = B[i] > 0 ? B[i] : 0 ; 
			int ai = A[i] > 0 ? A[i] : 0 ;


			int b = bi + m[i+1][0]; 
		
			int a = ai + m[i+1][1]; 

			if(i == 0 )
			{
				m[i][0] = a;
				m[i][1] = Math.max(bi  + m[i+1][0], bi  + m[i+1][1]); 
				
			
 
			}else { 
				
				sel[i][0] = Math.max(a, b) ==a ? ai: bi; 
				sel[i][1] = bi; 
				
				m[i][0] = Math.max(a, b);

				m[i][1] = bi + m[i+1][0]; 

				 
			}

		}
		boolean b = false;  
		for (int i = 0; i < n; i++) {

			int aAgregar = 0;
		//System.out.println(sel[i][0] + " " + sel[i][1]);
			
			if(!b)
			{
				int max=  Math.max(m[i][0], m[i][1]); 
				
				if(max == m[i][0])
				{
					aAgregar = sel[i][0]; 
					b = true; 
				}else
				{
					aAgregar = sel[i][1]; 
				}
				
			}else
			{
				aAgregar = sel[i][1]; 
				
				b=false; 
				
			}
			
			selA.add(aAgregar); 
		}


		return selA; 

	}


		
	public int maximoCapital (int n, int inicialCapital, int[] rA, int[] rB)
	{
		int capitalActual = inicialCapital;

		ArrayList<Integer> sel = construirMatriz(n, rA, rB);


				for (int i = 0; i < n; i++) {
					
					capitalActual = nuevoCapital(capitalActual, sel.get(i));
				}

		return capitalActual; 
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

			
			ArrayList<Integer> r = new ArrayList<>(); 
			
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
				r.add(instancia.maximoCapital(n,capitalInicial, rA,rB));
			}
			
			for (Integer integer : r) {
				
				System.out.println(integer);
			}
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}



}