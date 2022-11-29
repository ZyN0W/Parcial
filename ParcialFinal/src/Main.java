import java.util.*;

import javax.swing.JOptionPane;

public class Main {

	public static void main(String[] args) {
		
		Cafe latte = new Cafe ("Latte",1.50,1);
		Cafe Fw =  new Cafe ("Flat White",2.50,2);
		Cafe lagrima = new Cafe ("Lagrima", 1.30,3);
		Cafe expresso = new Cafe ("Expresso",1,4);
		
		LinkedList<Cafe> cafes = new LinkedList <Cafe>();
		cafes.add(latte);
		cafes.add(Fw);
		cafes.add(lagrima);
		cafes.add(expresso);
		LinkedList<Venta> Ventas = new LinkedList <Venta>();
		int cerrar;
		//para probar es mejor comentar la linea de la 21 a 25
		System.out.println("id =  2022 contra = 1010");
		JOptionPane.showMessageDialog(null, "Bienvenido, Registrese");
		IngresoEncargado();
		JOptionPane.showMessageDialog(null, "Ya puede operar");
		RealizarVenta(cafes,Ventas);
		JOptionPane.showMessageDialog(null, "Caja cerrada");
		do {
			
			int op = Integer.parseInt(JOptionPane.showInputDialog("Las opciones sobre revision de ventas son las siguientes \n1-Ver todas las ventas"
					+ "\n2-Ventas con descuento \n3-Recaudacion total \n4-Cafe mas vendido \n5-Eliminar venta erronea"));
			switch (op) {
			case 1:
				MostrarVentas(Ventas);
				break;
             case 2:
            	 VentasDesc( Ventas);
				break;
             case 3:
 				Recaudacion(Ventas);
 				break;
             case 4:
 				CafeVendido(Ventas,cafes);
 				break;
             case 5:
 				Remove(Ventas);
 				break;


			default:
				break;
			}
			
			cerrar=Integer.parseInt(JOptionPane.showInputDialog("Otra operacion? \n1-Si \n2-No"));
			
			
		} while (cerrar==1);
	
	    
			
	
			
		

	}
	public static void  IngresoEncargado(  ) {
		//id =  2022 contra = 1010
		int exitoso=0; // ingreso exitoso
		String nom;
		int id, con;
		nom=JOptionPane.showInputDialog("Ingrese su nombre");
		Encargado e1 = new Encargado (nom);		
		do {	
		 id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su id"));
		 con = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su Clave"));
			
				
			if (id== e1.getId() && con == e1.getContra()) {

		JOptionPane.showMessageDialog(null, "Usuario: " + e1.getNombre() + " Ingreso correctamente ");
				exitoso = 0;				
			}else if (id != e1.getId() ) {
				JOptionPane.showInputDialog("Id Incorrecto, ingreseselo otra vez ");
				exitoso = 1;
			}else if (con != e1.getContra()) {				
				JOptionPane.showInputDialog("Contra Incorrecta, ingresesela otra vez ");
				exitoso = 1;
			}									
		} while ( exitoso == 1);
	}
	
	public static void RealizarVenta (LinkedList<Cafe> cafes, LinkedList<Venta> Ventas) {
		
		int op, cant, op1=0, salir, nroVenta=0;
		double precio;
		do {
			System.out.println(nroVenta);
			nroVenta ++;
		op=Integer.parseInt(JOptionPane.showInputDialog("Bienvenido! Que cafe desea llevar ? "+"\n1-Latte"+"\n2-Flat White" +"\n3-Lagrima"+"\n4-Expresso"));
		op= op-1;
		cant=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad"));
		precio=(cafes.get(op).getPrecio()*cant);
		op1=Integer.parseInt(JOptionPane.showInputDialog("Posee tarjeta de socio ?"+"\n1-Si"+"\n2-No"));
		if(op1==1) {
			precio=((cafes.get(op).getPrecio()*cant)*0.85);
			Ventas.add(new Venta(cafes.get(op),cant,true,precio,nroVenta));	
		}else {		
			Ventas.add(new Venta(cafes.get(op),cant,false,precio,nroVenta));		
		}
		salir=Integer.parseInt(JOptionPane.showInputDialog("Si desea seguir pulse 1 \nPara salir pusle cualquier numero"));
		} while (salir==1);
										
		
	}
	
	public static void MostrarVentas(LinkedList<Venta> Ventas) {
		if (Ventas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hubo ventas");
		}else {
			JOptionPane.showMessageDialog(null, Ventas);
				
			}
		}
		
	
	
	public static void VentasDesc(LinkedList<Venta> Ventas) {
		LinkedList<Venta> VentasDesc = new LinkedList <Venta>();
		
		for (Venta venta : Ventas) {
			if (venta.isTarjeta()==true) {
				VentasDesc.add(venta);				
			}		
		}
		
		JOptionPane.showMessageDialog(null, VentasDesc);
	}	



    public static void Recaudacion (LinkedList<Venta> Ventas) {
	double total=0;
	for (Venta venta : Ventas) {
		total+=venta.getPrecio();
		
	}
	JOptionPane.showMessageDialog(null, "La recaudacion total: $"+ total);
}
	


public static void CafeVendido(LinkedList<Venta> Ventas, LinkedList<Cafe> cafes ) {
	
	 
	for (Venta venta : Ventas) {
		if(venta.getCafe().getId()==1) {
			cafes.get(0).setCant_total(cafes.get(0).getCant_total()+venta.getCantidad());	
			
		}else if(venta.getCafe().getId()==2){
			cafes.get(1).setCant_total(cafes.get(1).getCant_total()+venta.getCantidad());
		
		}else if(venta.getCafe().getId()==3){
			cafes.get(2).setCant_total(cafes.get(2).getCant_total()+venta.getCantidad());
			
		}else if(venta.getCafe().getId()==4){
			cafes.get(3).setCant_total(cafes.get(3).getCant_total()+venta.getCantidad());
			
		}
		
	}
	
	Comparator <Cafe> MaximoVendido = Comparator.comparing(Cafe::getCant_total);
    Collections.sort(cafes, MaximoVendido.reversed());
    JOptionPane.showMessageDialog(null, "El cafe mas vendido fue el siguiente: " + cafes.get(0).getNombre() + "\n Con un total de: " + cafes.get(0).getCant_total() + " Unidades vendidas");
	
	
}
public static void Remove(LinkedList<Venta> Ventas) {
	MostrarVentas(Ventas);
	int borrar ;
	borrar=Integer.parseInt(JOptionPane.showInputDialog("Seleccion el ID de la venta a eliminar"));
	for (Venta venta : Ventas) {
		if (Ventas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hubo ventas");
		} else if (venta.getId()==borrar) { 				
			Ventas.remove(Ventas.indexOf(venta));
			JOptionPane.showMessageDialog(null, "Se removio la venta ID "+borrar+ " correctamente" );
		}
		
	}
	
	
	
}

}
	


