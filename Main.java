public class Main {

    public static void main(String[] args) {
        int FPS = 60;
        String jogo = "Xadrez";
        int larguraTela = 500;
        int alturaTela = 300;
        boolean paisagem = larguraTela >= alturaTela ? true : false;

        System.out.print("Rodando " + jogo + " a " + FPS + " frames por segundo ");
        System.out.print("em uma tela de " + larguraTela + " por " + alturaTela + " ");
        System.out.print("no modo ");
        if(paisagem) {
            System.out.print("paisagem.");
        }
        else {
            System.out.print("retrato.");
        }
    }

}