/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arreglos_emilio;
import java.util.Scanner;
import java.util.Random;
/** 
 *
 * @author Emilio Cantarero
 */
public class Arreglos_Emilio {
    static Scanner lea=new Scanner (System.in);
    static Random r=new Random();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tam;
        char resp='s';
        int opc;
        while (resp=='s'||resp=='S'){
            
            System.out.println("Ingrese el tamaño: ");
            tam=lea.nextInt();
            int numeros2 []=llenarArregloRandom(tam);
            System.out.println("---Lista de Opciones---");
            System.out.println("1. suma");
            System.out.println("2. Mayor");
            System.out.println("3. Arreglo de pares");
            System.out.println("4. Arreglo de primos");
            System.out.println("5. Suma entre arreglos");
            System.out.println("6. Ordenamiento");
            System.out.println("7. Busqueda lineal");
            System.out.println("8. Busqueda binaria");
            System.out.println("Ingrese la opcion: ");
            opc=lea.nextInt();
            
            switch (opc){
                case 1: 
                    System.out.println("Arreglo Original: ");
                    imprimirArreglo(numeros2);
                    System.out.println("");
                    System.out.println("La suma del arreglo es: " + suma(numeros2));
                    
                    break;
                case 2:
                    System.out.println("Arreglo Original: ");
                    imprimirArreglo(numeros2);
                    System.out.println("");
                    System.out.println("El elemento mayor es: " + mayor(numeros2));
                    break;
                case 3:
                    System.out.println("Arreglo Original: ");
                    imprimirArreglo(numeros2);
                    System.out.println("");
                    if (arregloDePares(numeros2)==null){
                        
                    }else{
                        System.out.println("---Arreglo de Pares---");
                        imprimirArreglo(arregloDePares(numeros2));
                    }
                    break;
                case 4:
                    System.out.println("---Arreglo Original---");
                    imprimirArreglo(numeros2);
                    System.out.println("");
                    if (arregloPrimos(numeros2)==null){
                        
                    }else{
                        System.out.println("---Arreglo de Primos---");
                        imprimirArreglo(arregloPrimos(numeros2));
                    }
                    break;
                case 5:
                    System.out.println("---Arreglo 1---");
                    int []conjunto1=llenarArregloRandom(tam);
                    imprimirArreglo(conjunto1);
                    
                    System.out.println("---Arreglo 2---");
                    int []conjunto2=llenarArregloRandom(tam);
                    imprimirArreglo(conjunto2);
                    
                    System.out.println("---Arreglo 3---");
                    int []conjunto3=llenarArregloRandom(tam);
                    imprimirArreglo(conjunto3);
                    
                    System.out.println("---Arreglo Final---");
                    imprimirArreglo(sumaEntreArreglos(conjunto1, conjunto2, conjunto3));
                    break;
                    
                case 6: 
                    System.out.println("---Arreglo Original---");
                    imprimirArreglo(numeros2);
                    System.out.println("---Arreglo Ordenado---");
                    imprimirArreglo(ordenamiento(numeros2));
                    break;
                case 7:
                    System.out.println("---Arreglo Original---");
                    imprimirArreglo(numeros2);
                    System.out.println("Ingrese el elemento que desea buscar: ");
                    int valorB=lea.nextInt();
                    if (busquedaLineal(numeros2, valorB)==true){
                        System.out.println("El elemento si se encuentra en el arreglo.");
                    }else{
                        System.out.println("El elemento no se encuentra en el arreglo.");
                    }
                    break;
                
                case 8:
                    System.out.println("---Arreglo Original---");
                    int [] busqueda={2, 21, 21, 34, 44, 49, 54, 61, 72, 81};
                    imprimirArreglo(busqueda);
                    System.out.println("");
                    System.out.println("Ingres el elemento que desea buscar: ");
                    int valorBuscado=lea.nextInt();
                    int ultimo=numeros2.length-1;
                    if (busquedaBinaria(busqueda, 0, ultimo, valorBuscado)==true){
                        System.out.println("El elemento si se encuentra en el arreglo.");
                    }else{
                        System.out.println("El elemento no se encuentra en el arreglo.");
                    }
                    break;

            }

            System.out.println("Desea continuar? s/n: ");
            resp=lea.next().charAt(0);
        }
    }
    public static int[] llenarArreglo(int tam){
       int []numeros=new int [tam]; 
        for (int i=0; i<numeros.length; i++){
            System.out.println("Ingrese el valor en la posicion: " + i);
            numeros[i]=lea.nextInt();
        }
       return numeros;
    }
    public static void imprimirArreglo(int []numeros){

        for (int i=0; i<numeros.length; i++){
            System.out.print (numeros[i] + "  ");
        }
    }
    public static int[] llenarArregloRandom(int tam){
        int []numerosRandom=new int[tam];
        for (int i=0; i<numerosRandom.length; i++){
            numerosRandom[i]=1+r.nextInt(90);
        }
       return numerosRandom;
    }
    public static int suma(int [] numeros2){
        int s=0;
        for (int i=0; i<numeros2.length; i++){
            s+=numeros2[i];
        }
        return s;
    }
    public static int mayor(int []numeros2){
        int m=0;
        for (int i=0; i<numeros2.length; i++){
            if (numeros2[i]>m){
                m=numeros2[i];
            }
        }
        return m;
    }
    public static int []arregloDePares(int []numeros2){
        int contadorPares=0;
        for(int i=0; i<numeros2.length; i++){
            if (numeros2[i]%2==0){
                contadorPares++;
            }
        }
        if (contadorPares==0){
            System.out.println("No se encontró ningun numero par en el arreglo original.");
        }else{
            int []numerosPares=new int [contadorPares];
            int j=0;
            for(int i=0; i<numeros2.length; i++){
                if (numeros2[i]%2==0){
                    numerosPares[j]=numeros2[i];
                    j++;
                }
            }
        return numerosPares;
        }
        return null;
    }
    public static int[] arregloPrimos(int numeros2[]){
        int contadorPrimos=0;
        for (int i=0; i<numeros2.length;i++){
            if (esPrimo(numeros2[i])==true){
                contadorPrimos++;
            }
        }
        if (contadorPrimos==0){
            System.out.println("No se encontro ningun numero primo en el arreglo original.");
        }else{
            int []numerosPrimos=new int [contadorPrimos];
            int j=0;
            for (int i=0; i<numeros2.length;i++){
                if (esPrimo(numeros2[i])==true){
                    numerosPrimos[j]=numeros2[i];
                    j++;
                }
            }
            return numerosPrimos;
        }
        return null;
    }
    public static boolean esPrimo(int x){
        int contadorDivisores=0;
        for (int i=1; i<=x; i++){
            if (x%i==0){
                contadorDivisores++;
            }
        } 
        if (contadorDivisores!=2){
            return false;
        }
        return true;
    }
    public static int [] sumaEntreArreglos(int []conjunto1, int []conjunto2, int[]conjunto3){
        int []conjuntoTemp=new int [conjunto1.length];
        int length=0;
        for (int i=0; i<conjunto1.length; i++){
            conjuntoTemp[i] = conjunto1[i]+conjunto2[i];
            length++;
        }
        int []arregloFinal=new int [conjunto1.length];
        for (int i=0; i<conjunto1.length; i++){
            arregloFinal[i]=conjuntoTemp[i]+conjunto3[length-1];
            length--;
        }
        return arregloFinal;
    }
    public static int[] ordenamiento(int []arr){
        int pos, aux;
        for (int i=0; i<arr.length; i++){
            pos=i;
            aux=arr[i];
            while (pos>0 && arr[pos-1]>aux){
                arr[pos]=arr[pos-1];
                pos--;
            }
            arr[pos]=aux;
        }
        return arr;
    }
    public static boolean busquedaLineal(int []numeros2, int valorB){
        for (int i=0; i<numeros2.length; i++){
            if (numeros2[i]==valorB){
                return true;
            }
        }
        return false;
    }
    
    public static boolean busquedaBinaria(int arr[], int primero, int ultimo, int valorBuscado){
        boolean resultado = false;
        int medio = (primero + ultimo)/2;  
        while( primero <= ultimo ){  
            if ( arr[medio] < valorBuscado ){  
             primero = medio + 1;     
            }else if ( arr[medio] == valorBuscado ){  
                resultado=true;
             break;  
            }else{  
              ultimo = medio - 1;  
            }  
            medio = (primero + ultimo)/2;  
        }  
        if ( primero > ultimo ){ 
            resultado = false;
        }  
        return resultado;
 }  
  
}
