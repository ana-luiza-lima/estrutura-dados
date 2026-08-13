public class ex10{

    static void main(){
        Vetor<Produto> estoque = new Vetor<>(10);

        estoque.inserir(new Produto(1, "monitor", 500));
        estoque.inserir(new Produto(1, "teclado", 300));
        estoque.inserir(new Produto(1, "mouse", 250));

        estoque.imprimir();
    }

    
}