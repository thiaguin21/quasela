import java.util.Random;
import java.util.Scanner;

public class Garcom extends Cliente implements Pedido{

    Scanner scan = new Scanner(System.in);
    Random aleatorio = new Random();
    private boolean pedidoPronto;
    protected boolean getPedidoPronto() {
        return pedidoPronto;
    }
    protected void setPedidoPronto(boolean pedidoPronto) {
        this.pedidoPronto = pedidoPronto;
    }

    public Garcom() {
        this.pedidoPronto = false;

    }

    @Override
    public void mostrarPedido() {
        System.out.println("\n==== PEDIDO ====");
        System.out.println("Mesa: " + aleatorio.nextInt(1,10));
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
        System.out.println("\n\n\n");

        System.out.println("======PEDIDO ENVIADO A COZINHA======\n");

    }
    protected void entregue(){
        if (getPedidoPronto()){
            System.out.println("Pedido entregue!");
        }else{
            System.out.println("Aguardando pedido a ficar pronto");
        }
    }

    protected void fecharConta() {
        int fConta;
        int formaPagamento;
        do {
            System.out.println("""


                    Pode fechar a conta?
                    1- Sim
                    2- Não""");
            fConta = scan.nextInt();
            if (fConta == 1) {

                float comGarcom = getPrecoTotalPedido() / 10;
                this.setPrecoTotalCombo(getPrecoAcompanhamento() + getPrecoSobremesa() + getPrecoBebida() + getPrecoHamburguer());
                this.setPrecoTotalAdicionais(getPrecoAdicHam() + getPrecoAdicBeb() + getPrecoAdicBat() + getPrecoAdicSorv());
                this.setPrecoTotalPedido(getPrecoTotalCombo() + getPrecoTotalAdicionais());
                System.out.println("==== PREÇO ====");
                System.out.println("Preço combo: " + this.getPrecoTotalCombo());
                System.out.println("Preço Adicionais: " + this.getPrecoTotalAdicionais());
                System.out.println("Preço Pedido: " + this.getPrecoTotalPedido());
                System.out.println("Comissão do Garçom: " + comGarcom);
                System.out.println("\n\n\n");

                do {
                    System.out.println("""

                            Como deseja pagar?
                            1- Débito
                            2- Crédito
                            3- Dinheiro
                            4- Pix - Desconto de 10 Porcento
                            """);
                    formaPagamento = scan.nextInt();
                    switch (formaPagamento) {
                        case 1 -> {
                            System.out.println("\n\nPago no Débito");
                            System.out.println("Encerrado Atendimento!!!");
                        }
                        case 2 -> {
                            System.out.println("\n\nPago no Crédito");
                            System.out.println("Encerrado Atendimento!!!");
                        }
                        case 3 -> {
                            System.out.println("\n\nPago no Dinheiro");
                            System.out.println("Encerrado Atendimento!!!");
                        }
                        case 4 -> {
                            float descontoPix = getPrecoTotalPedido() - (getPrecoTotalPedido() / 10);
                            float novoPreco = getPrecoTotalPedido() / descontoPix;
                            System.out.println("Novo Preço a ser pago: " + novoPreco);
                            System.out.println("\n\nPago no Pix");
                            System.out.println("Encerrado Atendimento!!!");
                        }
                        default -> System.out.println("Escolha uma opção válida");
                    }
                }while(formaPagamento != 1 && formaPagamento != 2 && formaPagamento != 3 && formaPagamento != 4);
            } else {
                System.out.println("Aguardando fechamento da conta...\n");
            }
        } while (fConta != 1);
    }

