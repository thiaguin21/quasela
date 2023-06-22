public class Cozinha extends Garcom{

    public void statusPedido(){
        int preparo;
        for(preparo = 1; preparo <= 11; preparo++){
            if (preparo == 11){
                System.out.println("Pedido pronto");
                this.setPedidoPronto(true);
                this.entregue();
                break;
            } else {
                System.out.println(preparo + " minutos se passaram.");
                System.out.println("Pedido em preparo...\n");
                this.setPedidoPronto(false);
                this.entregue();
            }
        }
    }
}
