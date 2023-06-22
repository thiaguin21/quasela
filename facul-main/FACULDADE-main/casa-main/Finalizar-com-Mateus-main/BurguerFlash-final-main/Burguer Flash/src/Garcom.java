public class Garcom extends Cliente implements Pedido{

    private boolean pedidoPronto, mandarCozinha;

    protected boolean getMandarCozinha() {
        return mandarCozinha;
    }
    protected void setMandarCozinha(boolean mandarCozinha) {
        this.mandarCozinha = mandarCozinha;
    }
    protected boolean getPedidoPronto() {
        return pedidoPronto;
    }
    protected void setPedidoPronto(boolean pedidoPronto) {
        this.pedidoPronto = pedidoPronto;
    }

    public Garcom() {
        this.pedidoPronto = false;
        this.mandarCozinha = false;
    }

    @Override
    public void mostrarPedido() {
        System.out.println("\n==== PEDIDO ====");
        System.out.println("Hamburguer: " + this.getHamburguer());
        System.out.println("Bebida: " + this.getBebida());
        System.out.println("Acompanhamento: " + this.getAcompanhamento());
        System.out.println("Sobremesa: " + this.getSobremesa());
        System.out.println("Adicional Hamburguer: " + this.getAdicHam());
        System.out.println("Adicional Bebida: " + this.getAdicBeb());
        System.out.println("Adicional Batata: " + this.getAdicBat());
        System.out.println("Adicional Sorvete: " + this.getAdicSorv());
        this.setPrecoTotalCombo(getPrecoAcompanhamento() + getPrecoSobremesa() + getPrecoBebida() + getPrecoHamburguer());
        this.setPrecoTotalAdicionais(getPrecoAdicHam() + getPrecoAdicBeb() + getPrecoAdicBat() + getPrecoAdicSorv());
        this.setPrecoTotalPedido(getPrecoTotalCombo() + getPrecoTotalAdicionais());
        System.out.println("==== PREÇO ====");
        System.out.println("Preço combo: " + this.getPrecoTotalCombo());
        System.out.println("Preço Adicionais: " + this.getPrecoTotalAdicionais());
        System.out.println("Preço Pedido: " + this.getPrecoTotalPedido());

        this.setMandarCozinha(true);
    }
    protected void entregue(){
        if (getPedidoPronto()){
            System.out.println("Pegando pedido..." +
                    "Pedido entregue!");
        }else{
            System.out.println("Aguardando pedido a ficar pronto");
        }
    }
}