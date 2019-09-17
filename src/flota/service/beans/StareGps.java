package flota.service.beans;

import flota.service.enums.EnumStareGps;

public class StareGps {

	private String nrAuto;
	private String data;
	private EnumStareGps stareGps;

	public String getNrAuto() {
		return nrAuto;
	}

	public void setNrAuto(String nrAuto) {
		this.nrAuto = nrAuto;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public EnumStareGps getStareGps() {
		return stareGps;
	}

	public void setStareGps(EnumStareGps stareGps) {
		this.stareGps = stareGps;
	}

	@Override
	public String toString() {
		return "StareGps [nrAuto=" + nrAuto + ", data=" + data + ", stareGps=" + stareGps + "]";
	}

}
