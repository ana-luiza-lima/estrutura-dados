package vetor.testes;

public class teste {

    static void main() {
        String[] jogos = new String[10];

        int posicao = localizar("GTA-V", jogos);
        System.out.println(posicao);
    }
    public static int localizar(String jogo, String[] jogos) {

        for (int i = 0; i < jogos.length; i++) {
            if ( jogos[i] != null  && jogos[i].equals(jogo)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean existe(String jogo, String[] jogos) {
        for (int i = 0; i < jogos.length; i++) {
            if (jogos[i].equals(jogo)) {
                return true;
            }
        }
        return false;
    }

    public static String existeR(String jogo, String[] jogos) {
        for (int i = 0; i < jogos.length; i++) {
            if (jogos[i].equals(jogo)) {
                return jogos[i];
            }
        }
        return null;

    }




}
