package pedidosfarmacia.unir.modelos;

public class Pedido {
    private String nombreMedicamento;
    private String tipoMedicamento;
    private Integer cantidad;
    private String distribuidor;
    private String farmacias;

    public Pedido() {
    }

    public Pedido(String nombreMedicamento, String tipoMedicamento, Integer cantidad, String distribuidor, String farmacias) {
        this.nombreMedicamento = nombreMedicamento;
        this.tipoMedicamento = tipoMedicamento;
        this.cantidad = cantidad;
        this.distribuidor = distribuidor;
        this.farmacias = farmacias;
    }

    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    public String getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(String tipoMedicamento) {
        this.tipoMedicamento = tipoMedicamento;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getDistribuidor() {
        return distribuidor;
    }

    public void setDistribuidor(String distribuidor) {
        this.distribuidor = distribuidor;
    }

    public String getFarmacias() {
        return farmacias;
    }

    public void setFarmacias(String farmacias) {
        this.farmacias = farmacias;
    }
}