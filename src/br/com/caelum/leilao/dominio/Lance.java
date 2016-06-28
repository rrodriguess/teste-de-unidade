package br.com.caelum.leilao.dominio;

public class Lance {

	private Usuario usuario;
	private double valor;
	
	public Lance(Usuario usuario, double valor) {
		this.usuario = usuario;
		this.valor = valor;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public double getValor() {
		return valor;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Lance lance = (Lance) o;

		if (Double.compare(lance.valor, valor) != 0) return false;
		return usuario != null ? usuario.equals(lance.usuario) : lance.usuario == null;

	}

	@Override
	public int hashCode() {
		int result;
		long temp;
		result = usuario != null ? usuario.hashCode() : 0;
		temp = Double.doubleToLongBits(valor);
		result = 31 * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
}