    protected void fazerPedido(){

                Garcom gar = new Garcom();
                Cozinha coz = new Cozinha();
                Cardapio card = new Cardapio();
                int lerqradicacom, lerqradicbeb, lerqradicsob, lerQham , lerQbeb, lerQacom, lerQsob,  lerAdicHam, lerAdicSorv, lerAdicBat, lerAdicBeb, lerBeb, lerAcom, lerSob, lerHam, lerAcard, lerqradicham;

                do {
                    System.out.println("=== RESTAURANTE ===");
                    System.out.println("Abra o cardápio\n" +
                            "1- Abrir cardápio.");
                    lerAcard = scan.nextInt();

                    if (lerAcard == 1) {
                        card.abrirCardapio();
                        card.mostrarCardapio();
                    } else {
                        System.out.println("Opção Inválida.\n" +
                                "Aperte 1 para abrir o cardápio");
                    }
                } while (lerAcard != 1);

                do {
                    System.out.println("\nGostaria de hambúguer?");
                    System.out.println("1- Sim");
                    System.out.println("2- Não");
                    lerQham = scan.nextInt();

                    if (lerQham == 1) {

                        do {
                            card.cardham();
                            System.out.println("\nQual Hamburguer deseja?");
                            lerHam = scan.nextInt();
                            gar.escolherHamburguer(lerHam);
                            if(lerHam >= 1 && lerHam <= 5){
                                do {
                                    System.out.println("""
                                Gostaria de ver os adicionais do hamburguer?
                                1- Sim
                                2- Não
                                """);
                                    lerqradicham = scan.nextInt();
                                    if(lerqradicham == 1){
                                        do{
                                            card.cardhamadic();
                                            System.out.println("\nQual adicional de hamburguer deseja?");
                                            lerAdicHam = scan.nextInt();
                                            gar.escolherAdicionalHamb(lerAdicHam);

                                            if(lerAdicHam == 1 || lerAdicHam == 2){
                                                System.out.println("Anotado");
                                            } else if (lerAdicHam == 3){
                                                System.out.println("Okay");
                                            }else{
                                                System.out.println("Escolha uma opção válida\n");
                                            }
                                        }while(lerAdicHam != 1 && lerAdicHam != 2 && lerAdicHam != 3);
                                    }else if (lerqradicham == 2){
                                        System.out.println("Sem adicional de hamburguer");

                                    } else{
                                        System.out.println("Escolha uma opção válida");
                                    }
                                }while(lerqradicham != 1 && lerqradicham != 2);
                            } else {
                                System.out.println("Escolha uma opção válida");
                            }
                        } while (lerHam != 1 && lerHam != 2 && lerHam != 3 && lerHam != 4 && lerHam != 5);
                    } else if (lerQham == 2) {
                        System.out.println("Sem Hambúrguer\n");
                    } else {
                        System.out.println("Escolha uma opção válida\n");
                    }
                } while (lerQham != 1 && lerQham != 2);

                do {
                    System.out.println("\nGostaria de Bebida?");
                    System.out.println("1- Sim");
                    System.out.println("2- Não");
                    lerQbeb = scan.nextInt();
                    if (lerQbeb == 1) {
                        do {
                            card.cardbeb();
                            System.out.println("\nQual Bebida deseja?");
                            lerBeb = scan.nextInt();
                            gar.escolherBebida(lerBeb);
                            if(lerBeb >= 1 && lerBeb <= 5){
                                do {
                                    System.out.println("""
                                Gostaria de ver os adicionais da Bebida?
                                1- Sim
                                2- Não
                                """);
                                    lerqradicbeb = scan.nextInt();
                                    if(lerqradicbeb == 1){
                                        do{
                                            card.cardbebadic();
                                            System.out.println("\nQual adicional de Bebida deseja?");
                                            lerAdicBeb = scan.nextInt();
                                            gar.escolherAdicionalBeb(lerAdicBeb);

                                            if(lerAdicBeb == 1){
                                                System.out.println("Anotado");
                                            } else if (lerAdicBeb == 2){
                                                System.out.println("\nOkay");
                                            }else{
                                                System.out.println("Escolha uma opção válida\n");
                                            }
                                        }while(lerAdicBeb != 1 && lerAdicBeb != 2);
                                    }else if (lerqradicbeb == 2){
                                        System.out.println("Sem adicional de Bebida");

                                    } else{
                                        System.out.println("Escolha uma opção válida");
                                    }
                                }while(lerqradicbeb != 1 && lerqradicbeb != 2);
                            }else {
                                System.out.println("Escolha uma opção válida");
                            }
                        } while (lerBeb != 1 && lerBeb != 2 && lerBeb != 3 && lerBeb != 4 && lerBeb != 5);
                    } else if (lerQbeb == 2) {
                        System.out.println("Sem Bebida\n");
                    } else {
                        System.out.println("Opção Inválida.\n" +
                                "Aperte 1 ou 2");
                    }
                } while (lerQbeb != 1 && lerQbeb != 2);
                do {
                    System.out.println("\nGostaria de Sobremesa?");
                    System.out.println("1- Sim");
                    System.out.println("2- Não");
                    lerQsob = scan.nextInt();

                    if (lerQsob == 1) {
                        do {
                            card.cardsobr();
                            System.out.println("\nQual Sobremesa deseja?");
                            lerSob = scan.nextInt();
                            gar.escolherSobremesa(lerSob);
                            if(lerSob >= 1 && lerSob <= 4){
                                do {
                                    System.out.println("""
                                Gostaria de ver os adicionais da Sobremesa?
                                1- Sim
                                2- Não
                                """);
                                    lerqradicsob = scan.nextInt();
                                    if(lerqradicsob == 1){
                                        do{
                                            card.cardsobradic();
                                            System.out.println("\nQual adicional da Sobremesa deseja?");
                                            lerAdicSorv = scan.nextInt();
                                            gar.escolherAdicionalSorv(lerAdicSorv);

                                            if(lerAdicSorv == 1 || lerAdicSorv == 2){
                                                System.out.println("Anotado");
                                            } else if (lerAdicSorv == 3){
                                                System.out.println("\nOkay");
                                            }else{
                                                System.out.println("Escolha uma opção válida\n");
                                            }
                                        }while(lerAdicSorv != 1 && lerAdicSorv != 2 && lerAdicSorv != 3);
                                    }else if (lerqradicsob == 2){
                                        System.out.println("Sem adicional de sobremesa");

                                    } else{
                                        System.out.println("Escolha uma opção válida");
                                    }
                                }while(lerqradicsob != 1 && lerqradicsob != 2);
                            }else {
                                System.out.println("Escolha uma opção válida");
                            }
                        } while (lerSob != 1 && lerSob != 2 && lerSob != 3 && lerSob != 4);
                    } else if (lerQsob == 2) {
                        System.out.println("Sem Sobremesa\n");
                    } else {
                        System.out.println("Opção Inválida.\n" +
                                "Aperte 1 ou 2");
                    }
                } while (lerQsob != 1 && lerQsob != 2);

                do {
                    System.out.println("\n Gostaria de Acompanhamento?");
                    System.out.println("1- Sim");
                    System.out.println("2- Não");
                    lerQacom = scan.nextInt();

                    if (lerQacom == 1) {
                        do {
                            card.cardacom();
                            System.out.println("\nQual Acompanhamento deseja?");
                            lerAcom = scan.nextInt();
                            gar.escolherAcompanhamento(lerAcom);
                            if(lerAcom >= 1 && lerAcom <= 3){
                                do {
                                    System.out.println("""
                                Gostaria de ver os adicionais do Acompanhamento?
                                1- Sim
                                2- Não
                                """);
                                    lerqradicacom = scan.nextInt();
                                    if(lerqradicacom == 1){
                                        do{
                                            card.cardacomadic();
                                            System.out.println("\nQual adicional do Acompanhamento deseja?");
                                            lerAdicBat = scan.nextInt();
                                            gar.escolherAdicionalBat(lerAdicBat);

                                            if(lerAdicBat == 1 || lerAdicBat == 2){
                                                System.out.println("Anotado");
                                            } else if (lerAdicBat == 3){
                                                System.out.println("\nOkay");
                                            }else{
                                                System.out.println("Escolha uma opção válida\n");
                                            }
                                        }while(lerAdicBat != 1 && lerAdicBat != 2 && lerAdicBat != 3);
                                    }else if (lerqradicacom == 2){
                                        System.out.println("Sem adicional de acompanhamento");

                                    } else{
                                        System.out.println("Escolha uma opção válida");
                                    }
                                }while(lerqradicacom != 1 && lerqradicacom != 2);
                            }else {
                                System.out.println("Escolha uma opção válida");
                            }
                        } while (lerAcom != 1 && lerAcom != 2 && lerAcom != 3);
                    } else if (lerQacom == 2) {
                        System.out.println("Sem Acompanhamento\n");
                    } else {
                        System.out.println("Opção Inválida.\n" +
                                "Aperte 1 ou 2");
                    }
                } while (lerQacom != 1 && lerQacom != 2);

                gar.mostrarPedido();
                coz.statusPedido();
                gar.entregue();
                fecharConta();

            }
        }
