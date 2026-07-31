
public class VetorEstatico {

    private String[] elementos;
    private int tamanho;

    
    public VetorEstatico(int quantidade){
        elementos = new String[quantidade];
        this.tamanho = 0;
    }

    public int obterTamanho(){
        return this.tamanho;
    }

    public void inserir(String elemento){
        if(tamanho < elementos.length){
            elementos[tamanho] = elemento;
            tamanho++;
        }else{
            System.out.println("Não existe posição disponível");
        }
    }

    public void inserir(int indice, String elemento){
        if(tamanho >= elementos.length){
            System.out.println("Vetor cheio!");
        }
        if(indice < 0|| indice > elementos.length) {
            System.out.println("Posição Inválida!");
        }
        for(int i = tamanho; i > indice; i--){
            elementos[i] = elementos[i-1];
        }
        elementos[indice] = elemento;
        tamanho++;
    }

    public void remover(){
        if(tamanho != 0){
            tamanho--;
            elementos[tamanho] = null;
        }
        
    }

    // public void inserir(String elemento){
    //     for (int i = 0; i < elementos.length; i++){
    //         if(elementos[i] == null){
    //             elementos[i] = elemento;
    //             return;
    //         }
    //     }
    //     System.out.println("Não existe posição disponível");
    // }

    public void imprimir(){
        if(tamanho != 0){
            System.out.print("[");
            for (int i =0; i< elementos.length; i++){
                if(elementos[i] != null){
                    System.out.print(elementos[i]);
                }
                if(i < tamanho -1){
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } else {
            System.out.println("Array vazio");
        }
        
    }
    
}