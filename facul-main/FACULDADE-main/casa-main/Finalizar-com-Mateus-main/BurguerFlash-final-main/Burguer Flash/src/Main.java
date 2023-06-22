import com.sun.security.jgss.GSSUtil;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Pagamento pag = new Pagamento();
        Garcom gar = new Garcom();
        Cozinha coz = new Cozinha();
        Cardapio card = new Cardapio();
        Cliente cli = new Cliente();
        int lerQham, lerQbeb, lerQacom, lerQsob, lerQradic, lerQradicMais, lerQladic, lerQladicmais, lerAdicHam, lerAdicSorv, lerAdicBat, lerAdicBeb, lerBeb, lerAcom, lerSob, lerHam, lerAcard;

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
        } while(lerAcard != 1);

        do {
            System.out.println("Gostaria de hambúguer?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            lerQham = scan.nextInt();

            if (lerQham == 1) {
                do {
                System.out.println("Qual Hamburguer deseja?");
                lerHam = 0;
                lerHam = scan.nextInt();
                card.escolherHamburguer(lerHam);
                }while (lerHam != 1 && lerHam != 2 && lerHam != 3 && lerHam != 4 && lerHam != 5);
            } else if (lerQham == 2){
                System.out.println("Sem Hambúrguer\n");
            } else {
                System.out.println("escolha nao valida");
            }
        } while(lerQham != 1 && lerQham != 2);

        do {
            System.out.println("Gostaria de Bebida?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            lerQbeb = scan.nextInt();
            if (lerQbeb == 1) {
                do {
                    System.out.println("Qual deseja?");
                    lerBeb = 0;
                    lerBeb = scan.nextInt();
                    card.escolherBebida(lerBeb);
                }while (lerBeb != 1 && lerBeb != 2 && lerBeb != 3 && lerBeb != 4 && lerBeb != 5) ;
            } else if (lerQbeb == 2) {
                    System.out.println("Sem Bebida\n");
            } else {
                    System.out.println("Opção Inválida.\n" +
                            "Aperte 1 ou 2");
                }
        } while(lerQbeb != 1 && lerQbeb != 2);
        do {
            System.out.println("Gostaria de Sobremesa?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            lerQsob = scan.nextInt();

            if (lerQsob == 1) {
                do {
                    System.out.println("Qual deseja?");
                    lerSob = 0;
                    lerSob = scan.nextInt();
                    card.escolherSobremesa(lerSob);
                }while (lerSob != 1 && lerSob != 2 && lerSob != 3 && lerSob != 4);
            } else if(lerQsob == 2){
                System.out.println("Sem Sobremesa\n");
            } else {
                System.out.println("Opção Inválida.\n" +
                        "Aperte 1 ou 2");
            }
        } while(lerQsob != 1 && lerQsob != 2);

        do {
            System.out.println("Gostaria de Acompanhamento?");
            System.out.println("1- Sim");
            System.out.println("2- Não");
            lerQacom = scan.nextInt();

            if (lerQacom == 1) {
                do{
                System.out.println("Qual deseja?");
                lerAcom = 0;
                lerAcom = scan.nextInt();
                card.escolherAcompanhamento(lerAcom);
                }while (lerAcom != 1 && lerAcom != 2 && lerAcom != 3);
            } else if(lerQacom == 2){
                System.out.println("Sem Acompanhamento\n");
            } else {
                System.out.println("Opção Inválida.\n" +
                        "Aperte 1 ou 2");
            }
        } while(lerQacom != 1 && lerQacom != 2);

        do{
            System.out.printf("Gostaria de ver os adicionais?\n" +
                    "1- Sim\n" +
                    "2- Não\n");
            lerQradic = scan.nextInt();
            if (lerQradic == 1){
                card.mostrarAdicionais();
                do{
                    System.out.println("Qual adicional deseja?(MAXIMO 2 - ESCOLHA UM POR VEZ)\n" +
                            "1- Adicional de Hamburguer\n" +
                            "2- Adicional de Batata\n" +
                            "3- Adicional de Sorvete\n" +
                            "4- Adicional de Bebida\n" +
                            "5- Sem Adicional\n");
                    lerQladic = scan.nextInt();

                    switch (lerQladic){
                        case 1:
                            do {
                                card.cardhamadic();
                                System.out.println("Qual adicional de hamburguer deseja?");
                                lerAdicHam = scan.nextInt();
                                if (lerAdicHam == 1 || lerAdicHam == 2){
                                    do {
                                        System.out.println("Anotado");
                                        System.out.println("\n\n Gostaria de mais Algum Adicional?\n" +
                                                "1- Sim\n" +
                                                "2- Não\n");
                                        lerQradicMais = scan.nextInt();
                                        if (lerQradicMais == 1){
                                            do {
                                                System.out.println("Qual adicional deseja?\n" +
                                                        "1- Adicional de Batata\n" +
                                                        "2- Adicional de Sorvete\n" +
                                                        "3- Adicional de Bebida");
                                                lerQladicmais = scan.nextInt();
                                                switch (lerQladicmais){
                                                        case 1:
                                                            do {
                                                                card.cardacomadic();
                                                                System.out.println("Qual adicional de batata deseja?");
                                                                lerAdicBat = scan.nextInt();
                                                            }while (lerAdicBat != 1 && lerAdicBat != 2);
                                                            break;
                                                        case 2:
                                                            do {
                                                                card.cardsobradic();
                                                                System.out.println("Qual adicional de sorvete deseja?");
                                                                lerAdicSorv = scan.nextInt();

                                                            }while(lerAdicSorv != 1 && lerAdicSorv != 2);
                                                            break;
                                                        case 3:
                                                            do {
                                                                card.cardbebadic();
                                                                System.out.println("Qual adicional de bebida deseja?");
                                                                lerAdicBeb = scan.nextInt();
                                                            }while(lerAdicBeb != 1);
                                                            break;
                                                        default:
                                                            System.out.println("Escolha uma opção válida");
                                                }
                                            }while(lerQladicmais != 1 && lerQladicmais != 2 && lerQladicmais != 3);
                                        }else if (lerQradicMais == 2){
                                            System.out.println("Sem adicional extra");
                                        } else {
                                            System.out.println("Escolha uma opção válida");
                                        }
                                    }while(lerQradicMais != 1 && lerQradicMais != 2);
                                }else {
                                    System.out.println("Escolha uma opção válida");
                                }
                            }while(lerAdicHam != 1 && lerAdicHam != 2);
                    }
                }while (lerQladic != 1 && lerQladic != 2 && lerQladic != 3 && lerQladic != 4 && lerQladic != 5);

            }else if(lerQradic == 2){
                System.out.println("Sem Adicional");
            }else {
                System.out.println("Escolha uma opção válida");
            }
        }while(lerQradic != 1 && lerQradic != 2);
    }
}