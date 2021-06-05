package centroVacunacion;

public class Cargamento {
	Vacuna vacuna;
	int cantidad;
	Fecha fechaIngreso;
	Fecha fechaVencimiento;
	boolean estanVencidas;

	public Cargamento(Vacuna vacuna, int cantidad, Fecha fechaIngreso) {
		this.vacuna = vacuna;
		this.cantidad = cantidad;
		this.fechaIngreso = fechaIngreso;
		this.fechaVencimiento = calcularVencimiento(vacuna, fechaIngreso);
		estanVencidas = false;
	}

	public void seVencio() {
		estanVencidas = true;
	}

	public Fecha calcularVencimiento(Vacuna vac, Fecha fechaIngreso) {
		Fecha fechaVencimiento = new Fecha(fechaIngreso.dia(), fechaIngreso.mes(), fechaIngreso.anio());
		if (vac.duracionVacuna == null) {
			return null;
		}
		for (int i = 0; i < vac.duracionVacuna+1; i++) {
			fechaVencimiento.avanzarUnDia();
		}
		return fechaVencimiento;
	}

	@Override
	public String toString() {
		return "Cargamento [vacuna=" + vacuna + ", cantidad=" + cantidad + ", fechaIngreso=" + fechaIngreso
				+ ", fechaVencimiento=" + fechaVencimiento + ", estanVencidas=" + estanVencidas + "]";
	}

	
	
}
