public class Cozinha extends Garcom{

    private boolean pronto;
    private Garcom entregarPedido;

    public Cozinha(){
        this.setPronto(false);
    }

    protected Garcom getEntregarPedido() {
        return entregarPedido;
    }
    protected void setEntregarPedido(Garcom entregarPedido) {
        this.entregarPedido = entregarPedido;
    }
    protected boolean getPronto() {
        return pronto;
    }
    protected void setPronto(boolean pronto) {
        this.pronto = pronto;
    }

    protected void mostrarPedidoPainel(){
        if (getMandarCozinha()){
            mostrarPedido();
        } else {
            System.out.println("Aguardando Pedido ser enviado...");
        }
    }
    protected void statusPedido(){
        if (getPronto()){
            System.out.println("Pedido pronto");
            this.setPronto(true);
            this.entregarPedido.entregue();
        } else {
            System.out.println("Pedido em preparo...");
            this.setPronto(false);
            this.entregarPedido.entregue();
        }
    }
}
