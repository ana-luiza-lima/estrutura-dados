package vetor;

public class Caixa<T> {

        private T valor;

        public void guardar (T elemento){
            this.valor = elemento;
        }

        public T abrir(){
            return this.valor;
        }

}
