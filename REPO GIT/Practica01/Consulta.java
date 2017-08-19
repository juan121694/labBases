import java.io.FileNotFoundException;
import java.io.IOException;
import com.csvreader.CsvReader;
import java.util.ArrayList;
import java.util.Stack;
//import com.csvreader.CsvReader;

public class Consulta {
    public static void main(String[] args) {
        Cliente arregloClientes[]= new Cliente[100];
        int numPropiedades=0;
        Stack<String> clienteProp= new Stack<String>();
        String nom1="";
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
            double metros=0;
            double valor=0;
            metros=Double.parseDouble(arregloClientes[contador].getMetrosPropiedad());
            valor=Double.parseDouble(arregloClientes[contador].getValorVenta());
            if(metros==200.0 && valor>50000 && valor<500000){
                numPropiedades=+1;
            }

            System.out.println("Registro leido");
            System.out.println("Nombre: "+nombre);
            System.out.println("Télefono: "+tel); 
            System.out.println("Dirección: "+direccion);             
            System.out.println("Correo: "+correo);     
            System.out.println("Metros Cuadrados: "+m2+" m^²"); 
            System.out.println("Valor de la Propiedad: $"+val_prop); 
            System.out.println("Valor para Venta: $"+val_venta);
            System.out.println("/***********************************/\n");
            System.out.println(arregloClientes[contador].getNombre());
            contador+=1;
            System.out.println(contador+"");
        }
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(i!=j && (clienteProp.search(arregloClientes[j].getNombre()))==-1 && arregloClientes[i].getNombre().equals(arregloClientes[j].getNombre())){
                    System.out.println(clienteProp.push(arregloClientes[j].getNombre()));
                    j=100;
                }
            }
        }
        System.out.println("Numero de Propiedades de 200 m2 y que valen entre $50,000 y 500,000 = "+numPropiedades);
         
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}