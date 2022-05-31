import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        int FPS = 60;
        String jogo = "Xadrez";
        int larguraTela = 500;
        int alturaTela = 300;
        boolean paisagem = larguraTela >= alturaTela ? true : false;

        System.out.print("Rodando " + jogo + " a " + FPS + " frames por segundo ");
        System.out.print("em uma tela de " + larguraTela + " por " + alturaTela + " ");
        System.out.print("no modo ");
        if(paisagem) {
            System.out.print("paisagem.\n");
        }
        else {
            System.out.print("retrato.\n");
        }

        int movimentos = 10;

        while(movimentos > 0) {
            System.out.print("Qual peca voce gostaria de mexer? (t, b, c, R, D, ou p) ");
            char peca = scanner.nextLine().charAt(0);
            
            switch(peca) {
                case 't': System.out.println("Movida a torre.");
                        break;
                case 'b': System.out.println("Movido o bispo.");
                        break;
                case 'c': System.out.println("Movido o cavalo.");
                        break;
                case 'R': System.out.println("Movido o rei.");
                        break;
                case 'D': System.out.println("Movida a dama.");
                        break;
                case 'p': System.out.println("Movido o peao.");
                        break;
                default: System.out.println("Peca inserida invalida.");
            }

            movimentos--;
        }

        scanner.close();
    }

}