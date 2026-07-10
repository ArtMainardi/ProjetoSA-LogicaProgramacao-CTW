package projetoSA.util;

public class Style {
    // Procedimento que cria um quadro com um texto no centro:
    public void quadro(String frase){
        // Tamanho da frase:
        int tmh = frase.length();

        System.out.println("┌" + repetir("─", (tmh + 10) + "");
    }

    // Método que retorna String repetida:
    public String repetir(String valor, int repeticoes){
        String novoValor = "";
        for(int cont = 0; cont < repeticoes; cont++){
            novoValor += valor;
        }
        return novoValor;
    }
}
