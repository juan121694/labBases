import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;
import java.util.ArrayList;
import java.util.Stack;
//import com.csvreader.CsvReader;
//author:Alfaro Jimenez Juan Adolfo

public class Consulta {
    public static void main(String[] args) {
        Cliente arregloClientes[]= new Cliente[100];
        Cliente arregloClientesMargen[] = new Cliente[100];
        int numPropiedades=0;
        Stack<String> clienteProp= new Stack<String>();
        String margenGanancia;
        String nom1="";
        int caras=0;
        String nom2="";
        int contador=0;
        try {
         
        CsvReader mi_csv = new CsvReader("/home/juan/Documentos/labBases/labBases/REPO GIT/Practica01/P1.csv"); //Cambien a la ruta de su archivo
        mi_csv.readHeaders(); // Leemos las Cabeceras, las cuales nos dan informacion de cada campo
         
        while (mi_csv.readRecord())
        {
            String nombre = mi_csv.get(0);
            String tel = mi_csv.get(1);
            String direccion = mi_csv.get(2);
            String correo = mi_csv.get(3);
            String m2 = mi_csv.get(4);
            String val_prop = mi_csv.get(5);
            String val_venta = mi_csv.get(6);  
            arregloClientes[contador]= new Cliente(nombre,tel,direccion,correo,m2,val_prop,val_venta);
            double margen=Double.parseDouble(val_venta)-Double.parseDouble(val_prop);
            margenGanancia=String.valueOf(margen);
            arregloClientesMargen[contador]= new Cliente(nombre,tel,direccion,correo,m2,val_prop,val_venta,margenGanancia);
            double metros=0;
            double valor=0;
            metros=Double.parseDouble(arregloClientes[contador].getMetrosPropiedad());
            valor=Double.parseDouble(arregloClientes[contador].getValorVenta());
            if(metros==200.0 && valor>50000 && valor<500000){
                numPropiedades=+1;
            }
            contador+=1;
        }

        System.out.println("\nNumero de Propiedades de 200 m2 y que valen entre $50,000 y 500,000 = "+numPropiedades+"\n");
        System.out.println("\nClientes con mas de una propiedad: \n");

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(i!=j && (clienteProp.search(arregloClientes[j].getNombre()))==-1 && arregloClientes[i].getNombre().equals(arregloClientes[j].getNombre())){
                    System.out.println(clienteProp.push(arregloClientes[j].getNombre()));
                    j=100;
                }
            }
        } 

        Cliente apuntador = new Cliente("","","","","","","");
        for(int k=1; k<100; k++){
            for(int l=0; l<99; l++){
                if(Double.parseDouble(arregloClientes[l].getValorVenta())>Double.parseDouble(arregloClientes[l+1].getValorVenta())){
                    apuntador = arregloClientes[l];
                    arregloClientes[l]=arregloClientes[l+1];
                    arregloClientes[l+1]=apuntador;
                }
                if(l==98 && k==99){
                    System.out.println("\nlas 10 casas mas baratas son:\n");
    
                    for(int m=0; m<15; m++){
                        if(m<10){
                            System.out.println("Numero "+(m+1));
                            System.out.println("Nombre: "+arregloClientes[m].getNombre());
                            System.out.println("Télefono: "+arregloClientes[m].getTelefono()); 
                            System.out.println("Dirección: "+arregloClientes[m].getDireccion());             
                            System.out.println("Correo: "+arregloClientes[m].getCorreo());     
                            System.out.println("Metros Cuadrados: "+arregloClientes[m].getMetrosPropiedad()+" m^²"); 
                            System.out.println("Valor de la Propiedad: $"+arregloClientes[m].getValorPropiedad()); 
                            System.out.println("Valor para Venta: $"+arregloClientes[m].getValorVenta());
                            System.out.println("/***********************************/\n");
                        }
                        if(m>=10){
                            if(m==10){
                                System.out.println("\nLas cinco propiedades mas caras:\n");
                            }
                            System.out.println("Numero "+(caras+1));
                            System.out.println("Nombre: "+arregloClientes[99-caras].getNombre());
                            System.out.println("Télefono: "+arregloClientes[99-caras].getTelefono()); 
                            System.out.println("Dirección: "+arregloClientes[99-caras].getDireccion());             
                            System.out.println("Correo: "+arregloClientes[99-caras].getCorreo());     
                            System.out.println("Metros Cuadrados: "+arregloClientes[99-caras].getMetrosPropiedad()+" m^²"); 
                            System.out.println("Valor de la Propiedad: $"+arregloClientes[99-caras].getValorPropiedad()); 
                            System.out.println("Valor para Venta: $"+arregloClientes[99-caras].getValorVenta());
                            System.out.println("/***********************************/\n");
                            caras=caras+1;
                        }
                    }
                }
            }
        }         

        Cliente margen = new Cliente("","","","","","","","");
        for(int n=1; n<100; n++){
            for(int o=0; o<99; o++){
                if(Double.parseDouble(arregloClientesMargen[o].getMargenGanancia())>Double.parseDouble(arregloClientesMargen[o+1].getMargenGanancia())){
                    margen = arregloClientesMargen[o];
                    arregloClientesMargen[o]=arregloClientesMargen[o+1];
                    arregloClientesMargen[o+1]=margen;
                }
                if(n==99 && o==98){
                    System.out.println("\nLas 5 propiedades con un margen mayor son:\n");
                    for(int q=0; q<5; q++){
                        System.out.println("Numero "+(q+1));
                        System.out.println("Nombre: "+arregloClientesMargen[99-q].getNombre());
                        System.out.println("Télefono: "+arregloClientesMargen[99-q].getTelefono()); 
                        System.out.println("Dirección: "+arregloClientesMargen[99-q].getDireccion());             
                        System.out.println("Correo: "+arregloClientesMargen[99-q].getCorreo());     
                        System.out.println("Metros Cuadrados: "+arregloClientesMargen[99-q].getMetrosPropiedad()+" m^²"); 
                        System.out.println("Valor de la Propiedad: $"+arregloClientesMargen[99-q].getValorPropiedad()); 
                        System.out.println("Valor para Venta: $"+arregloClientesMargen[99-q].getValorVenta());
                        System.out.println("Margen de ganancia $"+arregloClientesMargen[99-q].getMargenGanancia());
                        System.out.println("/***********************************/\n");    
                    }
                }
            }
        }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}