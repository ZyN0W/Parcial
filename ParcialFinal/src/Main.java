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
		
		int salir,nroVenta=0;
	
		do {
			System.out.println(nroVenta);
			nroVenta ++;
			RealizarVenta(cafes,Ventas,nroVenta);
			
	
			
			salir=Integer.parseInt(JOptionPane.showInputDialog("Si desea salir pulse 1 \nSi desea continuar pusle cualquier numero"));
		} while (salir==1);
		
		CafeVendido(Ventas,cafes);
		
		

	}
	
	public static void RealizarVenta (LinkedList<Cafe> cafes, LinkedList<Venta> Ventas, int nroVenta ) {
		
		int op, cant, op1=0;
		double precio;
		
		op=Integer.parseInt(JOptionPane.showInputDialog("Bienvenido! Que cafe desea llevar ? "+"\n1-Latte"+"\n2-Flat White" +"\n3-Lagrima"+"\n4-Expresso"));
		op= op-1;
		cant=Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad"));
		precio=(cafes.get(op).getPrecio()*cant);
		op1=Integer.parseInt(JOptionPane.showInputDialog("Posee tarjeta de socio ?"+"\n1-Si"+"\n2-No"));
		if(op1==1) {
			precio=(cafes.get(op).getPrecio()*0.85);
			Ventas.add(new Venta(cafes.get(op),cant,true,precio));	
		}else {		
			Ventas.add(new Venta(cafes.get(op),cant,false,precio));		
		}
		
		
		
		
		
	}
	
	public static void MostrarVentas(LinkedList<Venta> Ventas) {
		if (Ventas.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hubo ventas");
		}else {
			for (Venta venta : Ventas) {
				JOptionPane.showMessageDialog(null, Ventas);
			}
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
	int latte=0, fw=0,lagrima=0,expreso=0;
	 
	for (Venta venta : Ventas) {
		if(venta.getCafe().getId()==1) {
			latte+=venta.getCantidad();			
			
		}else if(venta.getCafe().getId()==2){
			fw+=venta.getCantidad();
		
		}else if(venta.getCafe().getId()==3){
			lagrima+=venta.getCantidad();
			
		}else if(venta.getCafe().getId()==4){
			expreso+=venta.getCantidad();
			
		}
		
	}
	
	List<Integer> maximos=Arrays.asList(latte,fw,lagrima,expreso);
	
	 
	Collections.sort(maximos);
	JOptionPane.showMessageDialog(null, "El mas vendido es: "+  "Con la cantidad de: " + maximos.get(3) );
	

	
	
}

	
}

