public class Pagamento extends Garcom{

    protected void fecharConta(){
        this.setPrecoTotalCombo(getPrecoAcompanhamento() + getPrecoSobremesa() + getPrecoBebida() + getPrecoHamburguer());
        this.setPrecoTotalAdicionais(getPrecoAdicHam() + getPrecoAdicBeb() + getPrecoAdicBat() + getPrecoAdicSorv());
        this.setPrecoTotalPedido(getPrecoTotalCombo() + getPrecoTotalAdicionais());
        System.out.println("==== PREÇO ====");
        System.out.println("Preço combo: " + this.getPrecoTotalCombo());
        System.out.println("Preço Adicionais: " + this.getPrecoTotalAdicionais());
        System.out.println("Preço Pedido: " + this.getPrecoTotalPedido());
    }

}
